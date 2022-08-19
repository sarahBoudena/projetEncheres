<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
 <link rel="stylesheet" href="../css/inscription.css">  


<title>Profil Utilisateur</title>
</head>
<body>
	<header>
		<!-- fragment JSP navigation -->
		<jsp:include page="/WEB-INF/fragment/header.jsp"></jsp:include>
	</header>
	<!--main bloc-->
	<main>
		<h1>Mon profil</h1>
	<form action="/enchere/profil" method="post">
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
			
			<button type="submit">Enregistrer</button>
		</div>	
	</form>
			
		</form>
		<a href="<%=request.getContextPath()%>/enchere/delete"><button>Supprimer le profil</button></a>
	</main>
</body>
</html>