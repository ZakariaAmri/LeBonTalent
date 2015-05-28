package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ServiceDemande;

@SuppressWarnings("serial")
public class ToutesDemandes extends HttpServlet{

	public static final String VUE = "profil.jsp";
	
	 public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		 ServiceDemande sd = new ServiceDemande();	/*
		 List<Demande> result = new ArrayList<Demande>(); 
		 result = sd.getAllDemandes();
		 */
		 request.setAttribute("demandes", sd.getAllDemandes());
		 this.getServletContext().getRequestDispatcher( "/jspGet/alldemande.jsp?" ).forward( request, response );
	 }
}
