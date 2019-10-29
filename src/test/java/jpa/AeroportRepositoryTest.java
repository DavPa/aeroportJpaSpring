package jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jpa.model.Aeroport;
import jpa.repository.AeroportRepository;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/application-context.xml"})
public class AeroportRepositoryTest {

	
	@Autowired
	private AeroportRepository aeroportRepository;
	
	@Test
	public void testInsert() {
		Aeroport aeroport = new Aeroport("aeroportCDG");;
		aeroportRepository.save(aeroport);
		
		Aeroport aeroport2 = new Aeroport("aeroport2");;
		aeroportRepository.save(aeroport2);
	}
	
}
