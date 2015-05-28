package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ServiceDemande;
import model.Utilisateur;
import dao.DaoUtilisateur;


@SuppressWarnings("serial")
public class Profil extends HttpServlet{

	public static final String VUE = "profil.jsp";
	
	 public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		 DaoUtilisateur du = new DaoUtilisateur();
		 ServiceDemande sd = new ServiceDemande();
		 HttpSession session = request.getSession(false);
	//	 System.out.println("test profil"+session.getAttribute("sessionUtilisateur"));
		 try {
			 Utilisateur useur=(Utilisateur) du.read((String)session.getAttribute("sessionUtilisateur"));
			 request.setAttribute( "Utilisateur", useur );	 
			 request.setAttribute( "UtilisateurDemande", sd.getDemandeInscrit(useur) );	 
			 request.setAttribute( "UtilisateurAnnonce", sd.getAnnonceInscrit(useur) );
			 this.getServletContext().getRequestDispatcher( "/profil.jsp" ).forward( request, response );
		 }catch(NullPointerException e){
			 this.getServletContext().getRequestDispatcher( "/jspForm/inscription.jsp" ).forward( request, response );
		 }
	 }

}
