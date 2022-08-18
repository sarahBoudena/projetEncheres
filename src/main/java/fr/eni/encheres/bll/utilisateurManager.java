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
	
	public void insert (String pseudo, String nom, String prenom, String email, String tel, String rue, String cp, String ville, String mdp) throws BLLException{
		try {
			VerifUtilisateur(pseudo, nom, prenom, email, tel, rue, cp, ville, mdp);
			Utilisateur user = new Utilisateur(pseudo, nom, prenom, email, tel, rue, cp, ville, mdp, 0, false);
			daoUser.insert(user);
		} catch (DALException e) {
			bllException.addException(e);
			throw bllException;
		}
	}
	
	public void update (Utilisateur user) throws BLLException{
		
	}
	
	public void delete (int id) throws BLLException{
		try {
			
			daoUser.delete(id);
			
		}catch(DALException e) {
			Exception ex = new Exception(e.getMessage());
			bllException.addException(ex);
			throw bllException;
		}
	}
	
	public List<Utilisateur> getListeUser() throws BLLException{
		
		return listeUser;
	}
	
	public Utilisateur selectById(int id) throws BLLException{
		Utilisateur user = null;
		
		return user;
	}

	private void VerifUtilisateur(String pseudo, String nom, String prenom, String email, String tel, String rue, String cp, String ville, String mdp) throws BLLException {
		//Vérif champs pseudo complété
		if (pseudo == null || pseudo.isEmpty() || pseudo.isBlank()) {
			Exception e = new Exception("Le pseudo est obligatoire.");
			bllException.addException(e);
		}
		
		//Vérif champs nom complété
		if(nom == null || nom.isEmpty() || nom.isBlank()) {
			Exception e = new Exception("Le nom est obligatoire.");
			bllException.addException(e);
		}
		
		//Vérif champs prénom complété
		if(prenom == null || prenom.isEmpty() || prenom.isBlank()) {
			Exception e = new Exception("Le prénom est obligatoire.");
			bllException.addException(e);
		}
		
		//Vérif champs email complété
		if (email == null || email.isEmpty() || email.isBlank()) {
			Exception e = new Exception("L'email est obligatoire.");
			bllException.addException(e);
		}
		
		//Vérif format email valide
		String Regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(Regex);
		Matcher matcher = pattern.matcher(email);
		if((matcher.matches()== false)) {
			Exception e = new Exception("Adresse mail non valide.");
			bllException.addException(e);
		}
		
		//Vérif champs téléphone complété
		if(tel == null || tel.isEmpty() || tel.isBlank()) {
			Exception e = new Exception("Le téléphone est obligatoire.");
			bllException.addException(e);
		}
		
		//Vérif champs rue complété
		if(rue == null || rue.isEmpty() || rue.isBlank()) {
			Exception e = new Exception("La rue est obligatoire.");
			bllException.addException(e);
		}
		
		//Vérif champs code postal complété
		if(cp == null || cp.isEmpty() || cp.isBlank()) {
			Exception e = new Exception("Le code postal est obligatoire.");
			bllException.addException(e);
		}
		
		//Vérif champs ville complété
		if(ville == null || ville.isEmpty() || ville.isBlank()) {
			Exception e = new Exception("La ville est obligatoire.");
			bllException.addException(e);
		}
		
		//Vérif champs mdp complété
		if(mdp == null || mdp.isEmpty() || mdp.isBlank()) {
			Exception e = new Exception("Le mot de passe est obligatoire.");
			bllException.addException(e);
		}
				
		//Si la liste des exceptions n'est pas vide, lever la BLLException
		if (bllException.getBLLExceptions().size() > 0) {
			throw bllException;
		}
	}

	
}
