<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<header>
		<nav class="pr-5 navbar navbar-expand-sm bg-dark navbar-dark align-top justify-content-between">
	    <!-- Brand/logo -->
	    <a class="navbar-brand" href="<%=request.getContextPath()%>/accueil">
	        <img class="small-icon w-25" src="<%=request.getContextPath()%>/medias/img/logo-eni.png" alt="Accueil ENI-Encheres">
	        <strong>ENI-Encheres</strong>
	    </a>
	
	    <a class="navbar-brand" href="#" alt="Gérer mon profil" title="Gérer mon profil">
	        <img class="small-icon" src="images/user.svg">
	        <span class="align-middle text-muted">${pseudo}, 0 crédit(s)</span>
	    </a>
		
	    <ul class="navbar-nav ml-auto">
	        <!-- Dropdown for small screen -->
	        <li class="nav-item dropdown d-lg-none">
	            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
	                <img class="small-icon w-25" src="<%=request.getContextPath()%>/medias/img/menu.png" alt="Menu ENI-Encheres">
	            </a>
	            <div class="dropdown-menu">
					<c:if test="${!empty user}">	<!-- boutons à afficher si utilisateur connecté -->
					    <c:if test="${user.administrateur}">
					    	<a class="dropdown-item" href="#" alt="Administrer le site">Administrer</a> 
		                </c:if>
		                <a class="dropdown-item" href="#" alt="Vendre un article">Vendre un article</a>
					    <a class="dropdown-item" href="<%=request.getContextPath()%>/utilisateur/login?deco=true" alt="Me déconnecter">Me déconnecter</a>
		                <a class="dropdown-item" href="<%=request.getContextPath()%>/utilisateur/profil" alt="Profil utilisateur">Mon Profil</a>
	                </c:if>
				    <c:if test="${empty user}">		<!-- boutons à afficher si aucun utilisateur connecté-->
		                <a class="dropdown-item" href="<%=request.getContextPath()%>/utilisateur/inscription" alt="S'inscrire à ENI-Encheres">M'inscrire</a>
		                <a class="dropdown-item" href="<%=request.getContextPath()%>/utilisateur/login?deco=false" alt="Se connecter à ENI-Encheres">Me connecter</a>
				    </c:if>            
	            </div>
	        </li>   
	        <!-- Links for medium screen-->
	        <c:if test="${!empty user}">
		        <c:if test="${user.administrateur}">
			        <li class="nav-item d-none d-lg-block">
			            <a class="nav-link" href="#" alt="Administrer le site">Administrer</a>
			        </li> 
		        </c:if>
		        <li class="nav-item d-none d-lg-block">
		            <a class="nav-link" href="#" alt="Vendre un article">Vendre un article</a>
		        </li>
	            <li class="nav-item d-none d-lg-block">
	               <a class="nav-link" href="<%=request.getContextPath()%>/utilisateur/profil" alt="Profil utilisateur">Mon profil</a>
	            </li>
		        <li class="nav-item d-none d-lg-block">
		            <a class="nav-link" href="<%=request.getContextPath()%>/utilisateur/login?deco=true" alt="Me déconnecter">Me déconnecter</a>
		        </li>
	        </c:if>
	        <c:if test="${empty user}">	
		        <li class="nav-item d-none d-lg-block">
		            <a class="nav-link" href="<%=request.getContextPath()%>/utilisateur/inscription" alt="S'inscrire à ENI-Encheres">M'inscrire</a>
		        </li>
		        <li class="nav-item d-none d-lg-block">
		            <a class="nav-link" href="<%=request.getContextPath()%>/utilisateur/login?deco=false" alt="Se connecter à ENI-Encheres">Me connecter</a>
	        	</li>	
	        </c:if>      
	    </ul>
	</nav>
</header>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

