<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
 <link rel="stylesheet" href="./css/inscription.css">   
<title>Enchères - Inscription</title>
</head>
<body>
	<!--Header-->
	<jsp:include page="/WEB-INF/fragment/header.jsp"></jsp:include>
	<h1>Mon profil</h1>
		
		<!-- Erreurs -->
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
	<form action="<%=request.getContextPath()%>/enchere/inscription" method="post">
		<div class="Container">
			<div class="form-group">
				<label>Pseudo :</label>
				<input type="text" name="pseudo" id="pseudo" placeholder="pseudo" required="required">
<!-- 			</div>
			
			<div class="form-group"> -->
				<label>Nom :</label>
				<input type="text" name="nom" id="name" placeholder="NOM" required="required">
			</div>
			
			<div class="form-group">
				<label>Prénom :</label>
				<input type="text" name="prenom" id="firstname" placeholder="Prénom" required="required">
<!-- 			</div>
			
			<div class="form-group"> -->
				<label>Email :</label>
				<input type="email" name="email" id="email" placeholder="exemple@email.fr" required="required">
			</div>
			
			<div class="form-group">
				<label>Téléphone :</label>
				<input type="text" name="telephone" id="tel" placeholder="0123456789">
<!-- 			</div>
			
			<div class="form-group"> -->
				<label>Rue :</label>
				<input type="text" name="rue" id="rue" placeholder="rue de la Paix" required="required">
			</div>
			
			<div class="form-group">
				<label>Code postal :</label>
				<input type="text" name="codepostal" id="cp" placeholder="44000" required="required">
<!-- 			</div>
			
			<div class="form-group"> -->
				<label>Ville :</label>
				<input type="text" name="ville" id="ville" placeholder="Nantes" required="required">
			</div>
			
			<div class="form-group">
				<label>Mot de passe :</label>
				<input type="password" name="mdp1" id="password1" placeholder="Entrez votre mot de passe" required="required">
<!-- 			</div>
			
			<div class="form-group"> -->
				<label>Confimation :</label>
				<input type="password" name="mdp2" id="password2" placeholder="Entrez votre mot de passe" required="required">
			</div>
			
			<button type="submit">Créer</button>
		</div>	
	</form>
	
	<a href="/enchere/accueil">
		<button>Annuler</button>
	</a>

	<!-- fragment JSP footer -->
   <jsp:include page="/WEB-INF/fragment/footer.jsp"></jsp:include>    
</body>
</html>