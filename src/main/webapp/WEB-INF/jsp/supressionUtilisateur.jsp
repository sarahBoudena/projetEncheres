<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Supprimer mon compte</title>
</head>
<body>
	<h2>Etes-vous sûr de vouloir supprimer votre compte ?</h2>
	
	<form action="<%=request.getContextPath()%>/enchere/delete>" method="post">
		<button type="submit">Oui</button>
		<button type="reset" href="<%=request.getContextPath()%>/enchere/accueil">Non</button>
	</form>
</body>
</html>