package jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jpa.model.Ville;
import jpa.repository.VilleRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/application-context.xml"})
public class VilleRepositoryTest {

	
	@Autowired
	private VilleRepository villeRepository;
	
	@Test
	public void testInsert() {
		Ville ville = new Ville("Paris");;
		villeRepository.save(ville);
		villeRepository.findById(ville.getId());
		// permet verifier si la ville a été creer
		Optional<Ville> opt = villeRepository.findById(ville.getId());
		assertTrue(opt.isPresent());
		
		Ville ville1 = new Ville("Londres");;
		villeRepository.save(ville1);
		Ville ville2 = new Ville("ville1");;
		villeRepository.save(ville2);
	}
	
//	@Test
//	public void testFindAll() {
//		Pageable page0Avec2element = PageRequest.of(0, 2);
//		Page<Ville> page = villeRepository.findAll(page0Avec2element);
//		assertEquals(2, page.getContent().size());
//		System.out.println(page);
//		System.out.println(page.nextPageable());
//		page = villeRepository.findAll(page.nextPageable());
//		System.out.println(page);
//		
//	}

	
//	@Test
//	public void testFindByNom() {
//		assertTrue(villeRepository.findByNom("Paris").isPresent());
//	}
	
	
	
	
	
	
}
