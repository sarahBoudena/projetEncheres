<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<%--  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/inscription.css">   --%>


<title>Profil Utilisateur</title>
</head>
<body>
	
		<!-- fragment JSP navigation -->
	<jsp:include page="/WEB-INF/fragment/header.jsp"></jsp:include>
	
	<!--main bloc-->
	<main class = "text-center">
		<h1>Mon profil</h1>
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
		<c:if test="${simpleError != null}">
			<div class="d-flex alert-danger">
			    <div class="col-2 p-2">
			        <img class="small-icon" src="<%=request.getContextPath()%>/medias/img/erreur.png" alt ="icone erreur" >
			    </div>
			    <ul class="col-10 list-unstyled p-2">
		       		<li>${simpleError.getMessage()}</li>
			    </ul>
		    </div>
		</c:if>
		<c:if test="${listeModification != null}">
			<div class="d-flex alert-success">
			    <div class="col-2 p-2">
			        <img class="small-icon" src="<%=request.getContextPath()%>/medias/img/gagnant.png" alt ="icone reussite" >
			    </div>
			    <ul class="col-10 list-unstyled p-2">
			       <c:forEach var="element" items="${listeModification}">
			       		<li>${element}</li>
			       </c:forEach>
			    </ul>
		    </div>
		</c:if>
		<form action="<%=request.getContextPath()%>/utilisateur/update" method="post">
			<ul class = "row list-group-flush">
				<li class = "col-12 text-center list-group-item border-0" ></li>
				
				<li class = "col-6 text-right list-group-item border-0" ><label>pseudo </label></li>
				<li class = "col-6 text-left list-group-item border-0"> <input type="text" name="pseudo" id="pseudo" value ="${empty requestScope.pseudo ? sessionScope.user.pseudo : requestScope.pseudo }" required="required"></li>
				
				<li class = "col-6 text-right list-group-item border-0" ><label>Nom </label></li>
				<li class = "col-6 text-left list-group-item border-0"> <input type="text" name="nom" id="name" value ="${empty requestScope.nom ? sessionScope.user.nom : requestScope.nom }" required="required"></li>
			
				<li class = "col-6 text-right list-group-item border-0" >Prénom </li>
				<li class = "col-6 text-left list-group-item border-0" > <input type="text" name="prenom" id="firstname" value ="${empty requestScope.prenom ? sessionScope.user.prenom : requestScope.prenom}" required="required"></li>
			
				<li class = "col-6 text-right list-group-item border-0" >Email </li>
				<li class = "col-6 text-left list-group-item border-0"> <input type="email" name="email" id="email" value ="${empty requestScope.email ? sessionScope.user.email : requestScope.email}" required="required"></li>
			
				<li class = "col-6 text-right list-group-item border-0" >Téléphone </li>
				<li class = "col-6 text-left list-group-item border-0"> <input type="text" name="telephone" id="tel" value ="${empty requestScope.telephone ? sessionScope.user.telephone : requestScope.telephone}"></li>
			
				<li class = "col-6 text-right list-group-item border-0" >Rue </li>
				<li class = "col-6 text-left list-group-item border-0"> <input type="text" name="rue" id="rue" value ="${empty requestScope.rue ? sessionScope.user.rue : requestScope.rue}" required="required"></li>
			
				<li class = "col-6 text-right list-group-item border-0" >Code postal </li>
				<li class = "col-6 text-left list-group-item border-0"> <input type="text" name="codePostal" id="cp" value ="${empty requestScope.codePostal ? sessionScope.user.codePostal : requestScope.codePostal}" required="required"></li>
			
				<li class = "col-6 text-right list-group-item border-0" >ville </li>
				<li class = "col-6 text-left list-group-item border-0"> <input type="text" name="ville" id="ville" value ="${empty requestScope.ville ? sessionScope.user.ville : requestScope.ville}" required="required"></li>
				
				<li class = "col-6 text-right list-group-item border-0" >Mot de passe </li>
				<li class = "col-6 text-left list-group-item border-0"> <input type="password" name="mdp1" id="password1" placeholder="Entrez votre mot de passe" autocomplete="off" ></li>
				
				<li class = "col-6 text-right list-group-item border-0" >Confimation </li>
				<li class = "col-6 text-left list-group-item border-0"> <input type="password" name="mdp2" id="password2" placeholder="Entrez votre mot de passe" autocomplete="off"></li>
				
				<li class = "col-12 text-center list-group-item border-0" ><button type="submit">Enregistrer</button></li>
			</ul>
		</form>
		<a href="<%=request.getContextPath()%>/utilisateur/delete"><button>Supprimer le profil</button></a>
	</main>
		<!-- fragment JSP footer -->
  	<jsp:include page="/WEB-INF/fragment/footer.jsp"></jsp:include>	
</body>
</html>