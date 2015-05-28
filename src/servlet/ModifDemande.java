package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.googlecode.objectify.Key;

import dao.DaoDemande;
import dao.DaoUtilisateur;
import formulaire.FormulaireDemande;
import model.Demande;
import model.Utilisateur;
import service.ServiceDemande;

@SuppressWarnings("serial")
public class ModifDemande extends HttpServlet{

	public static final String VUE = "";
	
	 public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		 ServiceDemande sd = new ServiceDemande();
		 @SuppressWarnings("unused")
		Demande demande = sd.get(request.getParameter("refForSupDem"));
		 this.getServletContext().getRequestDispatcher("/jspForm/modifDemande.jsp").forward( request, response );
	 }
	 
	 public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		 DaoUtilisateur du = new DaoUtilisateur();
		 @SuppressWarnings("unused")
		DaoDemande dd = new DaoDemande();
		 ServiceDemande sd = new ServiceDemande();
		 Demande demande;
		 demande =sd.get(request.getParameter("refForSupDem"));
	    	System.out.println("test passage Post");
	    	HttpSession session = request.getSession();
	    	if(session.getAttribute("sessionUtilisateur") == null)
	    		response.sendRedirect("/jspForm/connexion.jsp");
	    	try{
	    		Utilisateur user=(Utilisateur) du.read((String)session.getAttribute("sessionUtilisateur"));
	    		Key<Utilisateur> cle = du.getKey(user, user.getEmail());
	    		//Préparation du formulaire
	    		FormulaireDemande form = new FormulaireDemande();
	    		//traitement du formulaire
	    		form.updateDemande(request,cle,demande);
	    		//Redirection
	    		this.getServletContext().getRequestDispatcher( "profil.jsp" ).forward( request, response );
	    	}catch(NullPointerException npe) {
	    		response.sendRedirect("/connexion");
	    	}catch(IllegalArgumentException iae){
	    		response.sendRedirect("/connexion");
	    	}
	 }
}
