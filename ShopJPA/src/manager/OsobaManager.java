package manager;

import java.util.List;

import javax.persistence.EntityManager;

import org.jasypt.util.password.StrongPasswordEncryptor;

import model.Korisnik;
import model.Osoba;
import model.Stavka;

public class OsobaManager {
	
	public static boolean newOsoba(String ime, String prezime, String username, String password, String drzava, String grad, String ulica, String godineStr) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			Integer godine = Integer.parseInt(godineStr);
			Korisnik korisnik = new Korisnik();
			StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
			String encryptedPassword = passwordEncryptor.encryptPassword(password);
			korisnik.setUsername(username);
			korisnik.setPass(encryptedPassword);
			em.getTransaction().begin();
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
			osoba.setUloga("KUPAC");
			em.persist(osoba);
			em.getTransaction().commit();
			em.close();
			return true;
		}catch(Exception e) {
			em.close();
			return false;
		}
	}
	
	
	public static Osoba Login(String username, String password) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			Korisnik korisnik = (Korisnik) em.createQuery("SELECT k FROM Korisnik k WHERE k.username=:username").setParameter("username", username).getSingleResult();
			StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
			String encryptedPassword=korisnik.getPass();
			if(!(korisnik.getPass().equals(password) || passwordEncryptor.checkPassword(password, encryptedPassword) )) {
				return null;
			}
			Osoba osoba = (Osoba) em.createQuery("SELECT o FROM Osoba o WHERE o.korisnik=:korisnik").setParameter("korisnik", korisnik).getSingleResult();
			return osoba;
		}catch(Exception e) {
			return null;
		}
	}
	
	public static Osoba getOsobaById(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		return (Osoba) em.createQuery("SELECT o FROM Osoba o WHERE o.idOsoba=:id").setParameter("id", id).getSingleResult();
	}
	
	public static void main(String [] args) {
		Osoba osoba = Login("boris","boris123");
		System.out.println(osoba.getIme()+" "+osoba.getPrezime());
	}
	
	
}
