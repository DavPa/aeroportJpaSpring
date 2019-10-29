package jpa.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "compagnie_aerienne")
@SequenceGenerator(name = "seqCompagnieAerienne", sequenceName = "seq_compagnie_aerienne", initialValue = 100, allocationSize = 1)
public class CompagnieAerienne {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCompagnieAerienne")
	@Column(name = "id_compagnie_aerienne")
	private Long id;
	@Column(name ="nom_compagnie_aerienne")
	private String nom;
	@OneToMany(mappedBy="key.compagnieAerienne")
	Set<CompagnieAerienneVol> compagnieAerienneVols;

	public CompagnieAerienne() {
		super();
	}
	
	public CompagnieAerienne(String nom) {
		super();
		this.nom = nom;
	}


	public CompagnieAerienne(Long id, String nom, Set<CompagnieAerienneVol> compagnieAerienneVols) {
		super();
		this.id = id;
		this.nom = nom;
		this.compagnieAerienneVols = compagnieAerienneVols;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

		
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<CompagnieAerienneVol> getCompagnieAerienneVols() {
		return compagnieAerienneVols;
	}

	public void setCompagnieAerienneVols(Set<CompagnieAerienneVol> compagnieAerienneVols) {
		this.compagnieAerienneVols = compagnieAerienneVols;
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
		CompagnieAerienne other = (CompagnieAerienne) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
