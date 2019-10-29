package jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jpa.model.Ville;

public interface VilleRepository extends JpaRepository<Ville, Integer> {

		public Optional<Ville> findByNom(String nom);

		public List<Ville> findByNomLike(String nom);
		
		@Query("select v from Ville v where s.nom=:nomDeLaVille")
		public List<Ville> findCustomByNomDeLaVille(@Param("nomDeLaVille") String nomDeLaVille);
		
}