package model;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import control.Treinador;

public class MTreinador {

	public boolean cadastrar(Treinador t) {
		Session session;
		try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(t);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			System.out.println("Erro: " + e.toString());
			return false;
		}
	}

	public boolean atualizar(Treinador t) {
		Session session;
		try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(t);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	public Treinador autenticar(Treinador t) {

		Session session = null;
		try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
			session = sessionFactory.openSession();
			session.beginTransaction();

			String sql = "SELECT t FROM Treinador t where nome like '" + t.getNome() + "' and senha like '"
					+ t.getSenha() + "'";
			List<Treinador> l = session.createQuery(sql, Treinador.class).getResultList();
			session.close();
			if (l.size() == 1) {
				return l.get(0);
			} else {
				return null;
			}
		} catch (HibernateException e) {
			return null;
		}

	}

	public Treinador buscar(Integer id) {
		Treinador resposta = null;
		Session session;
		try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
			session = sessionFactory.openSession();
			session.beginTransaction();
			resposta = session.find(Treinador.class, id);
			session.close();
		} catch (HibernateException e) {
			System.out.println("Erro: " + e.toString());
		}
		return resposta;

	}

	public boolean deletar(Treinador t) {
		Session session;
		try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(t);
			;
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}
}
