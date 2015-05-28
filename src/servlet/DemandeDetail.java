package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ServiceDemande;
import model.Demande;


@SuppressWarnings("serial")
public class DemandeDetail extends HttpServlet {
	public static final String VUE = "/jspGet/detaildemande.jsp";
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		 ServiceDemande sd = new ServiceDemande();
		 Demande demande = null;
		 demande = sd.get(request.getParameter("refDemande"));
		 request.setAttribute("DemandeDetail", demande);
		 session.setAttribute("rfc", demande.id);
		 this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	 }
	
	

}
