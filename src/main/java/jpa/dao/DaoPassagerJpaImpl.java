package jpa.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jpa.model.Passager;
import jpa.model.Reservation;



@Repository
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class DaoPassagerJpaImpl implements DaoPassager{

	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void insert(Passager obj) {
		
			em.persist(obj);
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)

	public Passager update(Passager obj) {
		Passager p = null;
		
			p = em.merge(obj);
			
		return p;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)

	public void delete(Passager obj) {
		
		 Passager p= em.merge(obj);
		 for (Reservation r : p.getReservations()) {
				r.setPassager(null);
			}
		 em.remove(p);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteByKey(Integer key) {
		
		
			Passager p=em.find(Passager.class, key);
			 for (Reservation r : p.getReservations()) {
					r.setPassager(null);
				}
			 em.remove(p);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)

	public Passager findByKey(Integer key) {
		
		Passager p = null;
		p = em.find(Passager.class, key);
		
		return p;
	}

	@Override
	public List<Passager> findAll() {
		List<Passager> passagers = null;
		Query query = em.createQuery("from Passager p");
		passagers = query.getResultList();
	
		return passagers;
	}
	
}
