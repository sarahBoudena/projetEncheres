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
			<div class="Container">
				<div class="form-group">
					<label>Pseudo :</label>
					<input type="text" name="pseudo" id="pseudo" value ="${empty requestScope.pseudo ? sessionScope.user.pseudo : requestScope.pseudo }" required="required">
	<!-- 			</div>
				
				<div class="form-group"> -->
					<label>Nom :</label>
					<input type="text" name="nom" id="name" value ="${empty requestScope.nom ? sessionScope.user.nom : requestScope.nom }" required="required">
				</div>
				
				<div class="form-group">
					<label>Prénom :</label>
					<input type="text" name="prenom" id="firstname" value ="${empty requestScope.prenom ? sessionScope.user.prenom : requestScope.prenom}" required="required">
	<!-- 			</div>
				
				<div class="form-group"> -->
					<label>Email :</label>
					<input type="email" name="email" id="email" value ="${empty requestScope.email ? sessionScope.user.email : requestScope.email}" required="required">
				</div>
				
				<div class="form-group">
					<label>Téléphone :</label>
					<input type="text" name="telephone" id="tel" value ="${empty requestScope.telephone ? sessionScope.user.telephone : requestScope.telephone}">
	<!-- 			</div>
				
				<div class="form-group"> -->
					<label>Rue :</label>
					<input type="text" name="rue" id="rue" value ="${empty requestScope.rue ? sessionScope.user.rue : requestScope.rue}" required="required">
				</div>
				
				<div class="form-group">
					<label>Code postal :</label>
					<input type="text" name="codePostal" id="cp" value ="${empty requestScope.codePostal ? sessionScope.user.codePostal : requestScope.codePostal}" required="required">
	<!-- 			</div>
				
				<div class="form-group"> -->
					<label>Ville :</label>
					<input type="text" name="ville" id="ville" value ="${empty requestScope.ville ? sessionScope.user.ville : requestScope.ville}" required="required">
				</div>
				
				<div class="form-group">
					<label>Mot de passe :</label>
					<input type="password" name="mdp1" id="password1" placeholder="Entrez votre mot de passe" autocomplete="off" >
	<!-- 			</div>
				
				<div class="form-group"> -->
					<label>Confimation :</label>
					<input type="password" name="mdp2" id="password2" placeholder="Entrez votre mot de passe" autocomplete="off">
				</div>
				
				<button type="submit">Enregistrer</button>
			</div>	
		</form>
		<a href="<%=request.getContextPath()%>/utilisateur/delete"><button>Supprimer le profil</button></a>
	</main>
		<!-- fragment JSP footer -->
  	<jsp:include page="/WEB-INF/fragment/footer.jsp"></jsp:include>	
</body>
</html>