package fr.eni.encheres.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.utilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/utilisateur/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		utilisateurManager manager = utilisateurManager.getInstance();
		HttpSession session = request.getSession();
		Utilisateur oldUser = session.getAttribute("user")!=null ? (Utilisateur) session.getAttribute("user"):null;
		Utilisateur newUser = null;
		List<String> listeModificationOk = new ArrayList<String>();
		String pseudo = null;
		String nom =null;
		String prenom = null;
		String email = null;
		String telephone = null;
		String rue = null;
		String codePostal = null;
		String ville = null;
		String message = null;
		
		if(request.getParameter("pseudo")!=null) {
		pseudo = request.getParameter("pseudo");
		request.setAttribute("pseudo", pseudo);
		}
		if(request.getParameter("nom")!=null) {
			nom = request.getParameter("nom");
			request.setAttribute("nom", nom);
		}
		if(request.getParameter("prenom")!=null) {
			prenom = request.getParameter("prenom");
			request.setAttribute("prenom", prenom);
		}
		if(request.getParameter("email")!=null) {
			email = request.getParameter("email");
			request.setAttribute("email", email);
		}
		if(request.getParameter("telephone")!=null) {
			telephone = request.getParameter("telephone");
			request.setAttribute("telephone", telephone);
		}
		if(request.getParameter("rue")!=null) {
			rue = request.getParameter("rue");
			request.setAttribute("rue", rue);
		}
		if(request.getParameter("codePostal")!=null) {
			codePostal = request.getParameter("codePostal");
			request.setAttribute("codePostal", codePostal);
		}
		if(request.getParameter("ville")!=null) {
			ville = request.getParameter("ville");
			request.setAttribute("ville", ville);
		}
	    
	    String motDePasse = "";
	    try {
		    if(request.getParameter("mdp2")!=null && !request.getParameter("mdp2").equals("")) {
		    	if(request.getParameter("mdp1").equals(request.getParameter("mdp2"))) {
		    	motDePasse = request.getParameter("mdp1");
			    } else {
					throw new Exception("Les mots de passe sont différents.");
			    }
		    } else {
		    	motDePasse = oldUser.getMotDePasse();
		    }
		    newUser = new Utilisateur(oldUser.getNoUtilisateur(), pseudo, nom, prenom, email, telephone, rue, codePostal, ville, oldUser.getCredit(), oldUser.isAdministrateur());
		    newUser.setMotDePasse(motDePasse);
	    	listeModificationOk = manager.update(oldUser, newUser);
	    	request.setAttribute("listeModification", listeModificationOk);
		} catch (BLLException e) {
			request.setAttribute("error", e);
		} catch (Exception e) {
			request.setAttribute("simpleError", e);
		}
	    rd =request.getRequestDispatcher("/WEB-INF/jsp/profilUtilisateur.jsp");
	    rd.forward(request, response);
	    
	    
	}

}
