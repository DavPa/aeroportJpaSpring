package jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jpa.model.Reservations;

public interface ReservationRepository extends JpaRepository<Reservations ,Long> {

//	
//    @Query("select distinct r from  Reservation r left join fetch r.client where r.id=:id")
//
//	public Optional <Reservations>findByIdWithClient(@Param("id") Integer id);
	
    
	
	
	
}
