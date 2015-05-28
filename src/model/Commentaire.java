package model;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;

@Entity
@Index
public class Commentaire {
	@Id public Long id;
	@Parent public Key<Demande> idDemande;
	public String com;
	public String login;
	public String date;
	
	public Commentaire(){
		super();
	}
	
	public Commentaire(String com,String login,Key<Demande> idDemande) {
		this.com = com;
		this.login = login;
		this.idDemande = idDemande;
		this.date = this.setDate();
	}
	
	public String setDate(){
		String format = "dd/MM/yy H:mm:ss"; 

		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format ); 
		java.util.Date date = new java.util.Date(); 

		return formater.format( date ) ; 
		
	}

}
