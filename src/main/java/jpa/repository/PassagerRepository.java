package jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jpa.model.Passager;

public interface PassagerRepository extends JpaRepository<Passager,Integer> {

     public Optional <Passager>findByNom(String nom);

//	@Query("select distinct p from Passager  p left join fetch p.reservations")
// 	public List<Passager> findALLCustomWithReservation();
     @Query("select distinct p from  Passager p left join fetch p.reservations where p.id=:id")
    public Optional <Passager>findByIdWithReservation(@Param("id") Integer id);
	@Query("select distinct p from  Passager p left join fetch p.vol where p.id=:id")
	 public Optional <Passager>findByIdWithVol(@Param("id") Long id);
}
