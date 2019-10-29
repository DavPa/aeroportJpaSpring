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
@Table(name = "ville")
@SequenceGenerator(name="seqVille", sequenceName = "seq_personne", initialValue = 100, allocationSize = 1)
public class Ville {
	@Id
	@Column(name = "id_ville")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqVille")
	private Integer id;
	@Column(name = "nom_ville", length = 150, nullable = false )
	private String nom;
	@OneToMany(mappedBy="key.ville")
	private Set<Liaison> liaisons;
	
	
	public Ville() {
		super();
	}
	public Ville(Integer id) {
		super();
		this.id = id;
	}
	public Ville(String nom) {
		super();
		this.nom = nom;
	}
	public Ville(Integer id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
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
		Ville other = (Ville) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
