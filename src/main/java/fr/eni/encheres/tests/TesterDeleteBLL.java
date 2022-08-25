package fr.eni.encheres.tests;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class TestBLLServlet
 */
@WebServlet("/TestBLLServlet")
public class TesterDeleteBLL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TesterDeleteBLL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message="";
		String message2="";
		UtilisateurManager user = UtilisateurManager.getInstance();
		int id =0;
		
	try {
		
		Utilisateur userTest = new Utilisateur("JDD", "DUPOND", "Jean-David", "jdd@campus.fr", "0987654321", "rue de la liberte", "44130", "Bouvron", "Pa$$w0rd", 2, true);
		user.insert(userTest);
		message = "L'utilisateur a bien été inséré.";
		
		id = userTest.getNoUtilisateur();
		System.out.println(id);
			
		try {		
			System.out.println(id);
	        user.delete(userTest.getNoUtilisateur()); 
	        message= "suppression ok";
	    }  catch (BLLException e) {
	        message = "Erreur de connexion";
	    }	
		
	}  catch (BLLException e) {
		message = "Erreur de suppression";
	}
	response.getWriter().append("Test de suppression : " + message)
						.append("Test de suppression : " + message2);

	}
}
