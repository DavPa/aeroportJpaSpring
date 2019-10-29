package jpa;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jpa.model.Client;
import jpa.model.ClientPhysique;
import jpa.model.CompagnieAerienne;
import jpa.repository.ClientRepository;
import jpa.repository.CompagnieAerienneRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/application-context.xml"})
public class ClientRepositoryTest {
	
	@Autowired
	public ClientRepository clientRepository;
	
	@Test
	public void test() {
		ClientPhysique clientPhysique = new ClientPhysique();
		clientPhysique.setNom("Kevin");
		clientRepository.save(clientPhysique);
		Optional<Client> opt = clientRepository.findById(clientPhysique.getId());
		assertTrue(opt.isPresent());
	
}
}
