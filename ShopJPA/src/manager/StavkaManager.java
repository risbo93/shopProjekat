package manager;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import model.Kupovina;
import model.Osoba;
import model.Stavka;
import model.Stvari;

public class StavkaManager {
	public static void main(String[] args) {
		getStavkasByIdKupovina(16);
	}
	
	
	public static List<Stavka> listaStavkiOsobe(Osoba osoba){
		EntityManager em = JPAUtil.getEntityManager();
		int idOsobe = osoba.getIdOsoba();
		try {
		return em.createQuery("SELECT o.stavkas FROM Osoba o WHERE o.idOsoba=:idOsobe").setParameter("idOsobe", idOsobe).getResultList();
		}catch(Exception e) {
			return new ArrayList<>();
		}
	}
	
	public static List<Stavka> getStavkasByIdKupovina(int idKupovina){
		EntityManager em = JPAUtil.getEntityManager();
		Kupovina kupovina = KupovinaManager.getKupovinaById(idKupovina);
		List<Stavka> listaStavki = kupovina.getStavkas();
		return listaStavki;
	}
	
	public static boolean dodajUKorpu(Osoba osoba, String idStvariStr) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		try {
			List<Stavka> listaStavki = osoba.getStavkas();
			Integer idStvari = Integer.parseInt(idStvariStr);
			if(listaStavki!=null) {
				for (Stavka stavka : listaStavki) {
					if(stavka.getStvari().getIdStvari()==idStvari) {
						stavka.setKolicina(stavka.getKolicina()+1);
						em.merge(stavka);
						em.getTransaction().commit();
						em.close();
						return true;
					}
				}
			}else{
				listaStavki = new ArrayList<>();
			}
			Stavka stavka = new Stavka();
			Stvari stvar = StvariManager.getStvarById(idStvari);
			stavka.setKolicina(1);
			stavka.setStvari(stvar);
			List<Osoba> listaOsoba = new ArrayList<>();
			listaOsoba.add(osoba);
			stavka.setOsobas(listaOsoba);
			em.merge(stavka);
			em.getTransaction().commit();
			em.close();
			return true;
		}catch(Exception e) {
			em.close();
			return false;
		}
	}
	
	public static int cenaStavkiOsobe(List<Stavka> listaStavki) {
		if(listaStavki==null) {
			return 0;
		}
		int suma=0;
		for (Stavka stavka : listaStavki) {
			suma+=stavka.getKolicina()*stavka.getStvari().getCena();
		}
		return suma;
	}
	
	public static Stavka getStavkaById(String idStr) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			Integer id=Integer.parseInt(idStr);
			return (Stavka) em.createQuery("SELECT s FROM Stavka s WHERE s.idStavka=:id").setParameter("id", id).getSingleResult();
		}catch(Exception e) {
			return null;
		}
	}
	public static boolean ukloniIzKorpe(String idStr, Osoba osoba) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		try {
			Stavka stavka = getStavkaById(idStr);
			if(stavka.getKolicina()>1) {
				stavka.setKolicina(stavka.getKolicina()-1);
				em.merge(stavka);
			}else {
				List<Osoba> listaOsoba = stavka.getOsobas();
				for (Osoba osoba2 : listaOsoba) {
					if(osoba2.getIdOsoba()==osoba.getIdOsoba()) {
						listaOsoba.remove(osoba2);
						break;
					}
				}
				stavka.setOsobas(listaOsoba);
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

}
