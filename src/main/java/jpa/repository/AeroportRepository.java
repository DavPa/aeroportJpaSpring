package jpa.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jpa.model.Aeroport;
import jpa.model.Liaison;


public interface AeroportRepository extends JpaRepository<Aeroport, Integer> {

	public Optional<Aeroport> findByNom(String nom);

	public List<Aeroport> findByNomLike(String nom);
	
	
	//@Query("select a from Aeroport a where s.nom=:nomDeLAeroport")
	//public List<Aeroport> findCustomByNomDeLAeroport(@Param("nomDeLAeroport") String nomDeLAeroport);
	
	//toutes les villes dun aeroport
	//@Query("select a from Aeroport a left join fetch a.liaisons l left join fetch l.key.ville v where a.nom=:nomAeroport ")
	//public Set<Liaison> findByNomWithVille(@Param("Aeroport") String nom);
	
}
