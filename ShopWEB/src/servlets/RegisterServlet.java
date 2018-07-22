package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.KorisnikManager;
import manager.OsobaManager;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String poruka = "";
		request.getParameter("poruka");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/register.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ime = request.getParameter("ime");
		String prezime = request.getParameter("prezime");
		String username = request.getParameter("username");
		String drzava = request.getParameter("drzava");
		String grad = request.getParameter("grad");
		String ulica = request.getParameter("ulica");
		String godine = request.getParameter("godine");
		String password = request.getParameter("password");
		String passwordConfirm = request.getParameter("passwordConfirm");
		String slazemSe=request.getParameter("slazemSe");
		String poruka="";
		if(slazemSe == null) {
			poruka = "Za registraciju potrebno prihvatiti uslove!"; 
			request.setAttribute("poruka", poruka);
		}else if(ime=="" || prezime=="" || username=="" || password=="" || drzava=="" || grad=="" || ulica=="" || godine=="") {
			poruka = "Potrebno popuniti sva polja!";
			request.setAttribute("poruka", poruka);
		}else if(!password.equals(passwordConfirm)){
			poruka = "Passwordi se ne podudaraju!"; 
			request.setAttribute("poruka", poruka);
		}else if(KorisnikManager.korisnikExistance(username)) {
			poruka = "Vas username vec postoji. Molimo vas odaberite drugi!"; 
			request.setAttribute("poruka", poruka);
		}else {
			OsobaManager.newOsoba(ime, prezime, username, password, drzava, grad, ulica, godine);
			poruka = "Uspesna registracija!!!";
			request.setAttribute("poruka", poruka);
		}
		doGet(request,response);	
	}
}


