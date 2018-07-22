package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the stvari database table.
 * 
 */
@Entity
@NamedQuery(name="Stvari.findAll", query="SELECT s FROM Stvari s")
public class Stvari implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_stvari")
	private int idStvari;

	private int cena;

	private String kategorija;

	private String naziv;

	private int obrisano;

	private String opis;

	private String slika;

	//bi-directional many-to-one association to OcenaStvar
	@OneToMany(mappedBy="stvari")
	private List<OcenaStvar> ocenaStvars;

	//bi-directional many-to-one association to Stavka
	@OneToMany(mappedBy="stvari")
	private List<Stavka> stavkas;

	//bi-directional many-to-one association to Kompanija
	@ManyToOne
	private Kompanija kompanija;

	public Stvari() {
	}

	public int getIdStvari() {
		return this.idStvari;
	}

	public void setIdStvari(int idStvari) {
		this.idStvari = idStvari;
	}

	public int getCena() {
		return this.cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public String getKategorija() {
		return this.kategorija;
	}

	public void setKategorija(String kategorija) {
		this.kategorija = kategorija;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getObrisano() {
		return this.obrisano;
	}

	public void setObrisano(int obrisano) {
		this.obrisano = obrisano;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getSlika() {
		return this.slika;
	}

	public void setSlika(String slika) {
		this.slika = slika;
	}

	public List<OcenaStvar> getOcenaStvars() {
		return this.ocenaStvars;
	}

	public void setOcenaStvars(List<OcenaStvar> ocenaStvars) {
		this.ocenaStvars = ocenaStvars;
	}

	public OcenaStvar addOcenaStvar(OcenaStvar ocenaStvar) {
		getOcenaStvars().add(ocenaStvar);
		ocenaStvar.setStvari(this);

		return ocenaStvar;
	}

	public OcenaStvar removeOcenaStvar(OcenaStvar ocenaStvar) {
		getOcenaStvars().remove(ocenaStvar);
		ocenaStvar.setStvari(null);

		return ocenaStvar;
	}

	public List<Stavka> getStavkas() {
		return this.stavkas;
	}

	public void setStavkas(List<Stavka> stavkas) {
		this.stavkas = stavkas;
	}

	public Stavka addStavka(Stavka stavka) {
		getStavkas().add(stavka);
		stavka.setStvari(this);

		return stavka;
	}

	public Stavka removeStavka(Stavka stavka) {
		getStavkas().remove(stavka);
		stavka.setStvari(null);

		return stavka;
	}

	public Kompanija getKompanija() {
		return this.kompanija;
	}

	public void setKompanija(Kompanija kompanija) {
		this.kompanija = kompanija;
	}

}