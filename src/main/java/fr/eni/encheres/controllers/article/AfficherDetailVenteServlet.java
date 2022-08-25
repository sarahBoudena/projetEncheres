package fr.eni.encheres.controllers.article;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.EnchereManager;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class AfficherDetailVenteServlet
 */
@WebServlet("/article/detail")
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
		ArticleManager mng = ArticleManager.getInstance();
		UtilisateurManager user = UtilisateurManager.getInstance();
		ArticleVendu article = null;
		
		
		int noArticle = Integer.parseInt(request.getParameter("noArticle"));	
		
		try {
			article = mng.selectById(noArticle);
			
		//FORMAT DATE
 			LocalDateTime dateFin = article.getDateFinEncheres();
			String DATE_FORMATTER= "dd-MM-yyyy HH:mm:ss";	
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
			String dateFinEnchere = dateFin.format(formatter);
			
		//MEILLEUR ENCHERE
			if(!article.enchereIsNull()) {
				Utilisateur meilleureOffreUser = user.selectById(article.getEnchere().getIdUser());
				String meilleureOffrePseudo = meilleureOffreUser.getPseudo();
				request.setAttribute("meilleureOffrePseudo", meilleureOffrePseudo);
			}
			request.setAttribute("article", article);
			request.setAttribute("dateFinEnchere", dateFinEnchere);
			
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
