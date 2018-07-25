package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.OcenaManager;
import manager.StvariManager;
import model.Osoba;
import model.Stvari;

/**
 * Servlet implementation class OceniServlet
 */
@WebServlet("/OceniServlet")
public class OceniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OceniServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idStvari = request.getParameter("odabir");
		Stvari stvar = StvariManager.getStvarById(idStvari);
		request.setAttribute("stvar", stvar);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/oceni.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String star = request.getParameter("star");
		String komentar = request.getParameter("komentar");
		Osoba ulogovanaOsoba =(Osoba)request.getSession().getAttribute("ulogovanaOsoba");
		String idStvari = request.getParameter("odabir");
		request.setAttribute("odabir", idStvari);
		String poruka2 = "";
		
		if(ulogovanaOsoba==null) {
			poruka2="ulogujKorisnika";
			System.out.println("fali korisnik");
		}
		else if(komentar==null || komentar.equals("")) {
			poruka2="faliKomentar";
			System.out.println("fali komentar");
		}
		else if(star==null) {
			poruka2="zvezda";
			System.out.println("fali star");
		}else {
			if(OcenaManager.ostaviKomentar(star, komentar, idStvari, ulogovanaOsoba.getIdOsoba())) {
				poruka2="uspesanKomentar";
			}
		}
		request.setAttribute("poruka2", poruka2);
		doGet(request, response);
	}

}
