package fr.eni.encheres.bll;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class TestBLLServlet
 */
@WebServlet("/TestBLLServlet")
public class TestBLLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestBLLServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message="";
		utilisateurManager user = utilisateurManager.getInstance();
		Utilisateur utilisateur = null;
		
	try {
		utilisateur = user.selectById("lbluth@campus.fr","Pa$$w0rd");
		if(utilisateur == null) {
			throw new BLLException();
		} else {
			message ="Connexion reussie";
		}
	} catch (BLLException e) {
		message = "Erreur de connexion";
	}
	response.getWriter().append("Test de connexion : " + message)
						.append(" - " + utilisateur.getPseudo()+ " - " + utilisateur.getEmail());

	}
}
