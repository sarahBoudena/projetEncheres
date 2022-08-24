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
<h2>Vendre un article</h2>

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

	<form action="<%=request.getContextPath()%>/article/vente" method="post">
		<div class="Container">
			<div>
				<label>Article :</label>
				<input type="text" name="nom" value="${requestScope.nom}" id="name" placeholder="Nom de l'article"  required="required">
			</div>	
			<div>
				<label>Description :</label>
				<textarea rows="5" cols="40" name="description" id="description" required="required" placeholder="Description de l'article mis en vente...">${requestScope.description}</textarea>
			</div>
			<div>
				<label>Catégorie :</label>
				<select name="categorie" required="required">
					<option value="" disabled selected>-- Catégorie --</option>
					<option value="Informatique">Informatique</option>
					<option value="Ameublement">Ameublement</option>
					<option value="Vêtement">Vêtement</option>
					<option value="Sport & Loisir">Sport & Loisir</option>
				</select>
			</div>
			<div>
				<label>Mise à prix :</label>
				<input type="number" min="0" name="PrixInitial" value="${requestScope.PrixInitial}">
			</div>
			<div>
				<label>Début de l'enchère :</label>
				<input type="datetime-local" name="dateDebut" required="required">
			</div>	
			<div>
				<label>Fin de l'enchère :</label>
				<input type="datetime-local" name="dateFin" required="required">
			</div>	
			<fieldset>
				<legend>Retrait</legend>
					<div>
					<label>Rue :</label>
					<input type="text" value="${user.rue}">
					</div>
					<div>
					<label>Code Postal :</label>
					<input type="text" value="${user.codePostal}">
					</div>
					<div>
					<label>Ville :</label>
					<input type="text" value="${user.ville}">
					</div>
			</fieldset>
			<div>
				<button type ="submit">Enregistrer</button>
			</div>
		</div>
	</form>
		<div>
			<a href="<%=request.getContextPath()%>/accueil">
				<button>Annuler</button>
			</a>
		</div>
</main>
	<jsp:include page="/WEB-INF/fragment/footer.jsp"></jsp:include>   
</body>
</html>