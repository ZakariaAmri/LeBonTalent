package servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

@SuppressWarnings("serial")
public class ObjectifyServlet extends HttpServlet {
    static {
        ObjectifyService.register(model.Utilisateur.class);
        ObjectifyService.register(model.Demande.class);
        ObjectifyService.register(model.Commentaire.class);
    }
    
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
    }
} 


