package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.StvariManager;
import model.Osoba;
import model.Stvari;

/**
 * Servlet implementation class UkloniProizvodServlet
 */
@WebServlet("/UkloniProizvodServlet")
public class UkloniProizvodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UkloniProizvodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Osoba osoba = (Osoba) request.getSession().getAttribute("ulogovanaOsoba");
		if(osoba!=null && osoba.getUloga().equals("COMPANYADMIN")) {
			List<Stvari> stvari = StvariManager.listaStvariKompanije(osoba.getKompanija().getIdKompanija());
			request.setAttribute("stvari", stvari);
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/ukloniProizvodCA.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idStvari = request.getParameter("odabranaStvar");
		String poruka5 = "";
		if(StvariManager.obrisiStvar(idStvari)) {
			poruka5="uspesnoUklanjanje";
		}else {
			poruka5="neuspesnoUklanjanje";
		}
		request.setAttribute("poruka5", poruka5);
		doGet(request, response);
	}

}
