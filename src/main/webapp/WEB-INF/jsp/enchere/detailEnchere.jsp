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

<title>Insert title here</title>
</head>
<body>

<jsp:include page="/WEB-INF/fragment/header.jsp"></jsp:include>

	<h2>Détail vente</h2>
		<div>
		<ul class = "row list-group-flush">
							
			<li class = "col-12 text-center list-group-item" >Nom article</li>
		
			
			<li class = "col-6 text-right list-group-item" >Description :</li>
			<li class = "col-6 text-left list-group-item"> ${requestScope.description}</li>
		
			<li class = "col-6 text-right list-group-item" >Catégorie :</li>
			<li class = "col-6 text-left list-group-item"> Libelle categorie</li>
		
			<li class = "col-6 text-right list-group-item" >Meilleure offre :</li>
			<li class = "col-6 text-left list-group-item"> Meilleure offre et nom de l'utilisateur</li>
		
			<li class = "col-6 text-right list-group-item" >Mise à prix :</li>
			<li class = "col-6 text-left list-group-item"> ${requestScope.miseAPrix}</li>
		
			<li class = "col-6 text-right list-group-item" >Fin de l'enchère :</li>
			<li class = "col-6 text-left list-group-item">${requestScope.dateFinEnchere}</li>
		
			<li class = "col-6 text-right list-group-item" >Retrait :</li>
			<li class = "col-6 text-left list-group-item"> ${requestScope.Utilisateur.getRue()}</li>
			<li class = "col-6 text-left list-group-item"> ${requestScope.Utilisateur.getCodePostal() requestScope.Utilisateur.getVille()}</li>
		
			<li class = "col-6 text-right list-group-item" >Vendeur :</li>
			<li class = "col-6 text-left list-group-item"><a href="#">${requestScope.Utilisateur.getPseudo()}</a></li>
		</ul>
		</div>
	
	
	
	
	
</body>
</html>