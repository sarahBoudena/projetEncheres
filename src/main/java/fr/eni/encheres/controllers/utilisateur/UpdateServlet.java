package fr.eni.encheres.controllers.utilisateur;

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
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/utilisateur/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String pseudo;
    private String nom ;
    private String prenom ;
    private String email ;
    private String telephone;
    private String rue;
    private String codePostal;
    private String ville;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	@Override
	public void init() throws ServletException {
		pseudo = null;
		nom =null;
		prenom = null;
		email = null;
		telephone = null;
		rue = null;
		codePostal = null;
		ville = null;
		super.init();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/utilisateur/updateProfil.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		UtilisateurManager manager = UtilisateurManager.getInstance();
		HttpSession session = request.getSession();
		Utilisateur oldUser = session.getAttribute("user")!=null ? (Utilisateur) session.getAttribute("user"):null;
		Utilisateur newUser = null;
		List<String> listeModificationOk = new ArrayList<String>();
		request = createAttribute(request);
	    String motDePasse = "";
	    try {
		    if(request.getParameter("mdp2")!=null && !request.getParameter("mdp2").isBlank() && !request.getParameter("mdp2").isEmpty()) {
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
	    	session.setAttribute("user", newUser);
	    	if (listeModificationOk.size()!=0) {
	    		request.setAttribute("listeModification", listeModificationOk);
	    	}
		} catch (BLLException e) {
			request.setAttribute("error", e);
		} catch (Exception e) {
			request.setAttribute("simpleError", e);
		}
	    rd =request.getRequestDispatcher("/WEB-INF/jsp/utilisateur/updateProfil.jsp");
	    rd.forward(request, response);
	}
	
	private HttpServletRequest createAttribute(HttpServletRequest request) {
		request.setAttribute("pseudo", null);
		request.setAttribute("nom", null);
		request.setAttribute("prenom", null);
		request.setAttribute("email", null);
		request.setAttribute("telephone", null);
		request.setAttribute("rue", null);
		request.setAttribute("codePostal", null);
		request.setAttribute("ville", null);
		
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
		return request;
	}
}
