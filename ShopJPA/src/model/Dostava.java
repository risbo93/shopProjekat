package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dostava database table.
 * 
 */
@Entity
@NamedQuery(name="Dostava.findAll", query="SELECT d FROM Dostava d")
public class Dostava implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_dostava")
	private int idDostava;

	private String email;

	private String naziv;

	//bi-directional many-to-one association to Kupovina
	@OneToMany(mappedBy="dostava")
	private List<Kupovina> kupovinas;

	public Dostava() {
	}

	public int getIdDostava() {
		return this.idDostava;
	}

	public void setIdDostava(int idDostava) {
		this.idDostava = idDostava;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Kupovina> getKupovinas() {
		return this.kupovinas;
	}

	public void setKupovinas(List<Kupovina> kupovinas) {
		this.kupovinas = kupovinas;
	}

	public Kupovina addKupovina(Kupovina kupovina) {
		getKupovinas().add(kupovina);
		kupovina.setDostava(this);

		return kupovina;
	}

	public Kupovina removeKupovina(Kupovina kupovina) {
		getKupovinas().remove(kupovina);
		kupovina.setDostava(null);

		return kupovina;
	}

}