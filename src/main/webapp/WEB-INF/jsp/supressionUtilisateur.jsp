<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Supprimer mon compte</title>
</head>
<body>
	<h2>Etes-vous sûr de vouloir supprimer votre compte ?</h2>
	
	<c:if test="${erreur != null}">
		<c:forEach var="element" items="${erreur.getBLLExceptions()}">
				<li>${element.getMessage()}</li>
		</c:forEach>	
	</c:if>
	
	<form action="<%=request.getContextPath()%>/enchere/delete>" method="post">
		<button type="submit">Oui</button>
	</form>
	
	<a href="<%=request.getContextPath()%>/enchere/accueil"><button>Non</button></a>

</body>
</html>