package fr.eni.encheres.bll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.dal.ArticleDAO;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;

public class ArticleManager {
	private BLLException bllException = new BLLException();
	
	private ArticleDAO articleDAO;
	public static ArticleManager article;
	private List<ArticleVendu> listeArticle;
	private List<String> listeMessageUpdate;
	
	
	private ArticleManager() {
		articleDAO = DAOFactory.getArticleDAO();
	}
	
	private void initialiserBll() {
		listeArticle = new ArrayList<>();
		listeMessageUpdate = new ArrayList<>();
		bllException = new BLLException();
	}
	
	
	public static ArticleManager getInstance() {
		if (article == null) {
			article = new ArticleManager();
		}
		return article;
	}

	
	public void insert(ArticleVendu article) throws BLLException{
		try {
		VerifArticle(article.getNom(), article.getDescription(), article.getDateDebutEncheres(), article.getDateFinEncheres(), article.getMiseAprix(), article.getNoUtilisateur(), article.getNoCategorie(), article.getEtatVente(), article.getImage());
		articleDAO.insert(article);
	} catch(DALException e) {
		bllException.addException(e);
		throw bllException;
	}
	}
	
	
	private void VerifArticle(String nom, String description, LocalDate dateDebut, LocalDate dateFin, int miseAPrix,
								int noUtilisateur, int noCategorie, String etatVente, String image) {
		LocalDate dateDuJour = LocalDate.now();
		
		
	// Vérif nom de l'article
		if (nom == null || nom.isEmpty() || nom.isBlank()) {
			Exception e = new Exception("Le nom de l'article est obligatoire.");
			bllException.addException(e);
		}
	// Vérif description de l'article
		if (description == null || description.isEmpty() || description.isBlank()) {
			Exception e = new Exception("Veuillez décrire votre article.");
			bllException.addException(e);
		}
	// Verif Date de début de la vente/		
		if (dateDebut == null || dateDebut.compareTo(dateDuJour)<0) {
			Exception e = new Exception("Veuillez choisir une date valide.");
			bllException.addException(e);
		}
		if(dateFin == null || dateFin.compareTo(dateDebut)<0) {
			Exception e = new Exception("Veuillez choisir une date valide.");
			bllException.addException(e);
			}
		if(miseAPrix < 0) {
			Exception e = new Exception("Veuillez choisir une date valide.");
			bllException.addException(e);
		}
		if(noUtilisateur <= 0) {
			Exception e = new Exception("Merci de vous connecter.");
			bllException.addException(e);
		}
		if(noCategorie <= 0) {
			Exception e = new Exception("Merci de choisir une catégorie.");
			bllException.addException(e);
		}
		if (etatVente == null || etatVente.isEmpty() || etatVente.isBlank()) {
			Exception e = new Exception("L'état de l'article est obligatoire.");
			bllException.addException(e);
		}
		
	}
}
