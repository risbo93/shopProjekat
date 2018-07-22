package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.DostavaManager;
import manager.KupovinaManager;
import manager.OsobaManager;
import manager.StavkaManager;
import manager.StvariManager;
import model.Dostava;
import model.Osoba;
import model.Stavka;
import model.Stvari;

/**
 * Servlet implementation class ObrisiIzKorpeServlet
 */
@WebServlet("/ObrisiIzKorpeServlet")
public class ObrisiIzKorpeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObrisiIzKorpeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Dostava> listaDostava = DostavaManager.listaDostava();
		request.setAttribute("listaDostava", listaDostava);
		List<Stvari> listaStvari =null;
		String kategorija = request.getParameter("odabranaKategorija");
		String searchKategorija = request.getParameter("searchKategorija");
		if(kategorija!=null) {
			listaStvari = StvariManager.listaStvariPoKategoriji(kategorija);
		}else if(searchKategorija!=null) {
			listaStvari = StvariManager.listaStvariSearch(searchKategorija);
		}else {
			listaStvari = StvariManager.listaStvari();
		}
		request.setAttribute("listaStvari", listaStvari);
		Osoba osoba =(Osoba)request.getSession().getAttribute("ulogovanaOsoba");
		List<Stavka> listaStavki = null;
		if(osoba!=null) {
		listaStavki = StavkaManager.listaStavkiOsobe(osoba);
		request.setAttribute("listaStavki", listaStavki);
		}
		int ukupnaCena=0;
		if(osoba!=null) {
			ukupnaCena = StavkaManager.cenaStavkiOsobe(listaStavki);
		}
		request.setAttribute("ukupnaCena", ukupnaCena);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/kupovina.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idStavke = request.getParameter("odabirBrisanja");
		Osoba osoba = (Osoba) request.getSession().getAttribute("ulogovanaOsoba");
		if(osoba !=null) {
			if(idStavke!=null) {
				if(StavkaManager.ukloniIzKorpe(idStavke, osoba)) {
					System.out.println("Uspesno uklonjeno iz korpe!");
				}else {
					System.out.println("Neuspesno brisanje!");
				}
			}else {
				String idDostava = request.getParameter("odabranaKS");
				KupovinaManager.izvrsiKupovinu(osoba.getIdOsoba(),idDostava);
			}
		}
		doGet(request, response);
	}

}
