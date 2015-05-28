package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.googlecode.objectify.Key;

import dao.DaoUtilisateur;
import model.Utilisateur;
import formulaire.FormulaireDemande;

@SuppressWarnings("serial")
public class NouvelleDemande  extends HttpServlet {
	public static final String ATT_USER         = "utilisateur";
    public static final String VUE              = "/jspForm/demande.jsp";
    public static HttpSession  session;
    

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );	
    }
    
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	DaoUtilisateur du = new DaoUtilisateur();
    	HttpSession session = request.getSession();
    	if(session.getAttribute("sessionUtilisateur") == null)
    		response.sendRedirect("/jspForm/connexion.jsp");
    	try{
    		Utilisateur user=(Utilisateur) du.read((String)session.getAttribute("sessionUtilisateur"));
    		Key<Utilisateur> cle = du.getKey(user, user.getEmail());
    		//Préparation du formulaire
    		FormulaireDemande form = new FormulaireDemande();
    		//traitement du formulaire
    		form.nouvelleDemande(request,cle);
    		//Redirection
    		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    	}catch(NullPointerException npe) {
    		response.sendRedirect("/connexion");
    	}catch(IllegalArgumentException iae){
    		response.sendRedirect("/connexion");
    	}

    }
}
