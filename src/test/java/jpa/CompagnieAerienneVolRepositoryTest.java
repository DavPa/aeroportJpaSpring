package jpa;

import static org.junit.Assert.*;

import java.util.Optional;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jpa.model.CompagnieAerienne;
import jpa.model.CompagnieAerienneVol;
import jpa.model.CompagnieAerienneVolPk;
import jpa.model.Vol;
import jpa.repository.CompagnieAerienneRepository;
import jpa.repository.CompagnieAerienneVolRepository;
import jpa.repository.VolRepository;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/application-context.xml"})
public class CompagnieAerienneVolRepositoryTest {

	@Autowired
	public CompagnieAerienneVolRepository compagnieAerienneVolRepository;
	@Autowired
	public CompagnieAerienneRepository compagnieAerienneRepository;
	@Autowired
	public VolRepository volRepository;
	
	@Test
	public void test() {
		CompagnieAerienne compagnieAerienne = new CompagnieAerienne("Air France");
		compagnieAerienneRepository.save(compagnieAerienne);
		Optional<CompagnieAerienne> optc = compagnieAerienneRepository.findById(compagnieAerienne.getId());
		assertTrue(optc.isPresent());
		
		Vol vol = new Vol();
		volRepository.save(vol);
		Optional<Vol> optv = volRepository.findById(vol.getId());
		assertTrue(optv.isPresent());
		
		CompagnieAerienneVol compagnieAerienneVol = new CompagnieAerienneVol();
		compagnieAerienneVol.setKey(new CompagnieAerienneVolPk(vol, compagnieAerienne));
		compagnieAerienneVolRepository.save(compagnieAerienneVol);
	}
	
} 
