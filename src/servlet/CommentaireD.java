package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoUtilisateur;
import model.Demande;
import model.Utilisateur;
import service.ServiceDemande;
import formulaire.FormulaireCommentaireD;


@SuppressWarnings("serial")
public class CommentaireD extends HttpServlet {
	
	public static final String VUE = "/jspGet/com.jsp";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession session = request.getSession();
        FormulaireCommentaireD form = new FormulaireCommentaireD();

        ServiceDemande sd = new ServiceDemande();
    	Demande demande = null;
    	try {
    		System.out.println("ref dem"+session.getAttribute("rfc"));
    		demande =sd.get(session.getAttribute("rfc").toString());
    		//demande = (Demande) request.getAttribute("suppDemande");
    		System.out.println("ref : demande"+demande);
		
			DaoUtilisateur du = new DaoUtilisateur();
			Utilisateur useur=(Utilisateur) du.read((String)session.getAttribute("sessionUtilisateur"));
			System.out.println("ref : user"+useur);
			form.ajouterCommentaire(request, demande, useur);
			response.sendRedirect("/demandedetails?refDemande="+session.getAttribute("rfc"));
		} catch(NullPointerException npe) {
			this.getServletContext().getRequestDispatcher( "/jspForm/connexion.jsp" ).forward( request, response );
		} catch(IllegalArgumentException iae) {
			this.getServletContext().getRequestDispatcher( "/connexion" ).forward( request, response );
		}
        

	}
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
        FormulaireCommentaireD form = new FormulaireCommentaireD();

        ServiceDemande sd = new ServiceDemande();
    	Demande demande = null;
		demande =sd.get(request.getParameter("refDemande"));

		DaoUtilisateur du = new DaoUtilisateur();
		Utilisateur useur=(Utilisateur) du.read((String)session.getAttribute("sessionUtilisateur"));

        form.ajouterCommentaire(request, demande, useur);
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

}
