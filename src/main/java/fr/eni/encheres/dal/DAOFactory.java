package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Utilisateur;

public class DAOFactory {
	
	public static UtilisateurDAO getUtilisateurDAO() {
		UtilisateurDAO utilisateurDAO = new UtilisateurDAOJdbcImpl();
		return utilisateurDAO;
	}
}
