package fr.eni.encheres.controllers.utilisateur;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class afficherProfilServlet
 */
@WebServlet("/utilisateur/afficherProfil")
public class AfficherProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String pseudo;
    private String nom ;
    private String prenom ;
    private String email ;
    private String telephone;
    private String rue;
    private String codePostal;
    private String ville;
    
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
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherProfilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("mine", null);
		RequestDispatcher rd;
		String mine = request.getParameter("mine")!=null ? (String)request.getParameter("mine"):null;
		request = createAttribute(request, mine);  /* j'agrémente les attributs de ma requete pour permettre l'affichage par la suite */
		request.setAttribute("mine", mine);
		rd =request.getRequestDispatcher("/WEB-INF/jsp/utilisateur/afficherUtilisateur.jsp");
		rd.forward(request, response);
	}
	
	private HttpServletRequest createAttribute(HttpServletRequest request, String mine) {
		request.setAttribute("pseudo", null);
		request.setAttribute("nom", null);
		request.setAttribute("prenom", null);
		request.setAttribute("email", null);
		request.setAttribute("telephone", null);
		request.setAttribute("rue", null);
		request.setAttribute("codePostal", null);
		request.setAttribute("ville", null);
//		---------- si le parametre du lien mine est "true", alors l'utilisateur veut voir son profil ------------
		if(mine.equals("true")) {
			HttpSession session = request.getSession();
			Utilisateur user = session.getAttribute("user")!=null ? (Utilisateur) session.getAttribute("user"):null;
			request.setAttribute("pseudo", user.getPseudo());
			request.setAttribute("nom", user.getNom());
			request.setAttribute("prenom", user.getPrenom());
			request.setAttribute("email", user.getEmail());
			request.setAttribute("telephone", user.getTelephone());
			request.setAttribute("rue", user.getRue());
			request.setAttribute("codePostal", user.getCodePostal());
			request.setAttribute("ville", user.getVille());
			} else {
//		------------ sinon il veut voir le profil du vendeur, et l'ID du vendeur est envoyé à la place de true -----------
				UtilisateurManager userManager = UtilisateurManager.getInstance();
				Utilisateur vendeur = null;
				try {
					vendeur = userManager.selectById(Integer.parseInt(mine));
				} catch (NumberFormatException | BLLException e) {
					e.printStackTrace();
				}
				request.setAttribute("pseudo", vendeur.getPseudo());
				request.setAttribute("nom", vendeur.getNom());
				request.setAttribute("prenom", vendeur.getPrenom());
				request.setAttribute("email", vendeur.getEmail());
				request.setAttribute("telephone", vendeur.getTelephone());
				request.setAttribute("rue", vendeur.getRue());
				request.setAttribute("codePostal", vendeur.getCodePostal());
				request.setAttribute("ville", vendeur.getVille());
			}
		return request;
	}
}
