package formulaire;

import javax.servlet.http.HttpServletRequest;

import com.googlecode.objectify.Key;

import service.ServiceDemande;
import model.Commentaire;
import model.Demande;
import model.Utilisateur;


public class FormulaireCommentaireD extends Formulaire{
	private static final String COM = "com";
	
	    public void ajouterCommentaire(HttpServletRequest request,Demande demande,Utilisateur utilisateur) {
	    	String comment;
	    	comment = request.getParameter(COM);
	    	System.out.println("COM : "+demande.id);
	    	Key<Demande> cleDemande = Key.create(model.Demande.class, demande.id);
	    	Commentaire tmp = new Commentaire(comment,utilisateur.login,cleDemande);
	    	ServiceDemande sd = new ServiceDemande();
	    	sd.laisserCommentaire(tmp);	    	
	    }
	    
}
