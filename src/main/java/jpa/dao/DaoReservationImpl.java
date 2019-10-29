package jpa.dao;

import java.util.List;


import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jpa.model.Reservation;

@Repository
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class DaoReservationImpl implements DaoReservation {

	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)

	public void insert(Reservation obj) {
		
			em.persist(obj);
			
	}

	@Override
	public Reservation update(Reservation obj) {
		Reservation r = null;
		
			r = em.merge(obj);
			
		return r;
	}

	@Override
	public void delete(Reservation obj) {
		
		Reservation r = em.merge(obj);
		
		 em.remove(r);
	}

	


	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)

	public void deleteByKey(Long key) {
	
			Reservation r =em.find(Reservation.class, key);
			em.remove(r);

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)

	public Reservation findByKey(Long key) {
		Reservation r = null;
		r = em.find(Reservation.class, key);
		return r;
	}

	@Override
	public List<Reservation> findAll() {
		List<Reservation> reservations = null;
		Query query = em.createQuery("from Reservation r");
		reservations = query.getResultList();
		return reservations;
	}

//	public List<Reservation> findReservationByVol(Vol vol) {
//		List<Reservation> reservations = null;
//		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
//		Query query = em.createQuery("from Reservation r where lower(r.vol) like :vol");
//		query.setParameter("vol", vol.toLowerCase());
//		reservations = query.getResultList();
//		em.close();
//		return reservations;
//	}


	// public Reservation findByKeyWithClient(Integer key) {
	// EntityManager em =
	// EntityManagerFactorySingleton.getInstance().createEntityManager();
	// Reservation r = null;
	// Query query = em.createNamedQuery("select r reservation r left join fetch
	// r.client where r.id_client=:key");
	// query.setParameter("key", key);
	// try {
	// r = (Reservation) query.getSingleResult();
	// } catch (NoResultException e) {

	// }
	// em.close();
	// return r;
	// }
	
	

}
