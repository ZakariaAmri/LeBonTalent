package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class SearchD extends HttpServlet{
	public static final String view ="/jspForm/searchdemande.jsp";
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( view ).forward( request, response );
	}
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		/* 
		ServiceDemande sd = new ServiceDemande();	
		 List<Demande> result = new ArrayList<Demande>(); 
		 result = sd.search(request.getParameter("search"));
		 request.setAttribute("demandesSearch", result); */
		 this.getServletContext().getRequestDispatcher( view ).forward( request, response );
	 }

}
