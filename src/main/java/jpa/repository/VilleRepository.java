package jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.model.Ville;

public interface VilleRepository extends JpaRepository<Ville, Integer> {

		public Optional<Ville> findByNom(String nom);

		public List<Ville> findByNomLike(String nom);
		
}