package service;

import java.util.List;

import com.googlecode.objectify.Key;

import model.Commentaire;
import model.Demande;
import model.Utilisateur;

public interface InterfaceServiceDemande {
	public boolean nouvelleDemande(String titre, String domaine, String localisation, String description, int prix, Key<Utilisateur>  parent,String type);
    public void arreterDemande(Demande demande);
    public void laisserCommentaire(Commentaire com);
    public void ajouterFavorie(Utilisateur utilisateur);
    public List<Demande> getAll();
}
