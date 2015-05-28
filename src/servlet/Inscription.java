package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utilisateur;
import formulaire.FormulaireInscription;

@SuppressWarnings("serial")
public class Inscription extends HttpServlet {
    public static final String VUE              = "/jspForm/inscription.jsp";
    
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page de connexion */    	
    	this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        FormulaireInscription form = new FormulaireInscription();
        /* Traitement de la requête et récupération du bean en résultant */
        Utilisateur utilisateur = form.inscriptionUtilisateur(request);
        //this.getServletContext().getRequestDispatcher( "index.html" ).forward( request, response );
        if(utilisateur !=null)
        	response.sendRedirect("index.html");
        else
        	this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

}
