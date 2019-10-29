package jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation ,Long> {

}
