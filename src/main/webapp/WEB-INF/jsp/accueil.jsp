<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    
<title>Accueil</title>
</head>
<body>
	<div class="container-fluid">
	    <!--fullHeader-->
	   
	    <!-- fragment JSP header -->
	    <jsp:include page="/WEB-INF/fragment/header.jsp"></jsp:include>
	    <!--main bloc-->
	    <main>
	        <!--title-->
	        <div class="mx-auto text-center">
	            <h1>Enchères</h1>
	        </div>
	        <!--erreur-->
	        <c:if test="${error != null}">
				<div class="d-flex alert-danger">
				    <div class="col-3 p-2">
				        <img class="small-icon" src="<%=request.getContextPath()%>/medias/img/erreur.png" alt ="icone erreur" >
				    </div>
				    <ul class="col-9 list-unstyled p-2">
				       <c:forEach var="element" items="${error.getBLLExceptions()}">
				       		<li>${element.getMessage()}</li>
				       </c:forEach>
				    </ul>
			    </div>
			</c:if>
			<c:if test="${erreur != null}">
				<div class="d-flex alert-danger">
				    <div class="col-3 p-2">
				        <img class="small-icon" src="<%=request.getContextPath()%>/medias/img/erreur.png" alt ="icone erreur" >
				    </div>
				    <ul class="col-9 list-unstyled p-2">
				       <li>${erreur.message}</li>
					</ul>
			    </div>
			</c:if>
	        <c:if test="${success != null}">
				<div class="d-flex alert-success">
				    <div class="col-2 p-2">
				        <img class="small-icon" src="<%=request.getContextPath()%>/medias/img/gagnant.png" alt ="icone reussite" >
				    </div>
				    <ul class="col-10 list-unstyled p-2">
			       		<li>${success}</li>
				    </ul>
			    </div>
			</c:if>
	        <!--filtre-->
	        <form class="form-filter border mb-3" action="#" method="">
	            <div class="row">
	                <!--Partie gauche-->
	                <div class="col-md-6 mb-3">
	                    <div class="form-group">
	                            <label for="filter-input">Filtre</label>
	                            <input type="text" class="form-control" id="filter-input" name="q" placeholder="articles contenant...">
	                    </div>
	                    <div class="form-group">
	                        <label for="categories-select">Catégories</label>
	                        <select class="form-control" id="categories-select" name="categorie">
	                            <option selected>Toutes</option>
	                            <option name="categorie" value="">Informatique</option>
	                            <option name="categorie" value="">Ameublement</option>
	                            <option name="categorie" value="">Vêtement</option>
	                            <option name="categorie" value="">Sport & Loisirs</option>
	                        </select>
	                    </div>
	                </div>
	                <!--Partie droite-->
	                <div class="col-md-6 mb-3">  	
	                    <div class="form-check">
	                        <label class="form-check-label">
	                            <input type="radio" class="form-check-input" checked name="type-encheres" value="achats" id="achats">Achats
	                        </label>
	                    </div>
	                    <div class="form-group">
	                        <div class="form-check">
	                            <label class="form-check-label">
	                                <input type="checkbox" class="form-check-input" checked name="encheres" value="ouvertes" id="ouvertes">Enchères ouvertes
	                            </label>
	                        </div>
	                        <div class="form-check">
	                            <label class="form-check-label">
	                                <input type="checkbox" class="form-check-input" name="encheres" value="encours" id="encours">Mes enchères en cours
	                            </label>
	                        </div>
	                        <div class="form-check">
	                            <label class="form-check-label">
	                                <input type="checkbox" class="form-check-input" name="encheres" value="remportees" id="remportees">Mes enchères remportées
	                            </label>
	                        </div>
	                    </div>
	                    <div class="form-check">
	                        <label class="form-check-label">
	                            <input type="radio" class="form-check-input" name="type-encheres" value="ventes" id="ventes">Ventes
	                        </label>
	                    </div>
	                    <div class="form-group">
	                        <div class="form-check">
	                            <label class="form-check-label">
	                                <input type="checkbox" class="form-check-input" name="ventes" value="venteencours" id="venteencours">Mes ventes en cours
	                            </label>
	                        </div>
	                        <div class="form-check">
	                            <label class="form-check-label">
	                                <input type="checkbox" class="form-check-input" name="ventes" value="nondebutees" id="nondebutees">Mes ventes non débutées
	                            </label>
	                        </div>
	                        <div class="form-check">
	                            <label class="form-check-label">
	                                <input type="checkbox" class="form-check-input" name="ventes" value="terminees" id="terminees">Mes ventes terminées
	                            </label>
	                        </div>
	                    </div>
	
	                </div>
	            </div>
	            <button class="btn btn-primary btn-lg btn-block" type="submit">
	            	<img class="small-icon" src="images/search.svg" alt="Rechercher">
	            </button>
	        </form>
	
	        <!--enchères-->
      	  <div class="row justify-content-center border-top card-deck">
      		<c:forEach var="element" items="${listeEncheresEC}">	    		
                <div class="col-6 col-sm-6 p-2" >
                    <div class="card">
                        <div class="card-header text-center">
                            <h4 class="my-0 font-weight-normal">${element.nom}</h4>
                        </div>
                        <div class="d-flex">
		                 	<div class="col-3 p-2">
		                    	<img class="img-fluid img-thumbnail" src="images/photo.svg" alt="pas de photo" />
		                    </div>
		                    <ul class="col-9 list-unstyled p-2">
		                    	<li>Prix : ${element.prixInitial} point(s)</li>
						       	<li>Meilleure enchère : ${element.enchere.montantEnchere !=null ? element.enchere.montantEnchere : 0} point(s)</li>
						        <li>Fin de l'enchère : ${element.getDateFinEncheres()}</li>
						         <li>Vendeur : ${element.getUtilisateur().getPseudo()}</li>
	                        </ul>
	                    </div>
	                    	<c:if test="${!empty user}">
			                  	<a class="mt-3 btn btn-lg btn-block btn-primary" href="<%=request.getContextPath()%>/article/detail?noArticle=${element.noArticle}" title="faire une enchère">
		              	          <img class="small-icon" src="<%=request.getContextPath()%>/medias/img/marteau.png"/>
			                    </a>
		                	</c:if>
	                </div>
	            </div> 
	        </c:forEach>
	        </div>
	      </main>


		<!-- fragment JSP footer -->
   <jsp:include page="/WEB-INF/fragment/footer.jsp"></jsp:include>      
</body>
</html>
