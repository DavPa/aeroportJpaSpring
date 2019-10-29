package jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
