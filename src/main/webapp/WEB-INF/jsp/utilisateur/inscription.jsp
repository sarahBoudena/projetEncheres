<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Enchères - Inscription</title>
</head>
<body >
	<!--Header-->
	<jsp:include page="/WEB-INF/fragment/header.jsp"></jsp:include>
	
	<main class = "text-center">
		<h1>Mon profil</h1>
			
		<!-- Erreurs -->
		<!-- Erreur mot de passe -->
		<c:if test="${erreur != null}">
			<div class="d-flex alert-danger">
			    <div class="col-3 p-2">
			        <img class="small-icon" src="<%=request.getContextPath()%>/medias/img/erreur.png" alt ="icone erreur" >
			    </div>
			    <ul class="col-9 list-unstyled p-2">
			       <li>${erreur}</li>
				</ul>
		    </div>
		</c:if>
		<!-- Liste erreurs BLL -->
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
	
		<!-- Formulaire -->
		<form action="<%=request.getContextPath()%>/inscription" method="post">
			<ul class = "row list-group-flush">
			
				<li class = "col-12 text-center list-group-item border-0" ></li>
				
				<li class = "col-6 text-right list-group-item border-0" ><label>pseudo </label></li>
				<li class = "col-6 text-left list-group-item border-0"> <input type="text" name="pseudo" id="pseudo" placeholder="pseudo" value="${requestScope.pseudo}" required="required"></li>
				
				<li class = "col-6 text-right list-group-item border-0" ><label>Nom </label></li>
				<li class = "col-6 text-left list-group-item border-0"> <input type="text" name="nom" id="name" placeholder="NOM" value="${requestScope.nom}" required="required"></li>
			
				<li class = "col-6 text-right list-group-item border-0" >Prénom </li>
				<li class = "col-6 text-left list-group-item border-0" > <input type="text" name="prenom" id="firstname" placeholder="Prénom" value="${requestScope.prenom}" required="required"></li>
			
				<li class = "col-6 text-right list-group-item border-0" >Email </li>
				<li class = "col-6 text-left list-group-item border-0"> <input type="email" name="email" id="email" placeholder="exemple@email.fr" value="${requestScope.email}" required="required"></li>
			
				<li class = "col-6 text-right list-group-item border-0" >Téléphone </li>
				<li class = "col-6 text-left list-group-item border-0"> <input type="text" name="telephone" id="tel" placeholder="0123456789" value="${requestScope.tel}" ></li>
			
				<li class = "col-6 text-right list-group-item border-0" >Rue </li>
				<li class = "col-6 text-left list-group-item border-0"> <input type="text" name="rue" id="rue" placeholder="rue de la Paix" value="${requestScope.rue}" required="required"></li>
			
				<li class = "col-6 text-right list-group-item border-0" >Code postal </li>
				<li class = "col-6 text-left list-group-item border-0"> <input type="text" name="codepostal" id="cp" placeholder="44000" value="${requestScope.cp}" required="required"></li>
			
				<li class = "col-6 text-right list-group-item border-0" >ville </li>
				<li class = "col-6 text-left list-group-item border-0"> <input type="text" name="ville" id="ville" placeholder="Nantes" value="${requestScope.ville}" required="required"></li>
				
				<li class = "col-6 text-right list-group-item border-0" >Mot de passe </li>
				<li class = "col-6 text-left list-group-item border-0"> <input type="password" name="mdp1" id="password1" placeholder="Entrez votre mot de passe" required="required"></li>
				
				<li class = "col-6 text-right list-group-item border-0" >Confimation </li>
				<li class = "col-6 text-left list-group-item border-0"> <input type="password" name="mdp2" id="password2" placeholder="Entrez votre mot de passe" required="required"></li>
				
				<li class = "col-12 text-center list-group-item border-0" ><a><button type="submit">Créer</button></a></li>
				
				
			</ul>	
		</form>
		<ul class = "row list-group-flush">
			<li class = "col-12 text-center list-group-item border-0" ><a class="text-center" href="<%=request.getContextPath()%>/accueil"><button>Annuler</button></a></li>
		</ul>
	</main>
	<!-- fragment JSP footer -->
  	<jsp:include page="/WEB-INF/fragment/footer.jsp"></jsp:include>    
</body>
</html>