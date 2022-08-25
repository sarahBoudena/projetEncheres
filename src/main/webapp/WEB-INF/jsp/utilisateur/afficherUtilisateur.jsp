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
<title>Utilisateur</title>
</head>
<body >
		<!-- fragment JSP navigation -->
	<jsp:include page="/WEB-INF/fragment/header.jsp"></jsp:include>
	<main>
		<c:if test="${requestScope.mine == 'true'}">
			<h1 class ="text-center border-0" > MON PROFIL</h1>
		</c:if>
		<c:if test="${requestScope.mine != 'true'}">
			<h1 class ="text-center "> Profil de : ${requestScope.pseudo} </h1>
		</c:if>
		
		<div >
				<ul class = "row list-group-flush">
					<li class = "col-12 text-center list-group-item border-0" ></li>
					<c:if test="${requestScope.mine == 'true'}">
						<li class = "col-6 text-right list-group-item border-0" >Pseudo :</li>
						<li class = "col-6 text-left list-group-item border-0"> ${requestScope.pseudo}</li>
					</c:if>
					<li class = "col-6 text-right list-group-item border-0" >Nom :</li>
					<li class = "col-6 text-left list-group-item border-0"> ${requestScope.nom}</li>
				
					<li class = "col-6 text-right list-group-item border-0" >Prénom :</li>
					<li class = "col-6 text-left list-group-item border-0" > ${requestScope.prenom}</li>
				
					<li class = "col-6 text-right list-group-item border-0" >Email :</li>
					<li class = "col-6 text-left list-group-item border-0"> ${requestScope.email}</li>
				
					<li class = "col-6 text-right list-group-item border-0" >Téléphone :</li>
					<li class = "col-6 text-left list-group-item border-0"> ${requestScope.telephone}</li>
				
					<li class = "col-6 text-right list-group-item border-0" >Rue :</li>
					<li class = "col-6 text-left list-group-item border-0"> ${requestScope.rue}</li>
				
					<li class = "col-6 text-right list-group-item border-0" >Code postal :</li>
					<li class = "col-6 text-left list-group-item border-0"> ${requestScope.codePostal}</li>
				
					<li class = "col-6 text-right list-group-item border-0" >ville :</li>
					<li class = "col-6 text-left list-group-item border-0"> ${requestScope.ville}</li>
					
					<li class = "col-12 text-center list-group-item border-0" ></li>
				</ul>
		</div>
		<c:if test="${requestScope.mine == 'true'}">
			<div class="text-center">
			<a href="<%=request.getContextPath()%>/utilisateur/update" ><button>Modifier ou supprimer mon profil</button></a>
			</div>
		</c:if>
	</main>		
		<!-- fragment JSP footer -->
  	<jsp:include page="/WEB-INF/fragment/footer.jsp"></jsp:include>	
</body>
</html>