package fr.eni.encheres.bll;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;
import fr.eni.encheres.bll.BLLException;

public class utilisateurManager {
	
	private UtilisateurDAO daoUser;
	public static utilisateurManager Utilisateur;
	
	
	private utilisateurManager () {
		daoUser = DAOFactory.getUtilisateurDAO() ;
	}
	
	public static utilisateurManager getInstance() {
		if (Utilisateur == null) {
			Utilisateur = new utilisateurManager();
		}
			return Utilisateur;
	}
	
	public Utilisateur selectById(String email, String mdp) throws BLLException{
		Utilisateur user = null;
		try {
			user = daoUser.selectById(email, mdp);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException();
		}
		return user;
	}
	
	private void VerifUtilisateur(Utilisateur user) throws BLLException {
		boolean res = true;
		
		if(user.getNoUtilisateur() <= 0 || user.getPseudo() == null || user.getNom() == null || user.getPrenom() == null || user.getEmail() == null 
			|| user.getTelephone() == null || user.getRue() == null || user.getCodePostal() == null || user.getVille() == null) {
			res = false;
		}	
		if (res == false) {
			throw new BLLException("Personne non valide");
		}
	}
	
	private boolean verifMail(Utilisateur user) throws BLLException{
		boolean res = true;
		String Regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(Regex);
		Matcher matcher = pattern.matcher(user.getEmail());
		if((matcher.matches()== false)) {
			res = false;
			throw new BLLException("Adresse mail non valide");
		}
		return res;
	}
	
	
}
