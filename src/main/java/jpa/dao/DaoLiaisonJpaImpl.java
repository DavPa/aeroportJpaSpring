package jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jpa.model.Liaison;


@Repository
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DaoLiaisonJpaImpl implements DaoLiaison {
	
	@PersistenceContext
	EntityManager em =null;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void insert(Liaison obj) {
			em.persist(obj); 
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Liaison update(Liaison obj) {
		Liaison s = null;
		s = em.merge(obj);
		return s;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Liaison obj) {
			em.remove(em);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteByKey(Integer key) {
			em.remove(em);
		
	}

	@Override
	public Liaison findByKey(Integer key) {
		Liaison recherche = null;
		recherche = em.find(Liaison.class, key);
		em.close();
		return recherche;
	}

	@Override
	public List<Liaison> findAll() {
		List<Liaison> enseignements = null;
		Query query= em.createQuery("from Liaison m");
		enseignements = query.getResultList();
		em.close();
		return enseignements;
	}

}
