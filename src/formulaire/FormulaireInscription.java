package formulaire;

import javax.servlet.http.HttpServletRequest;

import service.ServiceUtilisateur;
import model.Utilisateur;

public class FormulaireInscription extends Formulaire {
		private static final String CHAMP_LOGIN = "login";
		private static final String CHAMP_ADRESSE = "adresse";
	    private static final String CHAMP_EMAIL  = "email";
	    private static final String CHAMP_PASS   = "password";

	    public Utilisateur inscriptionUtilisateur(HttpServletRequest request) {
	    	String login;
	    	String adresse;
	    	String passeword;
	    	String email;
	    	ServiceUtilisateur su = new ServiceUtilisateur();
	    	login = getValeurChamp(request,CHAMP_LOGIN);
	    	adresse = getValeurChamp(request,CHAMP_ADRESSE);
	    	passeword = getValeurChamp(request,CHAMP_PASS);
	    	email = getValeurChamp(request,CHAMP_EMAIL);
	    	Utilisateur user = new Utilisateur(login,adresse,passeword,email);
	    	su.inscription(login, passeword, adresse, email);
			return user;
	    }


}
