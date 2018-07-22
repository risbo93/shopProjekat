package manager;

import javax.persistence.EntityManager;

import model.Korisnik;
import model.Osoba;

public class KorisnikManager {
	
	public static boolean korisnikExistance(String username) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
		Korisnik korisnik = (Korisnik) em.createQuery("SELECT k FROM Korisnik k WHERE k.username = :username").setParameter("username", username).getSingleResult();
		return true;
		}catch(Exception e) {
			return false;
		}
	}
	
}
