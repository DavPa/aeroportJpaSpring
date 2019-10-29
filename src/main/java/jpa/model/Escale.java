package jpa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "escale")
public class Escale {
	@EmbeddedId
	private EscalePk key;
	@Column(name = "heure_depart_escale")
	private Date heureDepart;
	@Column(name = "heure_arrivee_escale")
	private Date heureArivee;
		
	public Escale() {
		super();
	}
	public EscalePk getKey() {
		return key;
	}
	public void setKey(EscalePk key) {
		this.key = key;
	}
	public Date getHeureDepart() {
		return heureDepart;
	}
	public void setHeureDepart(Date heureDepart) {
		this.heureDepart = heureDepart;
	}
	public Date getHeureArivee() {
		return heureArivee;
	}
	public void setHeureArivee(Date heureArivee) {
		this.heureArivee = heureArivee;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
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
		Escale other = (Escale) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
 
	
	
	
}
