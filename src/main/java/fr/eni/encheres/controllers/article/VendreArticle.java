package fr.eni.encheres.controllers.article;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class VendreArticle
 */
@WebServlet("/article/vente")
public class VendreArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendreArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/article/vendreArticle.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Reinitialisation des erreurs
		request.setAttribute("error", null);
		request.setAttribute("erreur", null);	
	// Récuperation des attributs
		String nom = request.getParameter("nom");
		String description = request.getParameter("description");
		String categorie = request.getParameter("categorie");
		String PrixInitial = request.getParameter("PrixInitial");
		String dateDebut = request.getParameter("dateDebut");
		String dateFin = request.getParameter("dateFin");
		
		HttpSession session = request.getSession();
		Utilisateur user =(Utilisateur) session.getAttribute("user");
		int NoUtilisateur = user.getNoUtilisateur();
		String rue = user.getRue();
		String codePostal = user.getCodePostal();
		String ville = user.getVille();
		
		
		ArticleVendu article =null;
		String message="";
		RequestDispatcher rd = null;
		
	// Convert de la date et l'heure
		String dateDebutEnchere[] = dateDebut.split("T");
		String dateFinEnchere[] = dateFin.split("T");
		String jourDebut = dateDebutEnchere[0];
		String jourFin = dateFinEnchere[0];
		String heureDebut = dateDebutEnchere[1];
		String heureFin = dateFinEnchere[1];
		
		LocalDate jourDebutEnchere = LocalDate.parse(jourDebut);
		LocalDate jourFinEnchere = LocalDate.parse(jourFin);
		LocalTime heureDebutEnchere = LocalTime.parse(heureDebut);
		LocalTime heureFinEnchere = LocalTime.parse(heureFin);
		
		LocalDateTime dateDebutComplet = LocalDateTime.of(jourDebutEnchere,heureDebutEnchere);
		LocalDateTime dateFinComplet = LocalDateTime.of(jourFinEnchere, heureFinEnchere);
		
		request.setAttribute("nom", nom);
		request.setAttribute("description", description);
		request.setAttribute("categorie", categorie);
		request.setAttribute("PrixInitial", PrixInitial);
		request.setAttribute("rue", rue);
		request.setAttribute("codePostal", codePostal);
		request.setAttribute("ville", ville);
		
			
		try {
			ArticleManager mng = ArticleManager.getInstance();
			int miseAPrix = Integer.parseInt(PrixInitial);
			
			int noCat = 0;
			if (categorie.equals("Informatique")) {
				noCat=1;
			}	
			if (categorie.equals("Ameublement")) {
				noCat=2;
			} 
			if (categorie.equals("Vêtement")) {
				noCat=3;
			}
			if (categorie.equals("Sport & Loisir")){
				noCat=4;
			}
			
			article = new ArticleVendu(nom,description,dateDebutComplet,dateFinComplet,miseAPrix,NoUtilisateur,noCat,null);
			mng.insert(article);
			message = "Création de l'article réussie";
			
			
			rd = request.getRequestDispatcher("/WEB-INF/jsp/accueil.jsp");
			rd.forward(request, response);
			
		}catch (BLLException e) {	
			request.setAttribute("error", e);
			rd = request.getRequestDispatcher("/WEB-INF/jsp/article/vendreArticle.jsp");
		    rd.forward(request, response);
		}
		
	}

}
