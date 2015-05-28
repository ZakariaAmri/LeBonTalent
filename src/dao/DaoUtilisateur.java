package dao;

import model.Utilisateur;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;

public class DaoUtilisateur implements Crud{	
	static{
        ObjectifyService.register(model.Utilisateur.class);
        ObjectifyService.register(model.Demande.class);
        ObjectifyService.register(model.Commentaire.class);
        ObjectifyService.register(model.Note.class);
	}
	@Override
	public boolean create(Object obj) {
		if(obj instanceof Utilisateur) {
			Utilisateur newUser = (Utilisateur) obj;
			ObjectifyService.ofy().save().entity(newUser).now();
		return true;
		}
		return false;
	}

	@Override
	public Utilisateur read(String recherche) {
		ObjectifyService.ofy().clear();
		Utilisateur user = ObjectifyService.ofy().load().type(model.Utilisateur.class).id(recherche).safe();
		return user;
	}
	
	@Override
	public boolean update(Object obj) {
		return this.create(obj);
	}

	@Override
	public boolean delete(String id) {
		ObjectifyService.ofy().delete().type(model.Utilisateur.class).id(id).now();
		return true;
	}

	public Key<Utilisateur> getKey(Utilisateur user, String email) {
		Key<Utilisateur> cleUtilisateur = Key.create(model.Utilisateur.class, email);
		return cleUtilisateur;
	}
}
