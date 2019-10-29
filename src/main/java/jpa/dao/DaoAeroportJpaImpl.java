package jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jpa.model.Aeroport;

@Repository
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DaoAeroportJpaImpl implements DaoAeroport {
	
		
	EntityManager em =null;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void insert(Aeroport obj) {
			em.persist(obj); 
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Aeroport update(Aeroport obj) {
		Aeroport a = null;
		a = em.merge(obj);
		return a;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Aeroport obj) {
			em.remove(em.merge(obj));
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteByKey(Integer key) {
			em.remove(em.find(Aeroport.class, key));

	}

	@Override
	public Aeroport findByKey(Integer key) {
		Aeroport recherche = null;
		recherche = em.find(Aeroport.class, key);
		em.close();
		return recherche;
	}

	@Override
	public List<Aeroport> findAll() {
		List<Aeroport> aeroports = null;
		Query query= em.createQuery("from Personne p");
		aeroports = query.getResultList();
		em.close();
		return aeroports;
	}

}
