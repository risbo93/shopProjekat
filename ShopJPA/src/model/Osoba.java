package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the osoba database table.
 * 
 */
@Entity
@NamedQuery(name="Osoba.findAll", query="SELECT o FROM Osoba o")
public class Osoba implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_osoba")
	private int idOsoba;

	private String adresa;

	private String drzava;

	private int godine;

	private String grad;

	private String ime;

	private String prezime;

	private String uloga;

	//bi-directional many-to-one association to Kupovina
	@OneToMany(mappedBy="osoba")
	private List<Kupovina> kupovinas;

	//bi-directional many-to-one association to OcenaStvar
	@OneToMany(mappedBy="osoba")
	private List<OcenaStvar> ocenaStvars;

	//bi-directional many-to-one association to Kompanija
	@ManyToOne
	private Kompanija kompanija;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	private Korisnik korisnik;

	//bi-directional many-to-many association to Stavka
	@ManyToMany(mappedBy="osobas")
	private List<Stavka> stavkas;

	public Osoba() {
	}

	public int getIdOsoba() {
		return this.idOsoba;
	}

	public void setIdOsoba(int idOsoba) {
		this.idOsoba = idOsoba;
	}

	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getDrzava() {
		return this.drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public int getGodine() {
		return this.godine;
	}

	public void setGodine(int godine) {
		this.godine = godine;
	}

	public String getGrad() {
		return this.grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getUloga() {
		return this.uloga;
	}

	public void setUloga(String uloga) {
		this.uloga = uloga;
	}

	public List<Kupovina> getKupovinas() {
		return this.kupovinas;
	}

	public void setKupovinas(List<Kupovina> kupovinas) {
		this.kupovinas = kupovinas;
	}

	public Kupovina addKupovina(Kupovina kupovina) {
		getKupovinas().add(kupovina);
		kupovina.setOsoba(this);

		return kupovina;
	}

	public Kupovina removeKupovina(Kupovina kupovina) {
		getKupovinas().remove(kupovina);
		kupovina.setOsoba(null);

		return kupovina;
	}

	public List<OcenaStvar> getOcenaStvars() {
		return this.ocenaStvars;
	}

	public void setOcenaStvars(List<OcenaStvar> ocenaStvars) {
		this.ocenaStvars = ocenaStvars;
	}

	public OcenaStvar addOcenaStvar(OcenaStvar ocenaStvar) {
		getOcenaStvars().add(ocenaStvar);
		ocenaStvar.setOsoba(this);

		return ocenaStvar;
	}

	public OcenaStvar removeOcenaStvar(OcenaStvar ocenaStvar) {
		getOcenaStvars().remove(ocenaStvar);
		ocenaStvar.setOsoba(null);

		return ocenaStvar;
	}

	public Kompanija getKompanija() {
		return this.kompanija;
	}

	public void setKompanija(Kompanija kompanija) {
		this.kompanija = kompanija;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public List<Stavka> getStavkas() {
		return this.stavkas;
	}

	public void setStavkas(List<Stavka> stavkas) {
		this.stavkas = stavkas;
	}

}