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
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/supprimerProfil.css"> 


<title>Supprimer mon compte</title>
</head>
<body>


	<!-- fragment JSP navigation -->
	<jsp:include page="/WEB-INF/fragment/header.jsp"></jsp:include>

	<main>
		
		<h2>Etes-vous sûr de vouloir supprimer votre compte ?</h2>
		
		<c:if test="${erreur != null}">
			<c:forEach var="element" items="${erreur.getBLLExceptions()}">
					<li>${element.getMessage()}</li>
			</c:forEach>	
		</c:if>
		<div class="bouttons">
			<form action="<%=request.getContextPath()%>/utilisateur/delete" method="post">
			<button type="submit">Oui</button>
			</form>
			<a href="<%=request.getContextPath()%>/accueil"><button>Non</button></a>
		</div>
	
	</main>
	<!-- fragment JSP footer -->
  	<jsp:include page="/WEB-INF/fragment/footer.jsp"></jsp:include>	
</body>
</html>