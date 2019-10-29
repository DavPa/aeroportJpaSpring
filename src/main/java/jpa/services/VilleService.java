package jpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpa.repository.VilleRepository;


@Service
public class VilleService {

	@Autowired
	private VilleRepository villeRepository;
	
	@Test
	public void create(String nom) throws VilleCreationException{
		if (!nom.isEmpty()) {
			throw new SalleCreationException();
			}
		Salle salle =  new Salle(nom);
		salleRepository.save(salle);
		return salle;
		}
}
