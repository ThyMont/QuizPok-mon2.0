package model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import control.Registro;
import control.Treinador;

public class MRegistro {

	public boolean registrar(Registro r) {
		Session session;
		try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
			session = sessionFactory.openSession();
			session.beginTransaction();
			String sql = "SELECT r FROM Registro r where treinador_id = " + r.getTreinador().getId()
					+ " AND pokemon_id = " + r.getPokemon().getId();
			List<Registro> lista = session.createQuery(sql, Registro.class).getResultList();
			if (lista.size() == 0) {
				session.save(r);
				session.getTransaction().commit();
				session.close();
				return true;
			} else {
				session.update(r);
				session.close();
				return false;
			}

		} catch (HibernateException e) {
			return false;
		}
	}

	public List<Registro> listarTodos(Treinador t) {
		Session session;
		List<Registro> resposta = new ArrayList<Registro>();
		try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
			session = sessionFactory.openSession();
			session.beginTransaction();
			String sql = "SELECT r FROM Registro r where treinador_id = " + t.getId() + "";
			resposta = session.createQuery(sql, Registro.class).getResultList();
			session.close();
			return resposta;

		} catch (HibernateException e) {
			return resposta;
		}
	}

	public boolean deletar(Treinador t) {
		Session session;
		try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
			session = sessionFactory.openSession();
			session.beginTransaction();
			String sql = "DELETE r FROM Registro r where treinador_id = " + t.getId() + "";
			session.createQuery(sql, Registro.class);
			session.close();
			return true;

		} catch (HibernateException e) {
			return false;
		}
	}
}
