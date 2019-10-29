package jpa;
import static org.junit.Assert.*;

import java.util.Optional;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import formationJpaSpring.model.Salle;
import jpa.model.Passager;
import jpa.repository.PassagerRepository;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/application-context.xml"})
public class PassagerRepositoryTest {
	@Autowired
	private PassagerRepository passagerRepository ; 
	@Test
public void testInsert() {
	Passager passager = new Passager ("passager Repo");
	passagerRepository.save(passager);
	Optional<Passager> opt=passagerRepository.findById(passager.getId());
	assertTrue(opt.isPresent());
		
	}
//	@Test
//	public void testfindByNom () {
//		assertTrue(passagerRepository.findByNom("x").isPresent());
//	}
	@Test
	public void testindByIdWithReservation() {
		Optional<Passager> opt = passagerRepository.findByIdWithReservation(100)(100);
		assertNotEquals(0, opt.get().getReservations()().size());
	}
	
	
}
