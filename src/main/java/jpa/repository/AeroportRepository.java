package jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.model.Aeroport;
import jpa.model.Ville;

public interface AeroportRepository extends JpaRepository<Aeroport, Integer> {

	public Optional<Aeroport> findByNom(String nom);

	public List<Aeroport> findByNomLike(String nom);
}
