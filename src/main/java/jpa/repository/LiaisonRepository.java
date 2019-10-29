package jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.model.Liaison;
import jpa.model.LiaisonPK;
public interface LiaisonRepository extends JpaRepository<Liaison, LiaisonPK>{
	
	public Liaison findByKey(Integer key);
}
