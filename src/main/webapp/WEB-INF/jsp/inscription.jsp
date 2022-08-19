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
<body>
	<!--Header-->
	<jsp:include page="/WEB-INF/fragment/header.jsp"></jsp:include>
	<h1>Mon profil</h1>
	<form action="/enchere/inscription" method="post">
		<div class="Container">
			<div class="label-form">
			<label>Pseudo :</label>
			<input type="text" name="pseudo" id="pseudo" placeholder="pseudo">
			
			<label>Nom :</label>
			<input type="text" name="nom" id="name" placeholder="NOM">
			
			<label>Prénom :</label>
			<input type="text" name="prenom" id="firstname" placeholder="Prénom">
			
			<label>Email :</label>
			<input type="email" name="email" id="email" placeholder="exemple@email.fr">
			
			<label>Téléphone :</label>
			<input type="text" name="telephone" id="tel" placeholder="0123456789">
			
			<label>Rue :</label>
			<input type="text" name="rue" id="rue" placeholder="rue de la Paix">
			
			<label>Code postal :</label>
			<input type="text" name="codepostal" id="cp" placeholder="44000">
			
			<label>Ville :</label>
			<input type="text" name="ville" id="ville" placeholder="Nantes">
			
			<label>Mot de passe :</label>
			<input type="password" name="mdp1" id="password1" placeholder="Entrez votre mot de passe">
			
			<label>Confimation :</label>
			<input type="password" name="mdp2" id="password2" placeholder="Entrez de nouveau votre mot de passe">
			<button type="submit">Créer</button>
		</form>
	
	<a href="/enchere/accueil">
		<button>Annuler</button>
	</a>

</body>
</html>