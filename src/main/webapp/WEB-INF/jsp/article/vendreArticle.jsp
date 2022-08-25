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
		
			<ul class = "row list-group-flush">
				
					<li class = "col-6 text-right list-group-item" >Article :</li>
					<li class = "col-6 text-left list-group-item" ><input type="text" name="nom" value="${requestScope.nom}" id="name" placeholder="Nom de l'article"  required="required"></li>
				
					<li class = "col-6 text-right list-group-item" >Description :</li>
					<li class = "col-6 text-left list-group-item" ><textarea rows="5" cols="40" name="description" id="description" required="required" placeholder="Description de l'article mis en vente...">${requestScope.description}</textarea></li>
				
				
					<li class = "col-6 text-right list-group-item" >Categorie :</li>
					<li class = "col-6 text-left list-group-item" ><select name="categorie" required="required">
						<option value="" disabled selected>-- Catégorie --</option>
						<option value="Informatique">Informatique</option>
						<option value="Ameublement">Ameublement</option>
						<option value="Vêtement">Vêtement</option>
						<option value="Sport & Loisir">Sport & Loisir</option>
					</select></li>
				
					<li class = "col-6 text-right list-group-item" >Mise à prix :</li>
					<li class = "col-6 text-left list-group-item" ><input type="number" min="0" name="PrixInitial" value="${requestScope.PrixInitial}"></li>
				
					<li class = "col-6 text-right list-group-item">Début de l'enchère</li>
					<li class = "col-6 text-left list-group-item"><input type="datetime-local" name="dateDebut" required="required"></li>
				
					<li class = "col-6 text-right list-group-item">Fin de l'enchère</li>
					<li class = "col-6 text-left list-group-item"><input type="datetime-local" name="dateFin" required="required"></li>
				
					<li class = "col-12 text-center list-group-item" style="font-weight:bold">Retrait</li>
					
					<li class = "col-6 text-right list-group-item">Rue</li>
					<li class = "col-6 text-left list-group-item"><input type="text" value="${user.rue}"></li>
						
					<li class = "col-6 text-right list-group-item">Code Postal</li>
					<li class = "col-6 text-left list-group-item"><input type="text" value="${user.codePostal}"></li>
						
					<li class = "col-6 text-right list-group-item">Ville</li>
					<li class = "col-6 text-left list-group-item"><input type="text" value="${user.ville}"></li>
						
					<li class = "col-6 text-right list-group-item"><button type ="submit">Enregistrer</button></li>
					
					
					<li class = "col-6 text-left list-group-item"><a href="<%=request.getContextPath()%>/accueil"><button type="reset">Annuler</button></a></li>
	</form>
		</ul>
			
			
		
</main>
	<jsp:include page="/WEB-INF/fragment/footer.jsp"></jsp:include>   
</body>
</html>