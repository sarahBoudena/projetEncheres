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
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/venteArticle.css">

<title>Vendre Article</title>
</head>
<body>

<jsp:include page="/WEB-INF/fragment/header.jsp"></jsp:include>
<main>
<h2 style="text-align:center">VENDRE UN ARTICLE</h2>

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

	<form action="<%=request.getContextPath()%>/article/vente" method="post" >
		
			<ul class = "row list-group-flush" >
				
					<li class = "col-6 text-right list-group-item border-0" >Article :</li>
					<li class = "col-6 text-left list-group-item border-0" ><input type="text" name="nom" value="${requestScope.nom}" id="name" placeholder="Nom de l'article"  required="required"></li>
				
					<li class = "col-6 text-right list-group-item border-0" >Description :</li>
					<li class = "col-6 text-left list-group-item border-0" ><textarea rows="5" cols="40" name="description" id="description" required="required" placeholder="Description de l'article mis en vente...">${requestScope.description}</textarea></li>
				
				
					<li class = "col-6 text-right list-group-item border-0" >Categorie :</li>
					<li class = "col-6 text-left list-group-item border-0" ><select name="categorie" required="required">
						<option value="" disabled selected>-- Catégorie --</option>
						<option value="Informatique">Informatique</option>
						<option value="Ameublement">Ameublement</option>
						<option value="Vêtement">Vêtement</option>
						<option value="Sport & Loisir">Sport & Loisir</option>
					</select></li>
				
					<li class = "col-6 text-right list-group-item border-0" >Mise à prix :</li>
					<li class = "col-6 text-left list-group-item border-0" ><input type="number" min="0" name="PrixInitial" value="${requestScope.PrixInitial}"></li>
				
					<li class = "col-6 text-right list-group-item border-0">Début de l'enchère</li>
					<li class = "col-6 text-left list-group-item border-0"><input type="datetime-local" name="dateDebut" required="required"></li>
				
					<li class = "col-6 text-right list-group-item border-0">Fin de l'enchère</li>
					<li class = "col-6 text-left list-group-item border-0"><input type="datetime-local" name="dateFin" required="required"></li>
				
					<li class = "col-12 text-center list-group-item border-0" style="font-weight:bold">Retrait</li>
					
					<li class = "col-6 text-right list-group-item border-0">Rue</li>
					<li class = "col-6 text-left list-group-item border-0"><input type="text" value="${user.rue}"></li>
						
					<li class = "col-6 text-right list-group-item border-0">Code Postal</li>
					<li class = "col-6 text-left list-group-item border-0"><input type="text" value="${user.codePostal}"></li>
						
					<li class = "col-6 text-right list-group-item border-0">Ville</li>
					<li class = "col-6 text-left list-group-item border-0"><input type="text" value="${user.ville}"></li>
						
					<li class = "col-6 text-right list-group-item border-0"><button type ="submit">Enregistrer</button></li>
					<li class = "col-6 text-left list-group-item border-0" style="list-style: none"><a href="<%=request.getContextPath()%>/accueil" class="accueil">Annuler</a></li>
		</ul>
	</form>
		
					
			
			
		
</main>
	<jsp:include page="/WEB-INF/fragment/footer.jsp"></jsp:include>   
</body>
</html>