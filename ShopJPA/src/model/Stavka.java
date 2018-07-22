package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the stavka database table.
 * 
 */
@Entity
@NamedQuery(name="Stavka.findAll", query="SELECT s FROM Stavka s")
public class Stavka implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_stavka")
	private int idStavka;

	private int kolicina;

	//bi-directional many-to-many association to Kupovina
	@ManyToMany
	@JoinTable(
		name="kupovina_has_stavka"
		, joinColumns={
			@JoinColumn(name="stavka_id_stavka")
			}
		, inverseJoinColumns={
			@JoinColumn(name="kupovina_id_kupovina")
			}
		)
	private List<Kupovina> kupovinas;

	//bi-directional many-to-many association to Osoba
	@ManyToMany
	@JoinTable(
		name="osoba_has_stavka"
		, joinColumns={
			@JoinColumn(name="stavka_id_stavka")
			}
		, inverseJoinColumns={
			@JoinColumn(name="osoba_id_osoba")
			}
		)
	private List<Osoba> osobas;

	//bi-directional many-to-one association to Stvari
	@ManyToOne
	private Stvari stvari;

	public Stavka() {
	}

	public int getIdStavka() {
		return this.idStavka;
	}

	public void setIdStavka(int idStavka) {
		this.idStavka = idStavka;
	}

	public int getKolicina() {
		return this.kolicina;
	}

	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}

	public List<Kupovina> getKupovinas() {
		return this.kupovinas;
	}

	public void setKupovinas(List<Kupovina> kupovinas) {
		this.kupovinas = kupovinas;
	}

	public List<Osoba> getOsobas() {
		return this.osobas;
	}

	public void setOsobas(List<Osoba> osobas) {
		this.osobas = osobas;
	}

	public Stvari getStvari() {
		return this.stvari;
	}

	public void setStvari(Stvari stvari) {
		this.stvari = stvari;
	}

}