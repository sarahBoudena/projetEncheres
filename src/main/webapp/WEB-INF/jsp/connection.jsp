<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    
<meta charset="UTF-8">
<title>Connection</title>
</head>
<body>
	<div class="container-fluid">
		 <!-- fragment JSP header -->
	    <jsp:include page="/WEB-INF/fragment/header.jsp"></jsp:include>
		
		<h1>ENI-Enchères</h1>
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
		<form method="post" action="<%=request.getContextPath()%>/enchere/login">
			<div class="form-group"> 
		        <label>identifiant : </label> 
		       <input type="text" name="email" value ="${cookie.identite.value != null ? cookie.identite.value : ''}"/>
	        </div>
	        <div class="form-group"> 
		        <label>mot de passe : </label> 
		        <input type="password" name="password"/>  
	        </div>
				<button type="submit" > Connexion </button>
				<input type="checkbox" name="memoriser" ${cookie.identite.value != null ? "checked" : ""} >
				<label for="memoriser">Se souvenir de moi</label>
		</form>
	</div>
	<!-- fragment JSP footer -->
   <jsp:include page="/WEB-INF/fragment/footer.jsp"></jsp:include>      
</body>
</html>