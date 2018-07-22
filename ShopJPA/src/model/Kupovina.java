package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the kupovina database table.
 * 
 */
@Entity
@NamedQuery(name="Kupovina.findAll", query="SELECT k FROM Kupovina k")
public class Kupovina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_kupovina")
	private int idKupovina;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datum;

	//bi-directional many-to-one association to Dostava
	@ManyToOne
	private Dostava dostava;

	//bi-directional many-to-one association to Osoba
	@ManyToOne
	private Osoba osoba;

	//bi-directional many-to-many association to Stavka
	@ManyToMany(mappedBy="kupovinas")
	private List<Stavka> stavkas;

	public Kupovina() {
	}

	public int getIdKupovina() {
		return this.idKupovina;
	}

	public void setIdKupovina(int idKupovina) {
		this.idKupovina = idKupovina;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Dostava getDostava() {
		return this.dostava;
	}

	public void setDostava(Dostava dostava) {
		this.dostava = dostava;
	}

	public Osoba getOsoba() {
		return this.osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}

	public List<Stavka> getStavkas() {
		return this.stavkas;
	}

	public void setStavkas(List<Stavka> stavkas) {
		this.stavkas = stavkas;
	}

}