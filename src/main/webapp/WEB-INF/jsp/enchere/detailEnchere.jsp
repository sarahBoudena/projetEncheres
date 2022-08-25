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
		<h2 style="text-align:center">Détail vente</h2>
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
		<c:if test="${erreur != null}">
			<div class="d-flex alert-danger">
			    <div class="col-3 p-2">
			        <img class="small-icon" src="<%=request.getContextPath()%>/medias/img/erreur.png" alt ="icone erreur" >
			    </div>
			    <ul class="col-9 list-unstyled p-2">
			       <li>${erreur.message}</li>
				</ul>
		    </div>
		</c:if>
		
		<form action="<%=request.getContextPath()%>/article/encherir" method="post">
			<ul class = "row list-group-flush ">
							
				<li class = "col-12 text-center list-group-item" style="font-weight:bold">${article.getNom()}</li>
		
			
				<li class = "col-6 text-right list-group-item border-0" >Description :</li>
				<li class = "col-6 text-left list-group-item border-0"> ${article.getDescription()}</li>
		
				<li class = "col-6 text-right list-group-item border-0" >Catégorie :</li>
				<li class = "col-6 text-left list-group-item border-0">${article.getCategorie().getLibelle()}</li>
		
				<li class = "col-6 text-right list-group-item border-0" >Meilleure offre :</li>
				<li class = "col-6 text-left list-group-item border-0">${article.enchere.montantEnchere == null ?"" : article.enchere.montantEnchere} ${article.enchere.montantEnchere != null ? "par " : ""} ${article.enchere.montantEnchere != null ? meilleureOffrePseudo : " - "}</li>
		
				<li class = "col-6 text-right list-group-item border-0" >Mise à prix :</li>
				<li class = "col-6 text-left list-group-item border-0">${article.getPrixInitial()}</li>
		
				<li class = "col-6 text-right list-group-item border-0" >Fin de l'enchère :</li>
				<li class = "col-6 text-left list-group-item border-0">${dateFinEnchere}</li>
		
				<li class = "col-12 text-center list-group-item border-0" style="font-weight:bold" >Retrait :</li>
				<li class = "col-12 text-center list-group-item border-0">${article.getUtilisateur().getRue()}</li>
				<li class = "col-12 text-center list-group-item border-0">${article.getUtilisateur().getCodePostal()} ${article.getUtilisateur().getVille()}</li>
		
				<li class = "col-6 text-right list-group-item border-0" >Vendeur :</li>
				<li class = "col-6 text-left list-group-item border-0"><a href="<%=request.getContextPath()%>/utilisateur/afficherProfil?mine=${article.noUtilisateur}">${article.getUtilisateur().getPseudo()}</a></li>
				<li class = "col-6 text-right list-group-item border-0" >Ma prosposition</li>
				
				<li class = "col-6 text-left list-group-item border-0"><input type ="number" width="3em" value="${article.enchere.montantEnchere != null ? article.enchere.montantEnchere+1 : 0}" min="${article.enchere.montantEnchere != null ? article.enchere.montantEnchere+1 : 0}" name="montantEnchere" required="required"></li>
				<li class = "col-12 text-center list-group-item border-0"><button type="submit">Enregistrer</button>
				<input class = "invisible noArticle col-12" type = number value = "${article.noArticle}" name="noArticle"> 
		</ul>
		</form>
		
	</main>	
	<jsp:include page="/WEB-INF/fragment/footer.jsp"></jsp:include>  
</body>
</html>