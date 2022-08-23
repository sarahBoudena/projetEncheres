package fr.eni.encheres.controllers.article;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class encherirServlet
 */
@WebServlet("/article/encherir")
public class encherirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public encherirServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/article/detailEnchere.jsp");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		List<Utilisateur> listeUtilisateursVendeurs = new ArrayList<Utilisateur>();
		List<ArticleVendu> listeArticlesEnVente = new ArrayList<ArticleVendu>();
		List<Enchere> listeEncheres = new ArrayList<Enchere>();
		int nouveauMontantEnchere = 0;
		ArticleVendu article = null;
		Enchere enchere = null;
		HttpSession session = request.getSession();
		Utilisateur currentUser = (Utilisateur)session.getAttribute("user");
		
		
		if (nouveauMontantEnchere > currentUser.getCredit()) {
			request.setAttribute("erreur", "votre crédit est insufisant pour enchérir !");
			doGet(request, response);
		}
		for (Enchere enchere2 : listeEncheres) {
			if (enchere2.getIdArticle() == article.getNoArticle()) {
				enchere = enchere2;
				break;
			}
		}
		if (enchere!=null) {
			
		} else {
			LocalDateTime dateDuJour = LocalDateTime.now();
//			enchere = new Enchere(currentUser.getNoUtilisateur(), article.getNoArticle(),dateDuJour, nouveauMontantEnchere);
		}
		
	}

}
