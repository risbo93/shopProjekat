package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ocena_stvar database table.
 * 
 */
@Entity
@Table(name="ocena_stvar")
@NamedQuery(name="OcenaStvar.findAll", query="SELECT o FROM OcenaStvar o")
public class OcenaStvar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ocena_stvar")
	private int idOcenaStvar;

	private String komentar;

	private int ocena;

	//bi-directional many-to-one association to Osoba
	@ManyToOne
	private Osoba osoba;

	//bi-directional many-to-one association to Stvari
	@ManyToOne
	private Stvari stvari;

	public OcenaStvar() {
	}

	public int getIdOcenaStvar() {
		return this.idOcenaStvar;
	}

	public void setIdOcenaStvar(int idOcenaStvar) {
		this.idOcenaStvar = idOcenaStvar;
	}

	public String getKomentar() {
		return this.komentar;
	}

	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}

	public int getOcena() {
		return this.ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public Osoba getOsoba() {
		return this.osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}

	public Stvari getStvari() {
		return this.stvari;
	}

	public void setStvari(Stvari stvari) {
		this.stvari = stvari;
	}

}