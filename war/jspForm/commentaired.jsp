<div class="row">
                <div class="col-md-6">
                      <div class="notice-board">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                           Active  Notice Panel 
                                <div class="pull-right" >
                                    <div class="dropdown">
  <button class="btn btn-success dropdown-toggle btn-xs" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
    <span class="glyphicon glyphicon-cog"></span>
    <span class="caret"></span>
  </button>
  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Refresh</a></li>
    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Logout</a></li>
 </ul>
	</div>
    	</div>
        	</div>
            	<div class="panel-body">
            	<!-- Lecture des commentaire -->
					<ul >
						<%
						DaoCommentaire dc = new DaoCommentaire();
						List<Commentaire> com = dc.getAllcom(attribut);
						int i;
						try {
							String affiche="";
							for(i = 0; i< com.size();i++){
								affiche ="<li><span class=\"glyphicon glyphicon-comment  text-warning\" ></span>";
								com.get(i);
								affiche+=com.get(i).date;
								affiche+="<br><strong style=\"text-transform:uppercase\">";
								affiche+=com.get(i).login+" : ";
								affiche+="</strong>";
								affiche+=com.get(i).com;
								affiche +="</li>";
								out.println(affiche);
							}
							
						}catch(NullPointerException npe){
							out.println("Ancun commentaire poster");
						}
						if(com.isEmpty()){
							out.println("<li>Ancun commentaire poster</li>");
						}
						%>
                     </ul>
                </div>
                <!-- Ecrire un commentaire -->
              	<div class="panel-footer">
             <div class="Compose-Message">               
                <div class="panel panel-success">
                    <div class="panel-heading">
                       Ecrire un commentaire
                    </div>
                    <div class="panel-body">
                       <form methode="post" action="/com">
                        <label>Entrer le Message : </label>
                        <textarea rows="9" id="com" name ="com" class="form-control"></textarea>
                        <hr />
                        
                        <input type="submit"  class="btn btn-warning" value="Envoie message" >&nbsp;
                        </form>
                </div>
         </div>
     </div>
</div>
</div>
</div>
</div>
</div>