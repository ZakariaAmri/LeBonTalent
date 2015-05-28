package formulaire;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Utilisateur;
import service.ServiceUtilisateur;


public class FormulaireConnexion extends Formulaire {
	private static final String EMAIL = "email";
	private static final String PASSWORD = "password";
	
	public boolean connexionUtilisateur(HttpServletRequest request) {
    	String email;
    	String password;
    	
    	ServiceUtilisateur su = new ServiceUtilisateur();
    	
    	email = getValeurChamp(request, EMAIL);
    	password = getValeurChamp(request, PASSWORD);

    	return su.connexion(email, password);
    }
	
	public Utilisateur sessionUtilisateur(HttpSession session, HttpServletRequest request){
		if((session.getAttribute("sessionUtilisateur")== null)&&(this.connexionUtilisateur(request))) {
			ServiceUtilisateur su = new ServiceUtilisateur();
			
			session.setAttribute( "sessionUtilisateur", request.getParameter("email") );
			
			return su.getUtilisateur(request.getParameter(EMAIL));
		}
		
		return null;
	}
	
}
