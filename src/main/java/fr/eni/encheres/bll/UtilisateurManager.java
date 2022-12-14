package fr.eni.encheres.bll;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurManager {
	private BLLException bllException;
	
	private UtilisateurDAO daoUser;
	public static UtilisateurManager utilisateur;
	private List<Utilisateur> listeUser;
	private List<String> listeMessageUpdate;
	
	private UtilisateurManager () {
		daoUser = DAOFactory.getUtilisateurDAO() ;
	}
	
	private void initialiserBll() {
		listeUser = new ArrayList<Utilisateur>();
		listeMessageUpdate = new ArrayList<String>();
		bllException = new BLLException();
	}
	
	public static UtilisateurManager getInstance() {
		if (utilisateur == null) {
			utilisateur = new UtilisateurManager();
		}
		utilisateur.initialiserBll();
		return utilisateur;
	}
	
	public Utilisateur verifEmailMdp(String email, String mdp) throws BLLException{
		Utilisateur user = null;
		try {
			user = daoUser.selectByLogin(email, mdp);
		} catch (DALException e) {
			Exception ex = new Exception(e.getMessage());
			bllException.addException(ex);
			throw bllException;
		}
		return user;
	}
	
	public void insert (Utilisateur user) throws BLLException{
		try {
			verifUtilisateur(user.getPseudo(), user.getNom(), user.getPrenom(), user.getEmail(), user.getTelephone(), user.getRue(), user.getCodePostal(), user.getVille(), user.getMotDePasse());
			daoUser.insert(user);
		} catch (DALException e) {
			bllException.addException(e);
			throw bllException;
		}
	}
	
	public List<String> update (Utilisateur oldUser, Utilisateur newUser) throws BLLException{
		try {
			verifUtilisateur(newUser.getPseudo(), newUser.getNom(), newUser.getPrenom(), newUser.getEmail(), newUser.getTelephone(), newUser.getRue(), newUser.getCodePostal(), newUser.getVille(), newUser.getMotDePasse());
			verifModifAddMessage(oldUser, newUser);
			if (listeMessageUpdate.size()>0) {
				daoUser.update(newUser);
			}
		}catch (DALException e) {
			bllException.addException(e);
			throw bllException;
		}
		return listeMessageUpdate;
	}
	
	public void update (Utilisateur User) throws BLLException{
		try {
			daoUser.update(User);
		}catch (DALException e) {
			bllException.addException(e);
			throw bllException;
		}
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
		try {
			user = daoUser.selectById(id);
		} catch (DALException e) {
			Exception ex = new Exception(e.getMessage());
			bllException.addException(ex);
			throw bllException;
		}
		return user;
	}

	private void verifUtilisateur(String pseudo, String nom, String prenom, String email, String tel, String rue, String cp, String ville, String mdp) throws BLLException {
		//V??rif champs pseudo compl??t??
		if (pseudo == null || pseudo.isEmpty() || pseudo.isBlank()) {
			Exception e = new Exception("Le pseudo est obligatoire.");
			bllException.addException(e);
		}
		
		//V??rif pseudo caract??res alphanum??riques
		Pattern p = Pattern.compile("^[a-zA-Z0-9]*$");
		if (!pseudo.matches("^[a-zA-Z0-9]*$")) {
			Exception e = new Exception("Le pseudo ne peut contenir que des caract??res alphanum??riques.");
			bllException.addException(e);
		}
		
		//V??rif champs nom compl??t??
		if(nom == null || nom.isEmpty() || nom.isBlank()) {
			Exception e = new Exception("Le nom est obligatoire.");
			bllException.addException(e);
		}
		
		//V??rif champs pr??nom compl??t??
		if(prenom == null || prenom.isEmpty() || prenom.isBlank()) {
			Exception e = new Exception("Le pr??nom est obligatoire.");
			bllException.addException(e);
		}
		
		//V??rif champs email compl??t??
		if (email == null || email.isEmpty() || email.isBlank()) {
			Exception e = new Exception("L'email est obligatoire.");
			bllException.addException(e);
		}
		
		//V??rif format email valide
		String Regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(Regex);
		Matcher matcher = pattern.matcher(email);
		if((matcher.matches()== false)) {
			Exception e = new Exception("Adresse mail non valide.");
			bllException.addException(e);
		}
		
		//V??rif champs t??l??phone compl??t??
		if(tel == null || tel.isEmpty() || tel.isBlank()) {
			tel = "";
		}
		
		//V??rif champs rue compl??t??
		if(rue == null || rue.isEmpty() || rue.isBlank()) {
			Exception e = new Exception("La rue est obligatoire.");
			bllException.addException(e);
		}
		
		//V??rif champs code postal compl??t??
		if(cp == null || cp.isEmpty() || cp.isBlank()) {
			Exception e = new Exception("Le code postal est obligatoire.");
			bllException.addException(e);
		}
		
		//V??rif champs ville compl??t??
		if(ville == null || ville.isEmpty() || ville.isBlank()) {
			Exception e = new Exception("La ville est obligatoire.");
			bllException.addException(e);
		}
		
		//V??rif champs mdp compl??t??
		if(mdp == null || mdp.isEmpty() || mdp.isBlank()) {
			Exception e = new Exception("Le mot de passe est obligatoire.");
			bllException.addException(e);
		}
				
		//Si la liste des exceptions n'est pas vide, lever la BLLException
		if (bllException.getBLLExceptions().size() > 0) {
			throw bllException;
		}
	}

	private void verifModifAddMessage(Utilisateur oldUser, Utilisateur newUser) {
//		affiche un message par modification d??tect??e
		if (!oldUser.getPseudo().equals(newUser.getPseudo())) {	
			listeMessageUpdate.add("votre pseudo a ??t?? modifi??");
		}
		if (!oldUser.getNom().equals(newUser.getNom())) {
			listeMessageUpdate.add("votre nom a ??t?? modifi??");
		}
		if (!oldUser.getPrenom().equals(newUser.getPrenom())) {
			listeMessageUpdate.add("votre pr??nom a ??t?? modifi??");
		}
		if (!oldUser.getEmail().equals(newUser.getEmail())) {
			listeMessageUpdate.add("votre email a ??t?? modifi??");
		}
		if (!oldUser.getTelephone().equals(newUser.getTelephone())) {
			listeMessageUpdate.add("votre t??l??phone a ??t?? modifi??");
		}
		if (!oldUser.getRue().equals(newUser.getRue())) {
			listeMessageUpdate.add("la rue a ??t?? modifi??e");
		}
		if (!oldUser.getCodePostal().equals(newUser.getCodePostal())) {
			listeMessageUpdate.add("le code postal a ??t?? modifi??");
		}
		if (!oldUser.getVille().equals(newUser.getVille())) {
			listeMessageUpdate.add("la ville a ??t?? modifi??");
		}
		if (!oldUser.getMotDePasse().equals(newUser.getMotDePasse())) {
			listeMessageUpdate.add("le mot de passe a ??t?? modifi??");
		}
	}
	
}
