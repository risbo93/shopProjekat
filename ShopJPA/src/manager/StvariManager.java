package manager;

import java.util.List;

import javax.persistence.EntityManager;

import model.Kompanija;
import model.Stvari;

public class StvariManager {
	public static List<Stvari> listaStvari(){
		EntityManager em = JPAUtil.getEntityManager();
		return em.createQuery("SELECT s FROM Stvari s WHERE s.obrisano=0").getResultList();
	}
	
	public static Stvari getStvarById(int id) {
		EntityManager em = JPAUtil.getEntityManager();
		return (Stvari) em.createQuery("SELECT s FROM Stvari s WHERE s.idStvari=:id").setParameter("id", id).getSingleResult();
	}
	
	public static Stvari getStvarById(String idStr) {
		Integer id = Integer.parseInt(idStr);
		EntityManager em = JPAUtil.getEntityManager();
		return (Stvari) em.createQuery("SELECT s FROM Stvari s WHERE s.idStvari=:id").setParameter("id", id).getSingleResult();
	}
	
	public static List<String> listaKategorija(){
		EntityManager em = JPAUtil.getEntityManager();
		return em.createQuery("SELECT s.kategorija FROM Stvari s WHERE s.obrisano=0 GROUP BY s.kategorija").getResultList();
	}
	
	public static List<Stvari> listaStvariPoKategoriji(String kategorija){
		EntityManager em = JPAUtil.getEntityManager();
		return em.createQuery("SELECT s FROM Stvari s WHERE s.kategorija=:kategorija AND s.obrisano=0").setParameter("kategorija", kategorija).getResultList();
	}
	
	public static List<Stvari> listaStvariKompanije(int idKomp){
		EntityManager em = JPAUtil.getEntityManager();
		return em.createQuery("SELECT s FROM Stvari s WHERE s.kompanija.idKompanija=:idKomp and s.obrisano='0'").setParameter("idKomp", idKomp).getResultList();
	}
	
	public static boolean dodajStvar(String naziv, String cenaStr, String opis, String kategorija, int kompanijaId,String linkSlike) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			Integer cena = Integer.parseInt(cenaStr);
			Stvari stvar = new Stvari();
			Kompanija kompanija = KompanijaManager.getKompanijaById(kompanijaId);
			stvar.setKategorija(kategorija);
			stvar.setKompanija(kompanija);
			stvar.setNaziv(naziv);
			stvar.setObrisano(0);
			stvar.setOpis(opis);
			stvar.setSlika(linkSlike);
			stvar.setCena(cena);
			em.getTransaction().begin();
			em.persist(stvar);
			em.getTransaction().commit();
			em.close();
			return true;
		}catch(Exception e) {
			em.close();
			return false;
		}
	}
	
	public static boolean obrisiStvar(String idStvari) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
		Stvari stvar = getStvarById(idStvari);
		stvar.setObrisano(1);
		em.getTransaction().begin();
		em.merge(stvar);
		em.getTransaction().commit();
		em.close();
		return true;
		}catch(Exception e) {
			em.close();
			return false;
		}
	}
	
	public static List<Stvari> listaStvariSearch(String filter){
		String rec = "%" + filter + "%";
		EntityManager em = JPAUtil.getEntityManager();
		if(filter!=null && !filter.isEmpty()){
		return em.createQuery("SELECT s FROM Stvari s WHERE s.naziv LIKE :rec AND s.obrisano=0").setParameter("rec", rec).getResultList();
		}
		return listaStvari();
	}

}


