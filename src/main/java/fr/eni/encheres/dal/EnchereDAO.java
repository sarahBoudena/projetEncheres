package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;

public interface EnchereDAO extends ObjetDao<Enchere> {

	List<ArticleVendu> selectEncheresEC() throws DALException;

}
