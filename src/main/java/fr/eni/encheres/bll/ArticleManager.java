package fr.eni.encheres.bll;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Utilisateur;
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
		article.initialiserBll();
		return article;
	}

	
	public void insert(ArticleVendu article) throws BLLException{
		try {
			VerifArticle(article);
			articleDAO.insert(article);
		} catch(DALException e) {
			bllException.addException(e);
			throw bllException;
		}
	}
	
	public ArticleVendu selectById(int id) throws BLLException{
		ArticleVendu article = null;
		try {
			article = articleDAO.selectById(id);
		} catch (DALException e) {
			Exception ex = new Exception(e.getMessage());
			bllException.addException(ex);
			throw bllException;
		}
		return article;
	}

	
	public void appelProcedureStockee () throws BLLException{
		try {
			articleDAO.launchProc();;
		} catch(DALException e) {
			bllException.addException(e);
			throw bllException;
		}
	}
	
	private void VerifArticle(ArticleVendu article) throws BLLException {
		Date dateDuJour = Date.valueOf(LocalDate.now());
		
		
	// Vérif nom de l'article
		if (article.getNom() == null || article.getNom().isEmpty() || article.getNom().isBlank()) {
			Exception e = new Exception("Le nom de l'article est obligatoire.");
			bllException.addException(e);
		}
	// Vérif description de l'article
		if (article.getDescription() == null || article.getDescription().isEmpty() || article.getDescription().isBlank()) {
			Exception e = new Exception("Veuillez décrire votre article.");
			bllException.addException(e);
		}
	// Verif Date de début de la vente/		
		if (article.getDateDebutEncheres() == null || article.getDateDebutEncheres().compareTo(LocalDateTime.now())<0) {
			Exception e = new Exception("La date de début de l'enchère ne peut pas être antérieur à la date du jour.");
			bllException.addException(e);
		}
		if(article.getDateFinEncheres() == null || article.getDateFinEncheres().compareTo(article.getDateDebutEncheres()) < 0) {
			Exception e = new Exception("La date de fin de l'enchère ne peut pas être antérieur à la date de début de l'enchère.");
			bllException.addException(e);
			}
		if(article.getMiseAprix() < 0) {
			Exception e = new Exception("Le prix de vente ne peut pas être négatif.");
			bllException.addException(e);
		}
		if(article.getNoUtilisateur() <= 0) {
			Exception e = new Exception("Merci de vous connecter.");
			bllException.addException(e);
		}
		if(article.getNoCategorie() <= 0) {
			Exception e = new Exception("Merci de choisir une catégorie.");
			bllException.addException(e);
		}
		if (article.getEtatVente() == null || article.getEtatVente().isEmpty() || article.getEtatVente().isBlank()) {
			Exception e = new Exception("L'état de l'article est obligatoire.");
			bllException.addException(e);
		}
		if (bllException.getBLLExceptions().size() > 0) {
			throw bllException;
		}
	}
}
