package dao;

import java.util.List;

import model.Commentaire;
import model.Demande;

import com.google.appengine.api.datastore.KeyFactory;
import com.googlecode.objectify.ObjectifyService;

public class DaoNote {
	static {
        ObjectifyService.register(model.Utilisateur.class);
        ObjectifyService.register(model.Demande.class);
        ObjectifyService.register(model.Commentaire.class);
        ObjectifyService.register(model.Note.class);
    }
	
	public void create(Commentaire obj) {
		ObjectifyService.ofy().save().entity(obj).now();
	}
	
	public List<Commentaire> getAllcom(Demande demande){
		return ObjectifyService.ofy().load().type(Commentaire.class).ancestor(KeyFactory.createKey("Demande", demande.id)).list();
	}
}
