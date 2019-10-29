package jpa;

import static org.junit.Assert.*;

import java.util.Optional;

import jpa.repository.CompagnieAerienneRepository;
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

import jpa.model.CompagnieAerienne;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/application-context.xml"})
public class CompagnieAerienneRepositoryTest {

	@Autowired
	public CompagnieAerienneRepository CompagnieAerienneRepository;
	
	@Test
	public void test() {
		CompagnieAerienne CompagnieAerienne = new CompagnieAerienne();
		CompagnieAerienne.setNom("Air France");
		CompagnieAerienneRepository.save(CompagnieAerienne);
		Optional<CompagnieAerienne> opt = CompagnieAerienneRepository.findById(CompagnieAerienne.getId());
		assertTrue(opt.isPresent());
	}
	
//	@Test
//	public void testFindAll() {
//		Pageable page0Avec2Element = PageRequest.of(0, 2, Sort.by(Order.asc("nom")));
//		Page<CompagnieAerienne> page = CompagnieAerienneRepository.findAll(page0Avec2Element);
//		assertEquals(2, page.getContent().size());
//		System.out.println(page);
//		System.out.println(page.nextPageable());
//		CompagnieAerienneRepository.findAll(page.nextPageable());
//		System.out.println(page);
//	}
//	
//	@Test
//	public void testFindByNom() {
//		assertTrue(CompagnieAerienneRepository.findByNom("CompagnieAerienne a").isPresent());
//	}
//	
//	@Test
//	public void testFindCustomByNom() {
//		assertNotEquals(0, CompagnieAerienneRepository.findAllCustomByNomDeLaCompagnieAerienne("CompagnieAerienne a"));
//	}
//	
//	@Test
//	public void testFindByIdWithPersonne() {
//		Optional<CompagnieAerienne> opt = CompagnieAerienneRepository.findByIdWithPersonnes(101);
//		assertNotEquals(0, opt.isPresent());
//		assertNotEquals(0, opt.get().getPersonnes().size()); 
//	}

} 
