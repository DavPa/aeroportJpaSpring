package jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jpa.model.Ville;


@Repository
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DaoVilleJpaImpl implements DaoVille {
	
	@PersistenceContext
	EntityManager em =null;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void insert(Ville obj) {	
			em.persist(obj); 
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Ville update(Ville obj) {
		Ville v = null;
		v = em.merge(obj);
		return v;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Ville obj) {
			em.remove(em.merge(obj));
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteByKey(Integer key) {
			em.remove(em.find(Ville.class, key));
	}

	@Override
	public Ville findByKey(Integer key) {
		Ville recherche = null;
		recherche = em.find(Ville.class, key);
		em.close();
		return recherche;
	}

	@Override
	public List<Ville> findAll() {
		List<Ville> villes = null;
		Query query= em.createQuery("from Ville p");
		villes = query.getResultList();
		em.close();
		return villes;
	}

}
