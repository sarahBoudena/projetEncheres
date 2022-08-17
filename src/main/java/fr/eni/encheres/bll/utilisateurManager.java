package fr.eni.encheres.bll;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;
import fr.eni.encheres.bll.BLLException;

public class utilisateurManager {
	private BLLException bllException = new BLLException();
	
	private UtilisateurDAO daoUser;
	public static utilisateurManager Utilisateur;
	private List<Utilisateur> listeUser;
	
	
	private utilisateurManager () {
		daoUser = DAOFactory.getUtilisateurDAO() ;
		listeUser = new ArrayList<Utilisateur>();
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
			Exception ex = new Exception(e.getMessage());
			bllException.addException(ex);
			throw bllException;
		}
		return user;
	}
	
	public void insert (Utilisateur user) throws BLLException{
		
	}
	
	public void update (Utilisateur user) throws BLLException{
		
	}
	
	public void delete (int id) throws BLLException{
		
	}
	
	public List<Utilisateur> getListeUser() throws BLLException{
		
		return listeUser;
	}
	
	public Utilisateur selectById(int id) throws BLLException{
		Utilisateur user = null;
		
		return user;
	}

	private void VerifUtilisateur(Utilisateur user) throws BLLException {
		
		if(user.getNoUtilisateur() <= 0 || user.getPseudo() == null || user.getNom() == null || user.getPrenom() == null || user.getEmail() == null 
			|| user.getTelephone() == null || user.getRue() == null || user.getCodePostal() == null || user.getVille() == null) {
			Exception e = new Exception("Tous les chanps doivent �tre compl�t�s");
			bllException.addException(e);
			throw bllException;
		}	
		
	}
	
	private void verifMail(Utilisateur user) throws BLLException{
		String Regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(Regex);
		Matcher matcher = pattern.matcher(user.getEmail());
		if((matcher.matches()== false)) {
			Exception e = new Exception("Adresse mail non valide");
			bllException.addException(e);
			throw bllException;
		}
	}
	
	
}
