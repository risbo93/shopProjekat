package manager;

import java.util.List;

import javax.persistence.EntityManager;

import model.OcenaStvar;
import model.Osoba;
import model.Stvari;

public class OcenaManager {
	
	public static boolean ostaviKomentar(String ocenaStr,String komentar, String idStvariStr, int idOsobeStr){
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		try {
			Integer ocena = Integer.parseInt(ocenaStr);
			Osoba osoba = OsobaManager.getOsobaById(idOsobeStr);
			Stvari stvar = StvariManager.getStvarById(idStvariStr);
			OcenaStvar ocenaStvar = new OcenaStvar();
			ocenaStvar.setKomentar(komentar);
			ocenaStvar.setOcena(ocena);
			ocenaStvar.setOsoba(osoba);
			ocenaStvar.setStvari(stvar);
			em.persist(ocenaStvar);
			em.getTransaction().commit();
			em.close();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			em.close();
			return false;
		}
	}
	
	public static List<OcenaStvar> listaKomentaraStvari(String idStvariStr){
		EntityManager em = JPAUtil.getEntityManager();
		Integer idStvari = Integer.parseInt(idStvariStr);
		return em.createQuery("SELECT os FROM OcenaStvar os WHERE os.stvari.idStvari=:idStvari").setParameter("idStvari", idStvari).getResultList();
	}
}
