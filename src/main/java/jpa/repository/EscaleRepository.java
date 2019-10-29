package jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.model.Escale;
import jpa.model.EscalePk;

public interface EscaleRepository extends JpaRepository<Escale, EscalePk>{

}
