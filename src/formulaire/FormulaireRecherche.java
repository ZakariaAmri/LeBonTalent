package formulaire;

import javax.servlet.http.HttpServletRequest;

import service.ServiceDemande;

public class FormulaireRecherche extends Formulaire{
	private static final String TITRE = "titre";
	private static final String DOMAINE = "domaine";
	private static final String LOCALISATION = "localisation";
	private static final String PRIX = "prix";
	private static final String TYPE = "type";
	
	public void lancerRecherche(HttpServletRequest request){
    	String titre;
    	String domaine;
    	String localisation;
    	String prix;
    	String type;
    	ServiceDemande sd = new ServiceDemande();
    	titre = getValeurChamp(request,TITRE);
    	domaine = getValeurChamp(request,DOMAINE);
    	localisation = getValeurChamp(request,LOCALISATION);
    	prix = getValeurChamp(request,PRIX);
    	type = getValeurChamp(request,TYPE);
	}
}
