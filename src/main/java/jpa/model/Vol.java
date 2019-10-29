package jpa.model;

import java.util.Date;
import java.util.Set;
import javax.persistence.ForeignKey;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "vol")
@NamedQueries({
	@NamedQuery(name = "Vol.findByKeyWithCompagnieAeriennes", 
	query = "select distinct v from Vol v left join fetch v.compagnieAerienneVols cav " 
	+ " left join fetch cav.key.compagnieAerienne c where v.id =:key"),
	@NamedQuery(name = "Vol.findAllWithCompagnieAeriennes", 
	query = "select distinct v from Vol v left join fetch v.compagnieAerienneVols cav" 
	+ " left join fetch cav.key.compagnieAerienne c"),
})
@SequenceGenerator(name = "seqVol", sequenceName = "seq_vol", initialValue = 100, allocationSize = 1)
public class Vol {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqVol")
	@Column(name = "id_vol")
	private Long id;
	@Column(name = "date_depart_vol")
	private Date dateDepart;
	@Column(name = "date_arrivee_vol")
	private Date dateArivee;
	@Column(name = "heure_depart_vol")
	private Date heureDepart;
	@Column(name = "heure_arrivee_vol")
	private Date heureArivee;
	@ManyToOne
	@JoinColumn(name = "aeroport_depart_vol", foreignKey = @ForeignKey(name = "vol_aeroport_depart_fk"))
	private Aeroport aeroportDepart;
	@ManyToOne
	@JoinColumn(name = "aeroport_arrivee_vol", foreignKey = @ForeignKey(name = "vol_aeroport_arrivee_fk"))
	private Aeroport aeroportArrivee;
	@ManyToOne
	@JoinColumn(name = "id_passager_vol", foreignKey = @ForeignKey(name = "vol_id_passager_fk"))
	private Passager passager;
	@OneToMany(mappedBy="key.vol")
	Set<CompagnieAerienneVol> compagnieAerienneVols;
	
	public Vol() {
		
	}
	
	

	public Vol(Long id, Date dateDepart, Date dateArivee, Date heureDepart, Date heureArivee,
			Set<CompagnieAerienneVol> compagnieAerienneVols) {
		super();
		this.id = id;
		this.dateDepart = dateDepart;
		this.dateArivee = dateArivee;
		this.heureDepart = heureDepart;
		this.heureArivee = heureArivee;
		this.compagnieAerienneVols = compagnieAerienneVols;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getDateArivee() {
		return dateArivee;
	}

	public void setDateArivee(Date dateArivee) {
		this.dateArivee = dateArivee;
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
	
	public Set<CompagnieAerienneVol> getCompagnieAerienneVols() {
		return compagnieAerienneVols;
	}

	public void setCompagnieAerienneVols(Set<CompagnieAerienneVol> compagnieAerienneVols) {
		this.compagnieAerienneVols = compagnieAerienneVols;
	}

	
	
	public Aeroport getAeroportDepart() {
		return aeroportDepart;
	}



	public void setAeroportDepart(Aeroport aeroportDepart) {
		this.aeroportDepart = aeroportDepart;
	}



	public Aeroport getAeroportArrivee() {
		return aeroportArrivee;
	}



	public void setAeroportArrivee(Aeroport aeroportArrivee) {
		this.aeroportArrivee = aeroportArrivee;
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
		Vol other = (Vol) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
