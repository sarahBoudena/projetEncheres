package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Utilisateur;

public interface UtilisateurDAO {
	
	public Utilisateur selectById(String email, String mdp) throws DALException;

}
