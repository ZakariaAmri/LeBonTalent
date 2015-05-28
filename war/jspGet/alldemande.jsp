<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="model.* "%>
<%@page import="dao.* "%>
<%@page import="service.* "%>
<%@page import="java.util.* "%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
    <title>LE BON TALENT</title>
    <!-- BOOTSTRAP CORE STYLE  -->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FONT AWESOME ICONS  -->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <!-- CUSTOM STYLE  -->
    <link href="assets/css/style.css" rel="stylesheet" />
     <!-- HTML5 Shiv and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<div class="navbar navbar-inverse set-radius-zero">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">

                    <img src="assets/img/logo.png" />
                </a>

            </div>

            <div class="left-div">
                <div class="user-settings-wrapper">
                    <ul class="nav">


				<li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                                <span class="glyphicon glyphicon-user" style="font-size: 25px;"></span>
                            </a>
                            <div class="dropdown-menu dropdown-settings">
                                <div class="media">
                                    <a class="media-left" href="#">
                                        <span style="font-size: 50px;" class="glyphicon glyphicon-user"></span>
                                    </a>
                                    <div class="media-body">
                                    <%
                                    	DaoUtilisateur du = new DaoUtilisateur();
                                    	model.Utilisateur attribut ;
                                    	
                                    	ServiceDemande sd = new ServiceDemande();
                                    	try{
                                    		attribut= du.read((String)session.getAttribute("sessionUtilisateur"));
                                        	List<model.Demande> demandes = (List<model.Demande>) sd.getDemandeInscrit(attribut);
                                        	String affichage="";
                                    		affichage += "<h4 class=\"media-heading\">"+attribut.getLogin()+"</h4>";
                                    		affichage += "</div></div><hr /><h5><strong>Nombre de demande:</strong></h5>";
                                    		if(!demandes.isEmpty())
                                            	affichage +=  demandes.size()+"<hr />";
                                    		else
                                    			affichage +=  "0<hr />";
                                            affichage +="<a href=\"profil\" class=\"btn btn-info btn-sm\">Full Profile</a>&nbsp; <a href=\"login.html\" class=\"btn btn-danger btn-sm\">Logout</a>";
                                            out.print(affichage);
                                    	}catch(NullPointerException npe){
                                    		out.println("<br><br><hr/><a href=\"connexion\" class=\"btn btn-danger btn-lg\">Connexion</a>&nbsp;<a href=\"inscription\" class=\"btn btn-info btn-lg\">Inscription</a>");	
                                    	}catch(IllegalArgumentException iae){
                                    		out.println("<br><br><hr/><a href=\"connexion\" class=\"btn btn-danger btn-lg\">Connexion</a>&nbsp;<a href=\"inscription\" class=\"btn btn-info btn-lg\">Inscription</a>");
                                    	}
                                    %></div></li>
                    </div>
                </div>
            </div>
        </div>
    <!-- LOGO HEADER END-->
<section class="menu-section">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="navbar-collapse collapse ">
                        <ul id="menu-top" class="nav navbar-nav navbar-right">
                            		<li><a href="alldemande"><span class="glyphicon glyphicon-th-list"></span> Toutes les Demandes</a></li>
									<li><a href="allannonce"><span  class="glyphicon glyphicon-th-list"></span> Toutes les Annonces</a></li>
									<li><a href="searchd"><span  class="glyphicon glyphicon-search"></span> Recherche</a></li>
									<li><a href="demande"><span  class="glyphicon glyphicon-plus"></span> Crée un évènement</a></li>
                        </ul>
                    </div>
                </div>

            </div>
        </div>
</section>
    <!-- MENU SECTION END-->
    <div class="content-wrapper">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h4 class="page-head-line">Toutes les demandes</h4>
                </div>
			</div>
			<div class="row">
                         <%
           					 List<model.Demande> demandes = (List<model.Demande>) request.getAttribute("demandes");
            for(int i = 0; i< demandes.size();i++ ) {
            	request.setAttribute("DemandeDetail", demandes.get(i));
				request.getParameter("refDemande");
				String design="<div class=\"col-md-3 col-sm-3 col-xs-6\"><div class=\"dashboard-div-wrapper bk-clr-two\"><i  class=\"fa fa-edit dashboard-div-icon\" ></i><div class=\"progress progress-striped active\"><div class=\"progress-bar progress-bar-warning\" role=\"progressbar\" aria-valuenow=\"80\" aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width: 100%\"></div></div>";
            	//String redirection = request.getContextPath()+"/demandedetails";
            	out.print(design+"<a href ="+request.getContextPath()+"/demandedetails?refDemande="+demandes.get(i).id+"><h5>"+demandes.get(i).getTitre()+"</h5></a></div></div>");
            	
            }
            %>
              </div>
		</div>
    </div>
    <!-- CONTENT-WRAPPER SECTION END-->
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    &copy; 2015 LE BON TALENT |UPMC - DANT
                </div>

            </div>
        </div>
    </footer>
    <!-- FOOTER SECTION END-->
    <!-- JAVASCRIPT AT THE BOTTOM TO REDUCE THE LOADING TIME  -->
    <!-- CORE JQUERY SCRIPTS -->
    <script src="assets/js/jquery-1.11.1.js"></script>
    <!-- BOOTSTRAP SCRIPTS  -->
    <script src="assets/js/bootstrap.js"></script>
</body>
</html>
