<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="model.* "%>
<%@page import="service.* "%>
<%@page import="dao.* "%>
<%@page import="java.util.* "%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="com.googlecode.objectify.Key;"%>
<% 
ServiceDemande sd = new ServiceDemande();	
model.Demande attribut = (model.Demande) request.getAttribute("DemandeDetail");
//attribut =sd.get(request.getParameter("refDemande"));
//out.println(request.getParameter("refDemande"));
request.setAttribute("suppDemande", attribut);

String redirection = "deleteD?refForSupDem="+attribut.id ;
String redirectionmodif = "modificationD?refForSupDem="+attribut.id ;
String id = attribut.id.toString();
String titre = attribut.getTitre();

%>
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
<body>
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
                                    	model.Utilisateur attribut2 ;
                                    	
                                    	try{
                                    		attribut2 = du.read((String)session.getAttribute("sessionUtilisateur"));
                                        	List<model.Demande> demandes = (List<model.Demande>) sd.getDemandeInscrit(attribut2);
                                        	String affichage="";
                                    		affichage += "<h4 class=\"media-heading\">"+attribut2.getLogin()+"</h4>";
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
                    <h4 class="page-head-line">Demandes détail</h4>
                </div>
			</div>
			<div class="row">
                    <div class="col-md-6">
                        <div class="panel panel-default">
                        <div class="panel-heading">
                          <Strong> DEMANDE : <%= id %></Strong>
                        </div>
                        <div class="panel-body">
                        <%
                        out.println( " <label for=\"login\">Crée par :</label>");
                        out.println( attribut.user.getName()+"<br>");
                        out.println( " <label for=\"statu\">Statu:</label>");
                        out.println( attribut.actif+"<br>" );
                        out.println( " <label for=\"titre\">titre:</label>");
                        out.println( titre+"<br>" );
                        out.println( " <label for=\"domaine\">Domaine:</label>");
                        out.println( attribut.domaine+"<br>" );
                        out.println( " <label for=\"description\">Description:</label>");
                        out.println( attribut.description+"<br>" );
                        out.println( " <label for=\"prix\">Prix:</label>");
                        out.println( attribut.prix+"<br>");
                        %>
                        </div>
              	 </div>
              	 <hr />
            		<a href=<%= redirectionmodif %>> <button class="btn btn-primary"><i class="fa fa-edit "></i> Edit</button></a>
					<a href=<%= redirection %>> <button class="btn btn-danger"><i class="fa fa-pencil"></i> Delete</button></a>
            </div>
            </div>
            <hr />
            
            <%@include file="/jspForm/commentaired.jsp" %>
            
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
