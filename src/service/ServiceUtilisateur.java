package service;


import com.googlecode.objectify.ObjectifyService;

import dao.DaoUtilisateur;
import model.Demande;
import model.Utilisateur;

public class ServiceUtilisateur implements InterfaceServiceUtilisateur{
static{
	ObjectifyService.register(model.Utilisateur.class);
}
	@Override
	public void inscription(String login, String password, String adresse, String email) {
		DaoUtilisateur db = new DaoUtilisateur();
		Utilisateur utilisateur = new Utilisateur(login,password,adresse,email); 
		if (db.create(utilisateur)) 
			System.out.println("L'utilisateur "+login+" est inscrit dans la base");
		else
			System.out.println("l'utilisateur n'a pas pu etre inscrit");
	}

	@Override
	public boolean connexion(String email, String password) {
		DaoUtilisateur du= new DaoUtilisateur();
		Utilisateur result;
		
		result = du.read(email);
	
		return (result.getPassword().equalsIgnoreCase(password));
	}

	@Override
	public boolean deconnexion() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void majProfil(Utilisateur utilisateur, Utilisateur utilisateurmodif) {
		DaoUtilisateur db = new DaoUtilisateur();
		db.update(utilisateurmodif);
	}

	@Override
	public boolean isconnect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addFavori(Utilisateur utilisateur, Demande demande) {
		// TODO Auto-generated method stub
		
	}
	
	public Utilisateur getUtilisateur(String email) {
		DaoUtilisateur dao = new DaoUtilisateur();
		return (Utilisateur)dao.read(email);
	}

	@Override
	public void follow(Utilisateur utilisateur, Demande annonce) {
		// TODO Auto-generated method stub
		
	}

}
