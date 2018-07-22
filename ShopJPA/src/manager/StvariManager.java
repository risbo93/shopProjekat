package manager;

import java.util.List;

import javax.persistence.EntityManager;

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
	
	public static List<String> listaKategorija(){
		EntityManager em = JPAUtil.getEntityManager();
		return em.createQuery("SELECT s.kategorija FROM Stvari s WHERE s.obrisano=0 GROUP BY s.kategorija").getResultList();
	}
	
	public static List<Stvari> listaStvariPoKategoriji(String kategorija){
		EntityManager em = JPAUtil.getEntityManager();
		return em.createQuery("SELECT s FROM Stvari s WHERE s.kategorija=:kategorija AND s.obrisano=0").setParameter("kategorija", kategorija).getResultList();
	}
	
	public static List<Stvari> listaStvariSearch(String filter){
		String rec = "%" + filter + "%";
		EntityManager em = JPAUtil.getEntityManager();
		if(filter!=null && !filter.isEmpty()){
		return em.createQuery("SELECT s FROM Stvari s WHERE s.naziv LIKE :rec AND s.obrisano=0").setParameter("rec", rec).getResultList();
		}
		return listaStvari();
	}
	public static void main(String[] args) {
		String ime="Boris";
	}
}


