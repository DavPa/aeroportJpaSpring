package jpa.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "liaison")
public class Liaison {
	@EmbeddedId
	private LiaisonPK key;

	
	public Liaison() {
		super();
	}

	public Liaison(LiaisonPK key) {
		super();
		this.key = key;
	}

	
	public LiaisonPK getKey() {
		return key;
	}
	public void setKey(LiaisonPK key) {
		this.key = key;
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
		Liaison other = (Liaison) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
	
	

}
