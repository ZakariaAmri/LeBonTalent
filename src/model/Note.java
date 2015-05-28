package model;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;

@Entity
@Index
public class Note {
	@Id public Long id;
	@Parent public Key<Demande> idDemande;
	public float note;
	public String email;
	
}
