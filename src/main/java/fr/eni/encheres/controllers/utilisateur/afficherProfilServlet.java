package fr.eni.encheres.controllers.utilisateur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class afficherProfilServlet
 */
@WebServlet("/utilisateur/afficherProfil")
public class afficherProfilServlet extends HttpServlet {
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
    public afficherProfilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("mine", null);
		RequestDispatcher rd;
		String mine = request.getParameter("mine");
		request = createAttribute(request, mine);
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
		
		HttpSession session = request.getSession();
		Utilisateur user = session.getAttribute("user")!=null ? (Utilisateur) session.getAttribute("user"):null;
		
		if(mine.equals("true")) {
			request.setAttribute("pseudo", user.getPseudo());
			request.setAttribute("nom", user.getNom());
			request.setAttribute("prenom", user.getPrenom());
			request.setAttribute("email", user.getEmail());
			request.setAttribute("telephone", user.getTelephone());
			request.setAttribute("rue", user.getRue());
			request.setAttribute("codePostal", user.getCodePostal());
			request.setAttribute("ville", user.getVille());
			}
		return request;
	}
}
