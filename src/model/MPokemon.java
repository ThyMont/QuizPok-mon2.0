package model;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import control.Pokemon;
import control.Tipo;

public class MPokemon {
	// Cadastrar pokemon
	public MPokemon() {
	}

	public boolean cadastrar(Pokemon p) {
		Session session;
		try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(p);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			System.out.println("Erro: " + e.toString());
			return false;
		}
	}

	public Pokemon buscar(Integer id) {
		Pokemon resposta = null;
		Session session;
		try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
			session = sessionFactory.openSession();
			session.beginTransaction();
			resposta = session.find(Pokemon.class, id);
			session.close();
		} catch (HibernateException e) {
			System.out.println("Erro: " + e.toString());
		}
		return resposta;
	}

	// Busca Pokemon por nome
	public List<Pokemon> buscar(String nome) {
		List<Pokemon> resposta = null;
		Session session;
		try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
			session = sessionFactory.openSession();
			session.beginTransaction();
			String sql = "SELECT p FROM Pokemon p where nome like '%" + nome + "%'";
			resposta = session.createQuery(sql, Pokemon.class).getResultList();
			session.close();
		} catch (HibernateException e) {
			System.out.println("Erro: " + e.toString());
		}
		return resposta;
	}

	public List<Pokemon> listarTodos() {
		List<Pokemon> resposta = null;
		Session session;
		try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
			session = sessionFactory.openSession();
			session.beginTransaction();
			String sql = "SELECT p FROM Pokemon p";
			resposta = session.createQuery(sql, Pokemon.class).getResultList();
			session.close();
		} catch (HibernateException e) {
			System.out.println("Erro: " + e.toString());
		}
		return resposta;
	}

	// Busca pokemon de 1 tipo
	public List<Pokemon> buscar(Tipo tipo) {
		List<Pokemon> resposta = null;
		Session session;
		try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
			session = sessionFactory.openSession();
			session.beginTransaction();
			String sql = "SELECT p FROM Pokemon p where tipo1 = " + tipo.getId() + " or tipo2 = " + tipo.getId();
			resposta = session.createQuery(sql, Pokemon.class).getResultList();
			session.close();
		} catch (HibernateException e) {
			System.out.println("Erro: " + e.toString());
		}
		return resposta;
	}

	// Buscar pokemon por dois tipos (independe da ordem)
	public List<Pokemon> buscar(Tipo tipo1, Tipo tipo2) {
		List<Pokemon> resposta = null;
		Session session;
		try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
			session = sessionFactory.openSession();
			session.beginTransaction();
			String sql = "SELECT p FROM Pokemon p where (tipo1 = " + tipo1.getId() + " or tipo2=" + tipo1.getId()
					+ ") AND (tipo1 = " + tipo2.getId() + " or tipo2=" + tipo2.getId() + "";
			resposta = session.createQuery(sql, Pokemon.class).getResultList();
			session.close();
		} catch (HibernateException e) {
			System.out.println("Erro: " + e.toString());
		}
		return resposta;
	}
}
