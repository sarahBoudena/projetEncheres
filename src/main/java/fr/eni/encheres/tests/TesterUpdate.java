package fr.eni.encheres.tests;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.utilisateurManager;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;
import fr.eni.encheres.dal.jdbc.ArticleDAOJdbcImpl;

/**
 * Servlet implementation class TesterInsertDAL
 */
@WebServlet("/TesterUpdateDAL")
public class TesterUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public TesterUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		------------------ test de la DAL ----------------------
//		String message="";
//		UtilisateurDAO userDAO = DAOFactory.getUtilisateurDAO();
//		try {
//			ConnectionProvider.getConnection();
//			Utilisateur userTest = new Utilisateur("JDDS", "DUPONDS", "Jean-DavidS", "sxbluth@campus.fr", "0987654321", "rue de la liberte", "44130", "Bouvron", "Pa$$w0rd", 2, false);
//			userTest.setNoUtilisateur(5);
//			userDAO.update(userTest);
//			message = "L'utilisateur a bien ete modifie.";
//		}catch(SQLException | DALException e) {
//			e.printStackTrace();
//			message = "Erreur lors de l'insertion de l'utilisateur.";
//		}
//		response.getWriter().append("Test d'insertion dans la BDD : " + message);
		
//		---------------test de la BLL --------------------
//		String message="";
//		String listeMessage ="";
//		utilisateurManager mng = utilisateurManager.getInstance();
//		List<String> listeMessageUpdate = new ArrayList<String>();
//		try {
//			Utilisateur userTestOld = new Utilisateur("JDDS", "DUPONDS", "Jean-DavidS", "sxbluth@campus.fr", "0987654321", "rue de la liberte", "44130", "Bouvron", "Pa$$w0rd", 2, false);
//			userTestOld.setNoUtilisateur(5);
//			
//			Utilisateur userTestNew = new Utilisateur("JDD", "DUPON", "Jean-Davi", "jdds@campus.fr", "0987654321", "rue de la libere", "44130", "Bouvron", "Pa$$w0rd", 2, false);
//			userTestNew.setNoUtilisateur(5);
//			
//			listeMessageUpdate = mng.update(userTestOld,userTestNew);
//			for (String string : listeMessageUpdate) {
//				listeMessage += (string + "\n" );  
//				System.out.println(string);
//			}
//			
//			
//			message = "L'utilisateur a bien ete modifie.";
//		}catch(BLLException e) {
//			e.printStackTrace();
//			message = "Erreur lors de la mise à jour de l'utilisateur.";
//		}
//		--------------------------------- test de la procédure stockée ---------------------------
		String message="";
		try {
			ArticleDAOJdbcImpl.launchProc();
			message = "L'utilisateur a bien ete modifie.";
		}catch(DALException e) {
			e.printStackTrace();
			message = "Erreur lors de l'exécution de la procédure";
		}
		
		
		response.getWriter().append("Test d'insertion dans la BDD : " + message);

	
	}
}
