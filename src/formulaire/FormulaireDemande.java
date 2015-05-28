package formulaire;

import javax.servlet.http.HttpServletRequest;

import com.googlecode.objectify.Key;

import dao.DaoDemande;
import model.Demande;
import model.Utilisateur;
import service.ServiceDemande;


public class FormulaireDemande extends Formulaire{
	private static final String TITRE = "titre";
	private static final String DOMAINE = "domaine";
	private static final String LOCALISATION = "localisation";
	private static final String DESCRIPTION = "description";
	private static final String PRIX = "prix";
	private static final String TYPE = "type";
    
    public Demande nouvelleDemande(HttpServletRequest request,Key<Utilisateur>  user) {
    	String titre;
    	String domaine;
    	String localisation;
    	String description;
    	String prix;
    	String type;
    	ServiceDemande sd = new ServiceDemande();
    	titre = getValeurChamp(request,TITRE);
    	domaine = getValeurChamp(request,DOMAINE);
    	localisation = getValeurChamp(request,LOCALISATION);
    	description = getValeurChamp(request,DESCRIPTION);
    	prix = getValeurChamp(request,PRIX);
    	type = getValeurChamp(request,TYPE);
    	Demande demande = new Demande(titre, domaine, localisation, description, Integer.parseInt(prix), user,type);
    	sd.nouvelleDemande(titre, domaine, localisation, description, Integer.parseInt(prix), user,type);
		return demande;
    }
    public Demande updateDemande(HttpServletRequest request,Key<Utilisateur>  user,Demande tmp) {
    	String titre;
    	String domaine;
    	String localisation;
    	String description;
    	String prix;
    	String type;
    	
    	ServiceDemande sd = new ServiceDemande();
    	
    	titre = getValeurChamp(request,TITRE);
    	domaine = getValeurChamp(request,DOMAINE);
    	localisation = getValeurChamp(request,LOCALISATION);
    	description = getValeurChamp(request,DESCRIPTION);
    	prix = getValeurChamp(request,PRIX);
    	type = getValeurChamp(request,TYPE);
    	
    	tmp.titre = titre;
    	tmp.domaine=domaine;
    	tmp.localisation=localisation;
    	tmp.description=description;
    	tmp.prix=Integer.parseInt(prix);
    	
    	tmp.type=type;
    	DaoDemande dd = new DaoDemande();
    	dd.update(tmp);
    	//Sauvegarde de l'instance
    	sd.updateDemande(tmp);
		return tmp;
    }
    
}
