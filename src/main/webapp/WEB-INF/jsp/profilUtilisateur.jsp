<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profil Utilisateur</title>
</head>
<body>
<h1>Mon Profil</h1>

	<form action="#Update" method="post">
		<div class="Container">
			<div class="label">
				<label for="pseudo">Pseudo :</label>
				<label for="prenom">Prénom :</label>
				<label for="tel">Téléphone :</label>
				<label for="codePostal">Code Postal :</label>
				<label for="mdpactuel">Mot de passe actuel :</label>
				<label for="newmdp">Nouveau Mot de passe :</label>
					<label>Crédit :</label>
			</div>
				<div class="input">
				<input type="text">
				<input type="text">
				<input type="tel">
				<input type="text">
				<input type="password">
				<input type="password">
			</div>
		
			
			<label for="nom">Nom :</label>
			<input type="text">
			<label for="email">Email :</label>
			<input type="email">
			<label for="rue">Rue :</label>
			<input type="text">
			<label for="ville">Ville :</label>
			<input type="text">
			<label for="mdpconfirm">Confirmation Mot de passe :</label>
			<input type="password">
		</div>	
		<button type="submit">Enregistrer</button>
	</form>
	<a href="<%=request.getContextPath()%>/enchere/delete"><button>Supprimer</button></a>

</body>
</html>