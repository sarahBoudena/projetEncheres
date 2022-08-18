
<body>
	<header>
        <nav class="pr-5 navbar navbar-expand-sm bg-dark navbar-dark align-top justify-content-between">
            <!-- Brand/logo -->
            <a class="navbar-brand" href="index.html">
                <img class="small-icon" src="images/trocenchere.svg" alt="Accueil ENI-Encheres">
                <strong>ENI-Encheres</strong>
            </a>

            <a class="navbar-brand" href="#" alt="Gérer mon profil" title="Gérer mon profil">
                <img class="small-icon" src="images/user.svg">
                <span class="align-middle text-muted">XXXXX xxx, 0 crédit(s)</span>
            </a>

            <ul class="navbar-nav ml-auto">
                <!-- Dropdown for small screen -->
                <li class="nav-item dropdown d-lg-none">
                    <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                        <img class="small-icon" src="images/menu.svg" alt="Menu ENI-Encheres">
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="#" alt="Administrer le site">Administrer</a> 
                        <a class="dropdown-item" href="#" alt="Vendre un article">Vendre un article</a>
                        <a class="dropdown-item" href="#" alt="Me déconnecter">Me déconnecter</a>
                        <a class="dropdown-item" href="register.html" alt="S'inscrire à ENI-Encheres">M'inscrire</a>
                        <a class="dropdown-item" href="login.html" alt="Se connecter à ENI-Encheres">Me connecter</a>
                    </div>
                </li>   
                <!-- Links for medium screen-->
                <li class="nav-item d-none d-lg-block">
                    <a class="nav-link" href="#" alt="Administrer le site">Administrer</a>
                </li> 
                <li class="nav-item d-none d-lg-block">
                    <a class="nav-link" href="#" alt="Vendre un article">Vendre un article</a>
                </li>
                <li class="nav-item d-none d-lg-block">
                    <a class="nav-link" href="<%=request.getContextPath()%>/enchere/login?deco=true" alt="Me déconnecter">Me déconnecter</a>
                </li>
                <li class="nav-item d-none d-lg-block">
                    <a class="nav-link" href="register.html" alt="S'inscrire à ENI-Encheres">M'inscrire</a>
                </li>
                <li class="nav-item d-none d-lg-block">
                    <a class="nav-link" href="<%=request.getContextPath()%>/enchere/login?deco=false" alt="Se connecter à ENI-Encheres">Me connecter</a>
                </li>
            </ul>
        </nav>
    </header>
</body>
</html>