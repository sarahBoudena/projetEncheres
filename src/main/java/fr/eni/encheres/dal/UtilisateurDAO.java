package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.Utilisateur;

public interface UtilisateurDAO {
	
	public Utilisateur selectById(String email, String mdp) throws DALException;
	
	public void insert(Utilisateur user) throws DALException;
	
	public void update(Utilisateur user) throws DALException;
	
	public void delete(int id) throws DALException;
	
	public List<Utilisateur> selectAll() throws DALException;
	
	public Utilisateur selectById(int id) throws DALException;

}
