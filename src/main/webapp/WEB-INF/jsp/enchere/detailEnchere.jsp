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

<title>Détail enchère</title>
</head>
<body>

<jsp:include page="/WEB-INF/fragment/header.jsp"></jsp:include>
	<main>
		<h2>Détail vente</h2>
		<form action="<%=request.getContextPath()%>/article/encherir" method="post">
			<ul class = "row list-group-flush">
							
				<li class = "col-12 text-center list-group-item" >${article.getNom()}</li>
		
			
				<li class = "col-6 text-right list-group-item" >Description :</li>
				<li class = "col-6 text-left list-group-item"> ${article.getDescription()}</li>
		
				<li class = "col-6 text-right list-group-item" >Catégorie :</li>
				<li class = "col-6 text-left list-group-item">${article.getCategorie().getLibelle()}</li>
		
				<li class = "col-6 text-right list-group-item" >Meilleure offre :</li>
				<li class = "col-6 text-left list-group-item"> ${article.getEnchere().getMontantEnchere()} par </li>
		
				<li class = "col-6 text-right list-group-item" >Mise à prix :</li>
				<li class = "col-6 text-left list-group-item"> ${article.getMiseAprix()}</li>
		
				<li class = "col-6 text-right list-group-item" >Fin de l'enchère :</li>
				<li class = "col-6 text-left list-group-item">${article.getDateFinEncheres()}</li>
		
				<li class = "col-6 text-right list-group-item" >Retrait :</li>
				<li class = "col-6 text-left list-group-item">${article.getUtilisateur().getRue()}</li>
				<li class = "col-12 text-center list-group-item"> ${article.getUtilisateur().getCodePostal()} ${article.getUtilisateur().getVille()}</li>
		
				<li class = "col-6 text-right list-group-item" >Vendeur :</li>
				<li class = "col-6 text-left list-group-item"><a href="#">${article.getUtilisateur().getPseudo()}</a></li>
			
				<li class = "col-6 text-right list-group-item" >Ma prosposition</li>
				<li class = "col-6 text-left list-group-item"><input type ="number" width="3em" min="" name="montantEnchere"></li>
				<li class = "col-12 text-center list-group-item"><button type="submit">Enregistrer</button>
			</ul>
		</form>
		
	</main>	
	<jsp:include page="/WEB-INF/fragment/footer.jsp"></jsp:include>  
</body>
</html>