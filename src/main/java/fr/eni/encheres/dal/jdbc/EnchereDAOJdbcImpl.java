package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.EnchereDAO;

public class EnchereDAOJdbcImpl implements EnchereDAO {
	
	private static String SELECTENCHERESEC = "SELECT a.no_article, a.nom_article, a.description, a.date_debut_enchere, a.date_fin_enchere, a.prix_initial, a.no_categorie, a.no_utilisateur, a.image FROM ARTICLES_VENDUS a INNER JOIN UTILISATEURS u ON u.no_utilisateur = a.no_utilisateur LEFT JOIN  ENCHERES e ON e.no_article = a.no_article WHERE a.etat_vente = 'EC'";
	private static final String INSERT = "INSERT INTO ENCHERES(no_utilisateur, no_article, date_enchere, montant_enchere) VALUES (?, ?, ?, ?);";
	private static final String UPDATE = "UPDATE ENCHERES SET no_utilisateur = ?, date_enchere = ?, montant_enchere = ? WHERE no_article = ?";
	
	@Override
	public List<ArticleVendu> selectEncheresEC() throws DALException {
		List<ArticleVendu> encheresEnCours = new ArrayList<ArticleVendu>();
		
		try(Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(SELECTENCHERESEC);){
			
			ResultSet res = pstmt.executeQuery();
			
			while (res.next()) {
				encheresEnCours.add(new ArticleVendu(res.getInt("no_article"),
												res.getString("nom_article"),
												res.getString("description"),
				LocalDateTime.of((res.getDate("date_debut_enchere").toLocalDate()),
				(res.getTime("date_debut_enchere").toLocalTime())),
				LocalDateTime.of((res.getDate("date_fin_enchere").toLocalDate()),
						(res.getTime("date_fin_enchere").toLocalTime())),
												res.getInt("prix_initial"),
												res.getInt("no_utilisateur"),
												res.getInt("no_categorie"),
												res.getString("image")));
			}
		} catch (SQLException e) {
			DALException ex = new DALException("Erreur dans la DAL : impossible d'afficher les enchères en cours" + e.getMessage());
			e.getStackTrace();
			throw ex;
		}
		
		return encheresEnCours;
	}
	

	@Override
	public Enchere selectByLogin(String login, String mdp) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Enchere enchere) throws DALException {
		try	(Connection cnx = ConnectionProvider.getConnection(); 
				PreparedStatement pstmt = cnx.prepareStatement(INSERT)){
			try {
				cnx.setAutoCommit(false);
				pstmt.setInt(1, enchere.getIdUser());
				pstmt.setInt(2, enchere.getIdArticle());
				pstmt.setTimestamp(3, java.sql.Timestamp.valueOf(enchere.getDateEnchere()));
				pstmt.setInt(4, enchere.getMontantEnchere());
				cnx.commit();
			}catch (SQLException e) {
				//Si jamais une erreur est catchée lors de l'execution, retour arrière pour récupérer une base propre
                cnx.rollback();
				e.printStackTrace();
			}
		} catch (SQLException e) {
			DALException ex = new DALException("Erreur lors de l'insertion de l'enchère ");
            e.printStackTrace();
            throw ex;
		}
	}

	@Override
	public void update(Enchere enchere) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement pstmt = cnx.prepareStatement(UPDATE)){
			try {
				cnx.setAutoCommit(false);
				pstmt.setInt(1, enchere.getIdUser());
				pstmt.setTimestamp(2, java.sql.Timestamp.valueOf(enchere.getDateEnchere()));
				pstmt.setInt(3, enchere.getMontantEnchere());
				pstmt.setInt(4, enchere.getIdArticle());
			} catch (SQLException e) {
				
			}
		} catch (SQLException e ) {
			DALException ex = new DALException("Erreur lors de la mise à jour de l'enchère ");
            e.printStackTrace();
            throw ex;
		}
		
		
	}

	@Override
	public void delete(int id) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Enchere> selectAll() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enchere selectById(int id) throws DALException {
		
		return null;
	}


	
}
