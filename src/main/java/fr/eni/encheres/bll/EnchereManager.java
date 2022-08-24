package fr.eni.encheres.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.EnchereDAO;

public class EnchereManager {
	private BLLException bllException = new BLLException();
	private EnchereDAO enchereDAO;
	public static EnchereManager enchereMng;
	private List<ArticleVendu> listeEncheres;

	public EnchereManager() {
		enchereDAO = DAOFactory.getEnchereDAO();
	}
	
	private void initialiserBll() {
		listeEncheres = new ArrayList<>();
		bllException = new BLLException();
	}
	
	public static EnchereManager getInstance() {
		if (enchereMng == null) {
			enchereMng = new EnchereManager();
		}
		enchereMng.initialiserBll();
		return enchereMng;
	}

	public List<ArticleVendu> getListeEncheres() throws BLLException {
		try {
			listeEncheres = enchereDAO.selectEncheresEC();
		} catch (DALException e) {
			bllException.addException(e);
			throw bllException;
		}
		return listeEncheres;
	}
	
	public void insert (Enchere enchere) throws BLLException {
		try {
			enchereDAO.insert(enchere);
		} catch (DALException e) {
			bllException.addException(e);
			throw bllException;
		}
	}
	
	public void update (Enchere enchere) throws BLLException{
		try {
			enchereDAO.update(enchere);
		} catch (DALException e) {
			bllException.addException(e);
			throw bllException;
		}
	}
}
