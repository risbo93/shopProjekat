package manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import model.Kupovina;
import model.Osoba;
import model.Stavka;

public class KupovinaManager {
	public static boolean izvrsiKupovinu(int idOsoba, String idDostavaStr) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		try {
			Integer idDostava = Integer.parseInt(idDostavaStr);
			Osoba osoba = OsobaManager.getOsobaById(idOsoba);
			List<Stavka> listaStavki = osoba.getStavkas();
			if(listaStavki.isEmpty() || listaStavki==null) {
				return false;
			}
			Kupovina kupovina = new Kupovina();
			kupovina.setDatum(new Date());
			kupovina.setOsoba(OsobaManager.getOsobaById(idOsoba));
			kupovina.setDostava(DostavaManager.getDostavaById(idDostava));
			em.persist(kupovina);
			em.flush();
			List<Kupovina> kupovinas = new ArrayList<>();
			kupovinas.add(kupovina);
			for (Stavka stavka : listaStavki) {
				Stavka st = em.find(Stavka.class, stavka.getIdStavka());
				st.setOsobas(new ArrayList<>());
				st.setKupovinas(kupovinas);
				em.merge(stavka);
			}

			em.getTransaction().commit();
			em.close();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			em.close();
			return false;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("------------------>"+izvrsiKupovinu(1,"1"));
	}
}