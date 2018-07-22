package manager;

import java.util.List;

import javax.persistence.EntityManager;

import model.Dostava;

public class DostavaManager {
	
		public static List<Dostava> listaDostava(){
			EntityManager em = JPAUtil.getEntityManager();
			return em.createQuery("SELECT d FROM Dostava d").getResultList();
		}
		
		public static Dostava getDostavaById(int id) {
			EntityManager em = JPAUtil.getEntityManager();
			return (Dostava) em.createQuery("SELECT d FROM Dostava d where d.idDostava=:id").setParameter("id", id).getSingleResult();
		}
}
