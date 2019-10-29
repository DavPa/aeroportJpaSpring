package jpa.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "login")
//On génère automatiquement l'id de login
@SequenceGenerator(name = "seqLogin", sequenceName = "seq_login", initialValue = 3100, allocationSize = 1)
public class Login {
	@Id
	@GeneratedValue(generator = "seqLogin", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_client", length = 20)
	private Long id;
	@Column(name = "login_client", length = 5)
	private String login;
	@Column(name = "mot_de_passe_client", length = 50)
	private String motDePasse;
	@Column(name = "admin_client", length = 5)
	private Boolean admin;
	@OneToOne
	@JoinColumn(name = "client_id_login", foreignKey = @ForeignKey(name = "client_id_login_fk"))
	private Client client;
	
	@Version
	private int version;

	
	// Constructeur
	
	public Login() {
		
	}
	
	public Login( Long id, String login, String motDePasse, Boolean admin) {
		this.id = id;
		this.login = login;
		this.motDePasse = motDePasse;
		this.admin = admin;
	}
	
	// Getters and setters
	
	public Long getId() {
		return id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
	// Hashcode and equals sur l'id
	
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
		Login other = (Login) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
