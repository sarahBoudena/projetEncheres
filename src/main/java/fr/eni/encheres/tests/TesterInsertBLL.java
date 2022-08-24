package fr.eni.encheres.tests;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.utilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class TesterInsertBLL
 */
@WebServlet("/TesterInsertBLL")
public class TesterInsertBLL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TesterInsertBLL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message="";
		utilisateurManager mng = utilisateurManager.getInstance();
		String pseudo = "JoseTheKing";
		String nom = "Bachelier";
		String prenom = "José";
		String email = "jojo@campus.fr";
		String tel = "0601020307";
		String rue = "rue de la Gare";
		String cp = "44130";
		String ville = "Blain";
		String mdp = "JojoLeBoss";
		
		String pseudo1 = "Boubou";
		String nom1 = "";
		String prenom1 = "Babar";
		String email1 = "babar.campus.fr";
		String tel1 = "0601020307";
		String rue1 = "rue de la Gare";
		String cp1 = "44130";
		String ville1 = "Blain";
		String mdp1 = null;	
		
		Utilisateur jose = new Utilisateur(pseudo, nom, prenom, email, tel, rue, cp, ville, mdp, 0, false);
		
		try {
//			mng.insert(pseudo, nom, prenom, email, tel, rue, cp, ville, mdp);
//			mng.selectById("josetheking@campus.fr", "JojoLeBoss");
//			message = "Osez José !";
			
			mng.insert(jose);
			
		}catch(BLLException e) {
			message += "\nErreur lors de l'insertion de l'utilisateur.";
			
			for (Exception bllex : e.getBLLExceptions()) {
				System.out.println(bllex.getMessage());
			}
		}
		System.out.println(jose.getNoUtilisateur());
		response.getWriter().append("Test d'insertion BLL : " + message);
	}



}
