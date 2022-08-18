<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    
<title>Profil Utilisateur</title>
</head>
<body>
	<header>
	    <!-- fragment JSP navigation -->
	    <jsp:include page="/WEB-INF/fragment/nav.jsp"></jsp:include>
	</header>
	    <!--main bloc-->
<main>
<h1>Mon Profil</h1>

	<form action="#Update" method="post">
		<div class="Container">
			<div class="label-form">
				<label for="pseudo">Pseudo :</label>
				<label for="prenom">Prénom :</label>
				<label for="tel">Téléphone :</label>
				<label for="codePostal">Code Postal :</label>
				<label for="mdpactuel">Mot de passe actuel :</label>
				<label for="newmdp">Nouveau Mot de passe :</label>
				<label>Crédit :</label>
			</div class="input-form">
				<div class="input">
				<input type="text">
				<input type="text">
				<input type="tel">
				<input type="text">
				<input type="password">
				<input type="password">
			</div>
			<div class="label-form">
				<label for="nom">Nom :</label>
				<label for="email">Email :</label>
				<label for="rue">Rue :</label>
				<label for="ville">Ville :</label>
				<label for="mdpconfirm">Confirmation Mot de passe :</label>
			</div>
			<div class="input-form">
				<input type="text">
				<input type="email">
				<input type="text">
				<input type="text">			
				<input type="password">
			</div>
		</div>	
		<button type="submit">Enregistrer</button>
	</form>
	<a href="<%=request.getContextPath()%>/enchere/delete"><button>Supprimer</button></a>
</main>
</body>
</html>