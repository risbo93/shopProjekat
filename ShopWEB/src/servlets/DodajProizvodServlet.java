package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.StvariManager;
import model.Osoba;

/**
 * Servlet implementation class DodajProizvodServlet
 */
@WebServlet("/DodajProizvodServlet")
public class DodajProizvodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DodajProizvodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/dodajProizvodCA.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String poruka3 = "";
		String nazivProizvoda = request.getParameter("naziv");
		String cena =request.getParameter("cena");
		String opis = request.getParameter("opis");
		String kategorija = request.getParameter("kategorija");
		String linkSlike = request.getParameter("slika");
		Osoba osoba = (Osoba) request.getSession().getAttribute("ulogovanaOsoba");
		if(nazivProizvoda=="" || cena=="" || opis=="" || kategorija=="") {
			poruka3="trebaPopuniti";
		}else {
			if(StvariManager.dodajStvar(nazivProizvoda, cena, opis, kategorija, osoba.getKompanija().getIdKompanija(), linkSlike)) {
				poruka3="uspesno";
			}else {
				poruka3="neuspesno";
			}
		}
		request.setAttribute("poruka3", poruka3);
		doGet(request, response);
	}

}
