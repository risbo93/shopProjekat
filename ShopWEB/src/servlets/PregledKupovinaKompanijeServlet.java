package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.KupovinaManager;
import model.Kupovina;
import model.Osoba;
/**
 * Servlet implementation class PregledKupovinaKompanijeServlet
 */
@WebServlet("/PregledKupovinaKompanijeServlet")
public class PregledKupovinaKompanijeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PregledKupovinaKompanijeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Kupovina> listaKupovina = new ArrayList<>();
		Osoba osoba = (Osoba) request.getSession().getAttribute("ulogovanaOsoba");
		if(osoba!=null && osoba.getUloga().equalsIgnoreCase("COMPANYADMIN")) {
			request.setAttribute("uloga", osoba.getUloga());
			List<Integer> listIdKupovina = KupovinaManager.listaKupovinaKompanije(osoba.getKompanija().getIdKompanija());
			for (Integer idKupovina : listIdKupovina) {
				listaKupovina.add(KupovinaManager.getKupovinaById(idKupovina));
			}
		}
		request.setAttribute("listaKupovina", listaKupovina);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/pregledKupovinaSA.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
