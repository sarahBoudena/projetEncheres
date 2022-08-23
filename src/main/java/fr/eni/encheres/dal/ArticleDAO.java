package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;

public interface ArticleDAO extends ObjetDao <ArticleVendu>{

public ArticleVendu selectByLogin(String login, String mdp) throws DALException;
	
	public void insert(ArticleVendu a) throws DALException;
	
	public void update(ArticleVendu a) throws DALException;
	
	public void delete(int id) throws DALException;
	
	public List<ArticleVendu> selectAll() throws DALException;
	
	public ArticleVendu selectById(int id) throws DALException;
	
	public void launchProc ()throws DALException;
}
