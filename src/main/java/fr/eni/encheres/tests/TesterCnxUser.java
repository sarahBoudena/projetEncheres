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
 * Servlet implementation class TesterCnxUser
 */
@WebServlet("/TesterCnxUser")
public class TesterCnxUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TesterCnxUser() {
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
			Utilisateur test1 = userDAO.selectById("gbluth@campus.fr", "Pa$$w0rd");
			if(test1 == null) {
				throw new DALException("Erreur de connexion");
			}
			else {
				message = "Connexion utilisateur test1 réussie.";
			}
		} catch (DALException | SQLException e) {
			message += e.getMessage();
			e.printStackTrace();
		}
		response.getWriter().append("Test de connexion : " + message);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
