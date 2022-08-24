package fr.eni.encheres.tests;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ArticleDAO;
import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

/**
 * Servlet implementation class TesterInsertArticleDAL
 */
@WebServlet("/TesterInsertArticleDAL")
public class TesterInsertArticleDAL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TesterInsertArticleDAL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message="";
		ArticleDAO articleDAO = DAOFactory.getArticleDAO();
		try {
			ConnectionProvider.getConnection();
		//TEST INSERT ARTICLE
			ArticleVendu articleTest = new ArticleVendu("Article", "Ceci est un nouvel article", LocalDateTime.now(), LocalDateTime.now(), 100, 2, 3, null);
			articleDAO.insert(articleTest);
			message = "L'article a bien été inséré.";
			
		// Test SELECTBYID Article
			ArticleVendu articleTest2 = articleDAO.selectById(3);
			System.out.println(articleTest2.toString());
			
			
		}catch(SQLException | DALException e) {
			message = "Erreur lors de l'insertion de l'article.";
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
