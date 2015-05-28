package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import formulaire.FormulaireConnexion;


@SuppressWarnings("serial")
public class Connexion extends HttpServlet {
	public static final String VUE = "/jspForm/connexion.jsp";
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
       this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		FormulaireConnexion form = new FormulaireConnexion();
		HttpSession session = request.getSession();
    	session = request.getSession();
        /* Préparation de l'objet formulaire */      
        try{
        	form.sessionUtilisateur(session, request);
        	response.sendRedirect("index.jsp");
        }catch(NullPointerException npe){
     
        	this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
        }
    }
}
