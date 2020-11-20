package model;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import control.Tipo;

public class MTipo {
	public Tipo buscarTipo(String tipo) {
		Tipo resposta = null;
		Session session;
		try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
			session = sessionFactory.openSession();
			session.beginTransaction();
			String sql = "SELECT t FROM Tipos t where tipo = '" + tipo + "'";
			List<Tipo> results = session.createQuery(sql, Tipo.class).getResultList();
			resposta = results.get(0);
			session.close();
		} catch (HibernateException e) {
			System.out.println("Erro: " + e.toString());
		}
		return resposta;
	}

	public Tipo buscarTipo(Integer id) {
		Tipo resposta = null;
		Session session;
		try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
			session = sessionFactory.openSession();
			session.beginTransaction();
			resposta = session.find(Tipo.class, id);
			session.close();
		} catch (HibernateException e) {
			System.out.println("Erro: " + e.toString());
		}
		return resposta;
	}

	public List<Tipo> buscarFraquezas(Tipo tipo1, Tipo tipo2) {
		List<Tipo> resposta = null;
		Session session;
		try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
			session = sessionFactory.openSession();
			session.beginTransaction();
			String sql = "SELECT t FROM Tipos t where def_" + tipo1 + "*def_" + tipo2 + ">1";
			resposta = session.createQuery(sql, Tipo.class).getResultList();
			session.close();
		} catch (HibernateException e) {
			System.out.println("Erro: " + e.toString());
		}
		return resposta;
	}

	public List<Tipo> buscarResistencias(Tipo tipo1, Tipo tipo2) {
		List<Tipo> resposta = null;
		Session session;
		try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
			session = sessionFactory.openSession();
			session.beginTransaction();
			String sql = "SELECT t FROM Tipos t where def_" + tipo1 + "*def_" + tipo2 + "<1 AND def_" + tipo1 + "*def_"
					+ tipo2 + "!=0";
			resposta = session.createQuery(sql, Tipo.class).getResultList();
			session.close();
		} catch (HibernateException e) {
			System.out.println("Erro: " + e.toString());
		}
		return resposta;
	}

	public List<Tipo> buscarImunidades(Tipo tipo1, Tipo tipo2) {
		List<Tipo> resposta = null;
		Session session;
		try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
			session = sessionFactory.openSession();
			session.beginTransaction();
			String sql = "SELECT t FROM Tipos t where def_" + tipo1 + "*def_" + tipo2 + "=0";
			resposta = session.createQuery(sql, Tipo.class).getResultList();
			session.close();
		} catch (HibernateException e) {
			System.out.println("Erro: " + e.toString());
		}
		return resposta;
	}
}
