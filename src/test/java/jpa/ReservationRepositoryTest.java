package jpa;
import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jpa.model.Passager;
import jpa.model.Reservations;
import jpa.repository.PassagerRepository;
import jpa.repository.ReservationRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/application-context.xml"})

public class ReservationRepositoryTest {

	@Autowired
	private ReservationRepository reservationRepository ; 
	@Test
	public void testInsert() {
		Reservations reservation  = new Reservations ();
	     reservation.setNumero(20);
		reservationRepository.save(reservation);
		Optional<Reservations> opt=reservationRepository.findById(reservation.getId());
		assertTrue(opt.isPresent());
	}
	
}
