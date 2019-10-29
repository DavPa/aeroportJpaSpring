package jpa.model;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "client")
// On génère automatiquement l'id de client
@SequenceGenerator(name = "seqClient", sequenceName = "seq_client", initialValue = 100, allocationSize = 1)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_client", discriminatorType = DiscriminatorType.STRING, length = 1)
public abstract class Client {
	// On génère la clé primaire ici, pas besoin de la redéfinir dans Dao
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqClient")
	@Column(name = "id_client")
	private Long id;
	@Column(name = "nom_client", length = 150, nullable = false)
	private String nom;
	@Column(name = "numero_tel", length = 10, nullable = false)
	private String numeroTel;
	@Column(name = "numero_fax", length = 10)
	private String numeroFax;
	@Column(name = "email", length = 150, nullable = false)
	private String email;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "adresse", column = @Column(name = "adresse_client", length = 70)),
			@AttributeOverride(name = "codePostal", column = @Column(name = "code_postal_client", length = 5)),
			@AttributeOverride(name = "ville", column = @Column(name = "ville_client", length = 50)),
			@AttributeOverride(name = "pays", column = @Column(name = "pays_client", length = 50)) })
	private Adresse adresse;
	@OneToOne
	@JoinColumn(name = "login_id_client", foreignKey = @ForeignKey(name = "login_id_client_fk"))
	private Login login;
	@OneToMany(mappedBy="reservations")
	private Set<Reservations> reservations;
	@Version
	private int version;
	
	
	// Constructeur
	
	public Client() {
		
	}
	
	public Client (Long id, String nom, String numeroTel, String numeroFax, String email) {
		this.id = id;
		this.nom = nom;
		this.numeroTel = numeroTel;
		this.numeroFax = numeroFax;
		this.email = email;
	}
	
	// Getters and setters : 
	
	
	
	public Long getId() {
		return id;
	}
	public Set<Reservations> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservations> reservations) {
		this.reservations = reservations;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
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
	public String getNumeroTel() {
		return numeroTel;
	}
	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}
	public String getNumeroFax() {
		return numeroFax;
	}
	public void setNumeroFax(String numeroFax) {
		this.numeroFax = numeroFax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	// Hashcode and equals sur l'id : 
	
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
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
