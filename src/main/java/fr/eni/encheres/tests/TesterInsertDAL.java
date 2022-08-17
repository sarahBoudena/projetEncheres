package fr.eni.encheres.tests;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

/**
 * Servlet implementation class TesterInsertDAL
 */
@WebServlet("/TesterInsertDAL")
public class TesterInsertDAL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TesterInsertDAL() {
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
			ConnectionProvider.getConnection();
			Utilisateur userTest = new Utilisateur("JDD", "DUPOND", "Jean-David", "jdd@campus.fr", "0987654321", "rue de la liberte", "44130", "Bouvron", "Pa$$w0rd", 2, true);
			userDAO.insert(userTest);
			message = "L'utilisateur a bien été inséré.";
		}catch(SQLException | DALException e) {
			message = "Erreur lors de l'insertion de l'utilisateur.";
		}
		response.getWriter().append("Test d'insertion dans la BDD : " + message);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
