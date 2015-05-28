package dao;

import java.util.ArrayList;
import java.util.List;

import model.Demande;
import model.Utilisateur;

import com.google.appengine.api.datastore.KeyFactory;
import com.googlecode.objectify.ObjectifyService;

public class DaoDemande implements Crud{
	static {
        ObjectifyService.register(model.Utilisateur.class);
        ObjectifyService.register(model.Demande.class);
        ObjectifyService.register(model.Commentaire.class);
        ObjectifyService.register(model.Note.class);
    }
	@Override
	public boolean create(Object obj) {
		if(obj instanceof Demande) {
			Demande newDemande = (Demande)obj;
			ObjectifyService.ofy().save().entity(newDemande).now();
		return true;
		}
		return false;
	}

	@Override
	public Object read(String recherche) {
		Demande result = ObjectifyService.ofy().load().type(model.Demande.class).parent("utilisateur").id(recherche).now();
		return result;
	}
	
	public List<Demande> getAllEntity() {
		List<Demande> resultAll = new ArrayList<Demande>();
		resultAll = ObjectifyService.ofy().load().type(model.Demande.class).list();
		return resultAll;
	}
	public List<Demande> getAllAnnonce() {
		List<Demande> resultAll = new ArrayList<Demande>();
		resultAll = ObjectifyService.ofy().load().type(model.Demande.class).filter("type =", "Annonce").list();
		return resultAll;
	}
	public List<Demande> getAllDemandes() {
		List<Demande> resultAll = new ArrayList<Demande>();
		resultAll = ObjectifyService.ofy().load().type(model.Demande.class).filter("type =", "Demande").list();
		return resultAll;
	}
	public List<Demande> search(String name) {
		List<Demande> resultAll = new ArrayList<Demande>();
		resultAll = ObjectifyService.ofy().load().type(model.Demande.class).filter("titre =", name).list();
		return resultAll;
	}
	
	public Demande read2(Long id) {
		List<Demande> listDemande = this.getAllEntity();
		Demande resultat = null;
		long dif2=0;
		boolean bool = true;
		for(int i = 0; (i < listDemande.size())&&bool;i++) {
			dif2 = id - listDemande.get(i).id;
			if(dif2 ==0){
				resultat = listDemande.get(i);
				bool = false;
			}

		} 
		return resultat;
	}

	@Override
	public boolean update(Object obj) {
		return this.create(obj);
	}
	public boolean update2(Demande obj) {
		return this.create(obj);
	}

	@Override
	public boolean delete(String id) {
		ObjectifyService.ofy().delete().type(model.Demande.class).id(id).now();
		return true;
	}
	public boolean deleteLong(Demande id) {
		 ObjectifyService.ofy().delete().entities(id);
		return true;
	}
	
	public List<Demande> getMine(Utilisateur user){
		return ObjectifyService.ofy().load().type(Demande.class).ancestor(KeyFactory.createKey("Utilisateur", user.email)).filter("type =", "Demande").list();
	}
	public List<Demande> getMine2(Utilisateur user){
		return ObjectifyService.ofy().load().type(Demande.class).ancestor(KeyFactory.createKey("Utilisateur", user.email)).filter("type =", "Annonce").list();
	}
	

}
