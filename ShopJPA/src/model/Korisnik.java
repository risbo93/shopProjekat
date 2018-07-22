package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the korisnik database table.
 * 
 */
@Entity
@NamedQuery(name="Korisnik.findAll", query="SELECT k FROM Korisnik k")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_korisnik")
	private int idKorisnik;

	private String pass;

	private String username;

	//bi-directional many-to-one association to Osoba
	@OneToMany(mappedBy="korisnik")
	private List<Osoba> osobas;

	public Korisnik() {
	}

	public int getIdKorisnik() {
		return this.idKorisnik;
	}

	public void setIdKorisnik(int idKorisnik) {
		this.idKorisnik = idKorisnik;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Osoba> getOsobas() {
		return this.osobas;
	}

	public void setOsobas(List<Osoba> osobas) {
		this.osobas = osobas;
	}

	public Osoba addOsoba(Osoba osoba) {
		getOsobas().add(osoba);
		osoba.setKorisnik(this);

		return osoba;
	}

	public Osoba removeOsoba(Osoba osoba) {
		getOsobas().remove(osoba);
		osoba.setKorisnik(null);

		return osoba;
	}

}