package manager;

import java.util.List;

import javax.persistence.EntityManager;

import org.jasypt.util.password.StrongPasswordEncryptor;

import model.Kompanija;
import model.Korisnik;
import model.Osoba;

public class KompanijaManager {
	
	public static List<Kompanija> listaKompanija(){
		EntityManager em = JPAUtil.getEntityManager();
		return em.createQuery("SELECT k FROM Kompanija k").getResultList();
	}
	
	public static Kompanija getKompanijaById(int idKompanije) {
		EntityManager em = JPAUtil.getEntityManager();
		return (Kompanija) em.createQuery("SELECT k FROM Kompanija k WHERE k.idKompanija=:idKompanije").setParameter("idKompanije", idKompanije).getSingleResult();
	}
	
	public static boolean RegistrujKompaniju(String nazivKompanije, String adresaKompanije,String linkDoSlike, String procenatZaradeStr, String ime, String prezime, String username, String drzava, String grad, String ulica, String godineStr, String password) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			Integer procenatZarade = Integer.parseInt(procenatZaradeStr);
			Kompanija kompanija = new Kompanija();
			kompanija.setAdresa(adresaKompanije);
			kompanija.setNaziv(nazivKompanije);
			kompanija.setProcenatZarade(procenatZarade);
			kompanija.setSlika(linkDoSlike);
			em.getTransaction().begin();
			em.persist(kompanija);
			em.flush();
			Integer godine = Integer.parseInt(godineStr);
			Korisnik korisnik = new Korisnik();
			StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
			String encryptedPassword = passwordEncryptor.encryptPassword(password);
			korisnik.setUsername(username);
			korisnik.setPass(encryptedPassword);
			em.persist(korisnik);
			em.flush();
			Osoba osoba = new Osoba();
			osoba.setAdresa(ulica);
			osoba.setDrzava(drzava);
			osoba.setGodine(godine);
			osoba.setGrad(grad);
			osoba.setIme(ime);
			osoba.setPrezime(prezime);
			osoba.setKorisnik(korisnik);
			osoba.setUloga("COMPANYADMIN");
			osoba.setKompanija(kompanija);
			em.persist(osoba);
			em.getTransaction().commit();
			em.close();
			return true;
		}catch(Exception e) {
			em.close();
			return false;
		}
	}
}
