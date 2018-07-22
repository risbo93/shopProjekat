package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the kompanija database table.
 * 
 */
@Entity
@NamedQuery(name="Kompanija.findAll", query="SELECT k FROM Kompanija k")
public class Kompanija implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_kompanija")
	private int idKompanija;

	private String adresa;

	private String naziv;

	@Column(name="procenat_zarade")
	private int procenatZarade;

	private String slika;

	//bi-directional many-to-one association to Osoba
	@OneToMany(mappedBy="kompanija")
	private List<Osoba> osobas;

	//bi-directional many-to-one association to Stvari
	@OneToMany(mappedBy="kompanija")
	private List<Stvari> stvaris;

	public Kompanija() {
	}

	public int getIdKompanija() {
		return this.idKompanija;
	}

	public void setIdKompanija(int idKompanija) {
		this.idKompanija = idKompanija;
	}

	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getProcenatZarade() {
		return this.procenatZarade;
	}

	public void setProcenatZarade(int procenatZarade) {
		this.procenatZarade = procenatZarade;
	}

	public String getSlika() {
		return this.slika;
	}

	public void setSlika(String slika) {
		this.slika = slika;
	}

	public List<Osoba> getOsobas() {
		return this.osobas;
	}

	public void setOsobas(List<Osoba> osobas) {
		this.osobas = osobas;
	}

	public Osoba addOsoba(Osoba osoba) {
		getOsobas().add(osoba);
		osoba.setKompanija(this);

		return osoba;
	}

	public Osoba removeOsoba(Osoba osoba) {
		getOsobas().remove(osoba);
		osoba.setKompanija(null);

		return osoba;
	}

	public List<Stvari> getStvaris() {
		return this.stvaris;
	}

	public void setStvaris(List<Stvari> stvaris) {
		this.stvaris = stvaris;
	}

	public Stvari addStvari(Stvari stvari) {
		getStvaris().add(stvari);
		stvari.setKompanija(this);

		return stvari;
	}

	public Stvari removeStvari(Stvari stvari) {
		getStvaris().remove(stvari);
		stvari.setKompanija(null);

		return stvari;
	}

}