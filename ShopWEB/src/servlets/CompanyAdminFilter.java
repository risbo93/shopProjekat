package servlets;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import model.Osoba;

/**
 * Servlet Filter implementation class CompanyAdminFilter
 */
@WebFilter(filterName="/CompanyAdminFilter",urlPatterns = {"/CompanyAdminServlet/*","/DodajProizvodServlet/*","/UkloniProizvodServlet/*","/PregledKupovinaKompanijeServlet/*"})
public class CompanyAdminFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CompanyAdminFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		Osoba o = (Osoba)((HttpServletRequest) request).getSession().getAttribute("ulogovanaOsoba");
		if(o!=null && o.getUloga().equalsIgnoreCase("COMPANYADMIN")){
			chain.doFilter(request, response);
		}else{
			request.getRequestDispatcher("/IndexServlet").forward(request, response);
		}
		// pass the request along the filter chain
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
