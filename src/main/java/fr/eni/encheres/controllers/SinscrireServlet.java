package fr.eni.encheres.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.utilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class SinscrireServlet
 */
@WebServlet("/utilisateur/inscription")
public class SinscrireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SinscrireServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/utilisateur/inscription.jsp");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Réinitialisation des erreurs
		request.setAttribute("error", null);
		request.setAttribute("erreur", null);		
				
		//Récupération des données du formulaire
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String cp = request.getParameter("codepostal");
		String ville = request.getParameter("ville");
		String mdp1 = request.getParameter("mdp1");
		String mdp2 = request.getParameter("mdp2");
		String message = "";
		Utilisateur user = null;
		RequestDispatcher rd;
		
		//Stockage en paramètre des données saisies
		request.setAttribute("pseudo", pseudo);
		request.setAttribute("nom", nom);
		request.setAttribute("prenom", prenom);
		request.setAttribute("email", email);
		request.setAttribute("tel", telephone);
		request.setAttribute("rue", rue);
		request.setAttribute("cp", cp);
		request.setAttribute("ville", ville);
		
		try {
			//Vérification du mdp + création de l'objet Utilisateur
			if (mdp1.equals(mdp2)) {
				user = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, cp, ville, mdp1, 100, false);
				//Utilisation du manager		
				utilisateurManager mng = utilisateurManager.getInstance();
				mng.insert(user);
				rd = request.getRequestDispatcher("/WEB-INF/jsp/accueil.jsp");
				rd.forward(request, response);
			}else {
				message = "Les deux mots de passe sont différents.";
				request.setAttribute("erreur", message);
				doGet(request, response);
			}	
		}catch (BLLException e) {
			request.setAttribute("error", e);
			rd = request.getRequestDispatcher("/WEB-INF/jsp/utilisateur/inscription.jsp");
		    rd.forward(request, response);
		}
	}

}
