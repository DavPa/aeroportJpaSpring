package jpa.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("P")
public class ClientPhysique extends Client {
	@Enumerated(EnumType.STRING)
	@Column(name = "titre", length = 4)
	private TitrePhysique titre;
	@Column(name = "prenom", length = 20)
	private String prenom;

	// Constructeur : 
	
	public ClientPhysique() {
		
	}
	
	public ClientPhysique(TitrePhysique titre, String prenom, Long id, String nom, Integer numTel, Integer numFax, String email, Adresse adresse, Set<Reservations> reservations) {
		super();
		this.titre = titre;
		this.prenom = prenom;
	}

	// Getters and setters : 
	
	public TitrePhysique getTitre() {
		return titre;
	}

	public void setTitre(TitrePhysique titre) {
		this.titre = titre;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
		
}
