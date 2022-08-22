package fr.eni.encheres.bll;

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
	
	
	private ArticleManager() {
		articleDAO = DAOFactory.getArticleDAO();
		listeArticle = new ArrayList<>();
	}
	
	public static ArticleManager getInstance() {
		if (article == null) {
			article = new ArticleManager();
		}
		return article;
	}

	
	public void insert(ArticleVendu article) throws BLLException, DALException{
		articleDAO.insert(article);
	}
	
	
}
