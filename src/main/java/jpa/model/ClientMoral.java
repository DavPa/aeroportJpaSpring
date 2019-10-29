package jpa.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("M")
public class ClientMoral extends Client {
	@Enumerated(EnumType.STRING)
	@Column(name = "titre", length = 4)
	private TitreMoral titre;
	@Column(name = "siret", length = 20)
	private String siret;
	
	// Constructeur : 
	
	public ClientMoral() {
		
	}
	
	public ClientMoral(TitreMoral titre, String siret, Long id, String nom, Integer numeroTel, Integer numeroFax, String email, Adresse adresse, Set<Reservations> reservations) {
		super();
		this.titre = titre;
		this.siret = siret;
	}

	public TitreMoral getTitre() {
		return titre;
	}

	public void setTitre(TitreMoral titre) {
		this.titre = titre;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}
	
	
	
}
