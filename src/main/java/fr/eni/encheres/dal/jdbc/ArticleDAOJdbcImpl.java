package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.dal.ArticleDAO;
import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.dal.DALException;

public class ArticleDAOJdbcImpl implements ArticleDAO{
	
	private static final String INSERT = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente, image)\r\n"
			+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	@Override
	public ArticleVendu selectByLogin(String login, String mdp) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(ArticleVendu article) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection();
	            PreparedStatement pstmt = cnx.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS)){ 
			
//			try {
//				cnx.setAutoCommit(false);
//				 //Alimentation du prepared statement
//				pstmt.setString(1, article.getNom());
//				pstmt.setString(2, article.getDescription());
//				pstmt.setDate(3, java.sql.Date.valueOf(article.getDateDebutEncheres()));
//				pstmt.setDate(4, java.sql.Date.valueOf(article.getDateFinEncheres()));
//				pstmt.setInt(5, article.getMiseAprix());
//				pstmt.setInt(6, article.getPrixVente());
//				pstmt.setInt(7, article.getNoUtilisateur());
//				pstmt.setInt(8,article.getNoCategorie());
//				pstmt.setString(9, article.getEtatVente());
//				pstmt.setString(10, article.getImage);
//				
//			} catch(SQLException e) {
//				
//			}
			
		} catch (SQLException e) {
			
		}
		
	}

	@Override
	public void update(ArticleVendu a) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ArticleVendu> selectAll() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleVendu selectById(int id) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

}
