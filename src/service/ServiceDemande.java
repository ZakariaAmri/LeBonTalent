package service;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.Key;

import dao.DaoCommentaire;
import dao.DaoDemande;
import model.Commentaire;
import model.Demande;
import model.Utilisateur;

public class ServiceDemande implements InterfaceServiceDemande{

	@Override
	public boolean nouvelleDemande(String titre, String domaine, String localisation, String description, int prix, Key<Utilisateur>  user,String type) {
		Demande demande = new Demande( titre,  domaine,  localisation, description, prix, user,type);
		DaoDemande dao = new DaoDemande();
		dao.create(demande);
		return false;
	}

	
	public boolean updateDemande(Demande demande) {
		DaoDemande dao = new DaoDemande();
		dao.update2(demande);
		return false;
	}
	
	/*
	public Demande recupererDemande(){
		
	}
	*/
	@Override
	public void arreterDemande(Demande demande) {
		DaoDemande dao = new DaoDemande();
		Object result = dao.read2(demande.getId());
		Demande nouvelleDemande = (Demande)result;
		nouvelleDemande.setActif(false);
		dao.create(nouvelleDemande);
	}

	@Override
	public void laisserCommentaire(Commentaire com) {
		DaoCommentaire dc = new DaoCommentaire();
		dc.create(com);
	}

	public List<Commentaire> getAllCommentaire(Demande demande){
		DaoCommentaire dc = new DaoCommentaire();
		List<Commentaire> result = dc.getAllcom(demande);
		return (result.isEmpty())?null:result;
	}

	@Override
	public void ajouterFavorie(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Demande> getAll() {
		DaoDemande dao = new DaoDemande();
		List<Demande> result = new ArrayList<Demande>();
		result = dao.getAllEntity();
		return result;
	}
	
	public Demande get(String id){
		DaoDemande dao = new DaoDemande();
		long ids;
		ids = Long.parseLong(id);
		Demande demande = null;
		demande = (Demande)dao.read2(ids);
		return demande;
	}
	
	public void maj(Demande demande){
		DaoDemande dao = new DaoDemande();
		dao.update(demande);
	}
	public List<Demande> search(String name){
		DaoDemande dao = new DaoDemande();
		return dao.search(name);
	}
	public List<Demande> getDemandeInscrit(Utilisateur user){
		DaoDemande dao = new DaoDemande();
		return dao.getMine(user);
	}
	public List<Demande> getAnnonceInscrit(Utilisateur user){
		DaoDemande dao = new DaoDemande();
		return dao.getMine2(user);
	}

	public void deleteDemande(Demande demande){
		DaoDemande dd = new DaoDemande();
		dd.deleteLong(demande)	;
	}
	
	public List<Demande> getAllAnnonce(){
		DaoDemande dao = new DaoDemande();
		List<Demande> result = new ArrayList<Demande>();
		result = dao.getAllAnnonce();
		return result;
	}
	public List<Demande> getAllDemandes(){
		DaoDemande dao = new DaoDemande();
		List<Demande> result = new ArrayList<Demande>();
		result = dao.getAllDemandes();
		return result;
	}
}
