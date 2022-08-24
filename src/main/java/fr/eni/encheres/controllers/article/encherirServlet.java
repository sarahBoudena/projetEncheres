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

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.EnchereManager;
import fr.eni.encheres.bll.utilisateurManager;
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
//		RequestDispatcher rd;
//		ArticleVendu article = null;
//		int nouveauMontantEnchere = 0;
//		HttpSession session = request.getSession();
//		Utilisateur currentUser = (Utilisateur)session.getAttribute("user");
//		utilisateurManager userManager = utilisateurManager.getInstance();
//		EnchereManager enchereManager = EnchereManager.getInstance();
//		
//		if (nouveauMontantEnchere > currentUser.getCredit()) {
//			request.setAttribute("erreur", "votre crédit est insufisant pour enchérir !");
//			doGet(request, response);
//		}
//		try {
//			if (article.enchereIsNull) {
//				if (nouveauMontantEnchere < article.getPrixVente()) {
//					request.setAttribute("erreur", "Votre enchère est insufisante !");
//					doGet(request, response);
//				}
//				Enchere enchere = new Enchere(currentUser.getNoUtilisateur(),article.getNoArticle(),LocalDateTime.now(),nouveauMontantEnchere);
//				article.setEnchere(enchere);
//				enchereManager.insert(enchere);
//				currentUser.setCredit(currentUser.getCredit()-nouveauMontantEnchere);
//				session.setAttribute("user", currentUser);
//				userManager.update(currentUser, currentUser);
//			} else {
//				Enchere enchere = article.getEnchere();
//				if (nouveauMontantEnchere <= enchere.getMontantEnchere()) {
//					request.setAttribute("erreur", "Votre enchère est insufisante !");
//					doGet(request, response);
//				}
//				enchere.setMontantEnchere(nouveauMontantEnchere);
//				
//				
//				
//				
//			}
//		} catch (BLLException e) {
//			request.setAttribute("error", e);
//		}
		
		
		
	}

}
