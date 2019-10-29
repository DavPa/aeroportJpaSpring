 package jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import jpa.model.Client;
import jpa.util.EntityManagerFactorySingleton;

public class DaoClientJpacImpl implements DaoClient{

	@Override
	public void insert(Client obj) {
		EntityManager em = null;
		em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
		
	}

	@Override
	public Client update(Client obj) {
		Client a = null;
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			a = em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
		return a;
	}

	@Override
	public void delete(Client obj) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.merge(obj));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
		
	}

	@Override
	public void deleteByKey(Integer key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.find(Client.class, key));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
		
	}

	@Override
	public Client findByKey(Integer key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Client a = null;
		a = em.find(Client.class, key);
		em.close();
		return a;
	}

	@Override
	public List<Client> findAll() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<Client> clients = null;
		Query query = em.createQuery("from Client c");
		clients = query.getResultList();
		em.close();
		return clients;
	}


}
