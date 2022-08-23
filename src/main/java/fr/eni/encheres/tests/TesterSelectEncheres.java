package fr.eni.encheres.tests;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.EnchereDAO;

/**
 * Servlet implementation class TesterSelectEncheres
 */
@WebServlet("/TesterSelectEncheres")
public class TesterSelectEncheres extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TesterSelectEncheres() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message="";
		List<ArticleVendu> listeEncheres = new ArrayList<ArticleVendu>();
		EnchereDAO enchereDAO = DAOFactory.getEnchereDAO();
		try {
			ConnectionProvider.getConnection();
			listeEncheres = enchereDAO.selectEncheresEC();
			for (ArticleVendu e : listeEncheres) {
				System.out.println(e);
			}
			message = "La sélection des enchères s'est bien passée.";
		}catch(SQLException | DALException e){
			message = "Problème lors de la sélection des enchères.";
			message += e.getMessage();
		}
		response.getWriter().append("Test d'insertion dans la BDD : " + message);
	}

}
