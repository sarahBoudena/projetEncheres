<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connection</title>
</head>
<body>
	<h1>ENI-Enchères</h1>

	<form action=""<%=request.getContextPath()%>/accueil/login">
		<div class="form-group"> 
	        <label>identifiant : </label> 
	       <input type="text" name="username"/>
        </div>
        <div class="form-group"> 
	        <label>mot de passe : </label> 
	        <input type="password" name="password"/>  
        </div>
			<button type="submit" > Connexion </button>
			<input type="checkbox" id="memoriser" name="memoriser">
			<label for="memoriser">Se souvenir de moi</label>
	</form>

</body>
</html>