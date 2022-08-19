package fr.eni.encheres.tests;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

/**
 * Servlet implementation class TesterDeleteDAL
 */
@WebServlet("/TesterDeleteDAL")
public class TesterDeleteDAL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TesterDeleteDAL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message="";
		UtilisateurDAO userDAO = DAOFactory.getUtilisateurDAO();
		
		try {	
			userDAO.delete(12);
			message = "L'utilisateur a bien été supprimé.";
		}catch(DALException e) {
			message = "Erreur lors de la suppression de l'utilisateur.";
		
		}
		response.getWriter().append("Test de suppression dans la BDD : " + message);
							
							
	
	}

}
