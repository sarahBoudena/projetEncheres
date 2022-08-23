package fr.eni.encheres.dal;

import fr.eni.encheres.dal.jdbc.ArticleDAOJdbcImpl;
import fr.eni.encheres.dal.jdbc.EnchereDAOJdbcImpl;
import fr.eni.encheres.dal.jdbc.UtilisateurDAOJdbcImpl;

public class DAOFactory {
	
	public static UtilisateurDAO getUtilisateurDAO() {
		UtilisateurDAO utilisateurDAO = new UtilisateurDAOJdbcImpl();
		return utilisateurDAO;
	}
	
	public static ArticleDAO getArticleDAO() {
		ArticleDAO articleDAO = new ArticleDAOJdbcImpl();
		return articleDAO;
	}
	
	public static EnchereDAO getEnchereDAO() {
		EnchereDAO enchereDAO = new EnchereDAOJdbcImpl();
		return enchereDAO;
	}
}
