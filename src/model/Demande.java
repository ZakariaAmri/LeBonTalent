package model;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.annotation.*;
import com.googlecode.objectify.Key;

@Entity
@Index
public class Demande{
	@Id public Long id;
	@Parent public Key<Utilisateur>  user;
	public String titre;
	public String type;
	public String domaine;
	public String localisation;
	public String description;
	public int prix;
	public boolean actif;
	public List<Integer> note;
    public Long getId(){
    	return id;
	}

	public  List<String> commentaire;
	public  List<String> idCommentaire;
    //@Serialized private    ist<Commentaire> commentaire;
    

	public Demande(){
    }
    public Demande(String titre, String domaine,
			String localisation, String description, int prix,Key<Utilisateur> parent,String type) {
		this.titre = titre;
		//this.domaine = new ArrayList<String>();
		this.domaine = domaine;
		this.localisation = localisation;
		this.description = description;
		this.prix = prix;
		this.actif = true;
		this.commentaire = new ArrayList<String>();
		this.note = new ArrayList<Integer>();
		//List<Commentaire> aux = new ArrayList<Commentaire>();
		//this.commentaire = aux;
		this.type = type;
		this.user = parent;
    }
    
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDomaine() {
		return this.domaine;
	}

	public void addDomaine(String domaine) {
		this.domaine = domaine;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean value) {
		this.actif = value;
	}
}
