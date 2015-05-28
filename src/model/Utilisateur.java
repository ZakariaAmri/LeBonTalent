package model;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.*;

import com.googlecode.objectify.annotation.*;
import com.googlecode.objectify.annotation.Index;

@Entity
@Index
public class Utilisateur {
	@Id public String email;
	public String login;
	public String password;
	public String adresse;
   
    @Embedded private List<Demande> follow;
    @Embedded private List<Demande> favorie; 
    
    public Utilisateur(String login, String password, String adresse, String email) {
    	super();
		this.login = login;
		this.password = password;
		this.adresse = adresse;
		this.email = email;
		List<Demande> initAnnonce = new ArrayList<Demande>();
		List<Demande> initDemande = new ArrayList<Demande>();
		this.follow = initAnnonce;
		this.favorie = initDemande; 
    }
    public Utilisateur() {
    	super();
    }

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
/*
	public Annonce getFollow(int indice) {
		return follow.get(indice);
	}

	public void addFollow( Annonce follow) {
		this.follow.add(follow);
	}

	public Demande getFavorie(int indice) {
		return favorie.get(indice);
	}

	public void addFavorie(Demande favorie) {
		this.favorie.add(favorie);
	}
    */
    
}