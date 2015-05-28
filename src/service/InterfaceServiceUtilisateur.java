package service;

import model.Demande;
import model.Utilisateur;

public interface InterfaceServiceUtilisateur {
	/**
	 * Permet à un utilisateur de s'inscrire
	* @param login
	* @param password
	* @param adresse
	* @param email
	*/
    public void inscription(String login, String password, String adresse, String email);
    
    /**
     * permet à un utilisateur de se connecté
     * @param email
     * @param password
     * @return
     */
    public boolean connexion(String email,String password);
    /**
     * 
     * @return
     */
    
    public boolean deconnexion();
    
    /**
     * permet à l'utilisateur de le mettre à jour
     * @param utilisateur
     * @param adresse
     * @param email
     */
    public void majProfil(Utilisateur utilisateur,Utilisateur utilisateurmodif);
    
    /**
     * Verifie si l'utilisateur est connecter
     * @return
     */
    public boolean isconnect();
    
    /**
     * Ajoute une demande à la liste de l'utilisateur
     * @param utilisateur
     * @param demande
     */
    public void addFavori(Utilisateur utilisateur,Demande demande);
    
    /**
     * Ajoute une anonnce à la liste  de l'utilisateur
     * @param utilisateur
     * @param annonce
     */
    public void follow(Utilisateur utilisateur,Demande annonce);
}
