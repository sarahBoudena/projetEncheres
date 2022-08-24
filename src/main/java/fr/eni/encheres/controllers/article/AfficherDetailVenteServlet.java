package fr.eni.encheres.controllers.article;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.EnchereManager;
import fr.eni.encheres.bo.ArticleVendu;

/**
 * Servlet implementation class AfficherDetailVenteServlet
 */
@WebServlet("/article/encherir")
public class AfficherDetailVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherDetailVenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		EnchereManager mng = EnchereManager.getInstance();
		List<ArticleVendu> listeEnchere = new ArrayList<ArticleVendu>();
		
		try {
			listeEnchere = mng.getListeEncheres();
			
			for(ArticleVendu article : listeEnchere) {
				article.getNoArticle();
				article.getNoUtilisateur();
			}
			
			
			
		} catch (BLLException e) {
			
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/enchere/detailEnchere.jsp");
		rd.forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
	}

}
