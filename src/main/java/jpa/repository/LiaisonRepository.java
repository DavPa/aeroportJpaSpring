package jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.model.Liaison;

public interface LiaisonRepository extends JpaRepository<Liaison, Integer>{
	
	public Liaison findByKey(Integer key);
}
