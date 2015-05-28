package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Demande;
import service.ServiceDemande;

@SuppressWarnings("serial")
public class SuppDemande extends HttpServlet{

	public static final String VUE = "index.html";
	
	 public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		 ServiceDemande sd = new ServiceDemande();
		 Demande demande =null;
		 demande =sd.get(request.getParameter("refForSupDem"));
		 sd.deleteDemande(demande);
		 this.getServletContext().getRequestDispatcher("profil.jsp").forward( request, response );
	 }
}
