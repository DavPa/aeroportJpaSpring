package jpa;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jpa.model.Aeroport;
import jpa.model.Liaison;
import jpa.model.LiaisonPK;
import jpa.model.Ville;
import jpa.repository.AeroportRepository;
import jpa.repository.LiaisonRepository;
import jpa.repository.VilleRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/application-context.xml"})
public class LiaisonRepositoryTest {
	
	@Autowired
	private VilleRepository villeRepository;
	@Autowired
	private AeroportRepository aeroportRepository;
	@Autowired
	private LiaisonRepository liaisonRepository;
	
	@Test
	public void testInsert() {
		Ville ville = new Ville("Londres");;
		villeRepository.save(ville);
		Ville ville1 = new Ville("Paris");;
		villeRepository.save(ville1);
		Ville ville2 = new Ville("Ville1");;
		villeRepository.save(ville2);
		
		
		Aeroport aeroport = new Aeroport("aeroportJFK");;
		aeroportRepository.save(aeroport);
		Aeroport aeroport2 = new Aeroport("aeroport2");;
		aeroportRepository.save(aeroport2);
		Aeroport aeroport3 = new Aeroport("aeroport3");;
		aeroportRepository.save(aeroport3);
		
		Liaison liaison = new Liaison(new LiaisonPK(aeroport, ville));
		liaisonRepository.save(liaison);
;		
	}
}
