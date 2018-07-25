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
		String poruka1="";
		String poruka="";
		if(slazemSe == null) {
			poruka1 = "Za registraciju potrebno prihvatiti uslove!"; 
			request.setAttribute("poruka1", poruka1);
		}else if(ime=="" || prezime=="" || username=="" || password=="" || drzava=="" || grad=="" || ulica=="" || godine=="") {
			poruka1 = "Potrebno popuniti sva polja!";
			request.setAttribute("poruka1", poruka1);
		}else if(!password.equals(passwordConfirm)){
			poruka1 = "Passwordi se ne podudaraju!"; 
			request.setAttribute("poruka1", poruka1);
		}else if(KorisnikManager.korisnikExistance(username)) {
			poruka1 = "Vas username vec postoji. Molimo vas odaberite drugi!"; 
			request.setAttribute("poruka1", poruka1);
		}else {
			OsobaManager.newOsoba(ime, prezime, username, password, drzava, grad, ulica, godine);
			poruka = "uspesnaRegistracija";
			request.setAttribute("poruka", poruka);
		}
		doGet(request,response);	
	}
}


