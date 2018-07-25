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
		int idKupovina;
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
			idKupovina=kupovina.getIdKupovina();
			System.out.println(idKupovina);
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
			//List<Stavka> listaStavkiKupovine = StavkaManager.getStavkasByIdKupovina(idKupovina);
			//Mail.sendMail(KupovinaManager.getKupovinaById(idKupovina), listaStavkiKupovine);
			//OVDE KADA POSALJEM KUPI NEKO NESTO TREBA DA SE POSALJE MAIL DOSTAVLJACU
			//RADI U MAIL KLASI ALI OVDE NECE DA RADI
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			em.close();
			return false;
		}
	}
	
	public static List<Kupovina> listaKupovina(){
		EntityManager em = JPAUtil.getEntityManager();
		return em.createQuery("SELECT k FROM Kupovina k").getResultList();
	}
	
	public static List<Integer> listaKupovinaKompanije(int idKompanije){
		EntityManager em = JPAUtil.getEntityManager();
		String recenicaSQL = "SELECT k.id_kupovina FROM shopdb.kupovina_has_stavka as ks INNER JOIN kupovina as k on ks.kupovina_id_kupovina=k.id_kupovina INNER JOIN stavka on stavka.id_stavka=ks.stavka_id_stavka INNER JOIN stvari on stvari.id_stvari=stavka.stvari_id_stvari INNER JOIN kompanija on stvari.kompanija_id_kompanija=kompanija.id_kompanija WHERE kompanija.id_kompanija='"+idKompanije+"' group by ks.kupovina_id_kupovina";
		return em.createNativeQuery(recenicaSQL).getResultList();
				}
	public static Kupovina getKupovinaById(int idKup) {
		EntityManager em = JPAUtil.getEntityManager();
		return (Kupovina) em.createQuery("SELECT k FROM Kupovina k WHERE k.idKupovina=:idKup").setParameter("idKup", idKup).getSingleResult();
	}
	
	public static void main(String[] args) {
		List<Integer> listaKupovina =listaKupovinaKompanije(1);
		listaKupovina.forEach(System.out::println);
		List<Kupovina> listaKupovinaa = new ArrayList<>();
		for (Integer id : listaKupovina) {
			listaKupovinaa.add(getKupovinaById(id));
		}
		for (Kupovina kupovina : listaKupovinaa) {
			System.out.println(kupovina.getDatum());
		}
	}
}