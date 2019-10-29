package jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jpa.model.CompagnieAerienne;

public class DaoCompagnieAerienneJpaImpl implements DaoCompagnieAerienne{
	
	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void insert(CompagnieAerienne obj) {
		em.persist(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public CompagnieAerienne update(CompagnieAerienne obj) {
		CompagnieAerienne a = null;
		a = em.merge(obj);
		return a;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(CompagnieAerienne obj) {
		CompagnieAerienne a = em.merge(obj);
		em.remove(a);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteByKey(Long key) {
		CompagnieAerienne a = em.find(CompagnieAerienne.class, key);
		em.remove(a);
	}

	@Override
	public CompagnieAerienne findByKey(Long key) {
		CompagnieAerienne a = null;
		a = em.find(CompagnieAerienne.class, key);
		return a;
	}

	@Override
	public List<CompagnieAerienne> findAll() {
		List<CompagnieAerienne> CompagnieAeriennes = null;
		Query query = em.createQuery("from Personne p");
		CompagnieAeriennes = query.getResultList();
		return CompagnieAeriennes;
	}

}
