<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connection</title>
</head>
<body>
	<h1>ENI-Enchères</h1>

	<form method="post" action="<%=request.getContextPath()%>/accueil/login">
		<div class="form-group"> 
	        <label>identifiant : </label> 
	       <input type="text" name="username" value ="${cookie.identite.value != null ? cookie.identite.value : ''}"/>
        </div>
        <div class="form-group"> 
	        <label>mot de passe : </label> 
	        <input type="password" name="password"/>  
        </div>
			<button type="submit" > Connexion </button>
			<input type="checkbox" name="memoriser" ${cookie.identite.value != null ? "checked" : ""} >
			<label for="memoriser">Se souvenir de moi</label>
	</form>

</body>
</html>