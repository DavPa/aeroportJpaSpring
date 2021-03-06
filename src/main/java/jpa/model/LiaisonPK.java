package jpa.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ForeignKey;

@Embeddable
public class LiaisonPK implements Serializable{
	
	@ManyToOne
	@JoinColumn(name = "id_aeroport_villeaeroport", foreignKey = @ForeignKey(name = "villeaeroport_id_aeroport_fk"))
	private Aeroport aeroport;
	
	@ManyToOne
	@JoinColumn(name = "id_ville_villeaeroport", foreignKey = @ForeignKey(name = "villeaeroport_id_ville_fk"))
	private Ville ville;
	
	
	public LiaisonPK() {
		super();
	}
	public LiaisonPK(Aeroport aeroport, Ville ville) {
		super();
		this.aeroport = aeroport;
		this.ville = ville;
	}
	
	
	public Aeroport getAeroport() {
		return aeroport;
	}
	public void setAeroport(Aeroport aeroport) {
		this.aeroport = aeroport;
	}
	public Ville getVille() {
		return ville;
	}
	public void setVille(Ville ville) {
		this.ville = ville;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aeroport == null) ? 0 : aeroport.hashCode());
		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
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
		LiaisonPK other = (LiaisonPK) obj;
		if (aeroport == null) {
			if (other.aeroport != null)
				return false;
		} else if (!aeroport.equals(other.aeroport))
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		return true;
	}

	
	
}
