package jpa.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "aeroport")
@SequenceGenerator(name="seqAeroport", sequenceName = "seq_aeroport", initialValue = 100, allocationSize = 1)
public class Aeroport {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAeroport")
	private Integer id;
	@Column(name = "nom", length = 150, nullable = false )
	private String nom;
	@OneToMany(mappedBy = "aeroportDepart")
	private Set<Vol> volDeparts;
	@OneToMany(mappedBy = "aeroportArrivee")
	private Set<Vol> volArrivees;
	@OneToMany(mappedBy="key.aeroport")
	Set<Liaison> liaisons;
	
	
	public Aeroport() {
		super();
	}
	
	public Aeroport(Integer id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public Aeroport(String nom) {
		super();
		this.nom = nom;
	}
	
	public Aeroport(Integer id) {
		super();
		this.id = id;
	}
	
		
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<Vol> getVolDeparts() {
		return volDeparts;
	}

	public void setVolDeparts(Set<Vol> volDeparts) {
		this.volDeparts = volDeparts;
	}

	public Set<Vol> getVolArrivees() {
		return volArrivees;
	}

	public void setVolArrivees(Set<Vol> volArrivees) {
		this.volArrivees = volArrivees;
	}
	
	
	public Set<Liaison> getLiaisons() {
		return liaisons;
	}

	public void setLiaisons(Set<Liaison> liaisons) {
		this.liaisons = liaisons;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aeroport other = (Aeroport) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
