package jpa.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "reservation")
@SequenceGenerator(name = "seqReservation", sequenceName = "seq_reservation", initialValue = 100, allocationSize = 1)

public class Reservations {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqReservation")
	@Column(name = "id_reservation")
	private Long id;
	@Column(name = "numero_reservation")
	private Integer numero;
	@Column(name = "date_reservation")
	@Temporal(TemporalType.DATE)
	private Date date_reservation;
	@ManyToOne
	@JoinColumn(name = "passager_id_reservation", foreignKey = @ForeignKey(name = "passager_id_reservation_fk"))
	private Passager passager;
	@ManyToOne
	@JoinColumn(name = "reservation_id_client",foreignKey=@ForeignKey(name="reservation_id_client_fk"))
	private Client client;

	public Reservations(Integer numero) {
		super();
		this.numero = numero;
	}

	public Reservations() {
		super();
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the numero
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	/**
	 * @return the date_reservation
	 */
	public Date getDate_reservation() {
		return date_reservation;
	}

	/**
	 * @param date_reservation the date_reservation to set
	 */
	public void setDate_reservation(Date date_reservation) {
		this.date_reservation = date_reservation;
	}

	/**
	 * @return the passager
	 */
	public Passager getPassager() {
		return passager;
	}

	/**
	 * @param passager the passager to set
	 */
	public void setPassager(Passager passager) {
		this.passager = passager;
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
		Reservations other = (Reservations) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
