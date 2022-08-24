package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ArticleDAO;
import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.dal.DALException;

public class ArticleDAOJdbcImpl implements ArticleDAO{
	
	private static final String INSERT = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, no_utilisateur, no_categorie, etat_vente, image)\r\n"
			+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String PROCAUTO = "{call updateArticle}";
	private static final String SELECTBYID ="Select * FROM ARTICLES_VENDUS WHERE no_article = ?";
	
	@Override
	public ArticleVendu selectByLogin(String login, String mdp) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(ArticleVendu article) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection();
	            PreparedStatement pstmt = cnx.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS)){ 
			
			try {
				cnx.setAutoCommit(false);
				 //Alimentation du prepared statement
				pstmt.setString(1, article.getNom());
				pstmt.setString(2, article.getDescription());
				pstmt.setTimestamp(3, java.sql.Timestamp.valueOf(article.getDateDebutEncheres()));
				pstmt.setTimestamp(4, java.sql.Timestamp.valueOf(article.getDateFinEncheres()));
				pstmt.setInt(5, article.getMiseAprix());
				pstmt.setInt(6, article.getNoUtilisateur());
				pstmt.setInt(7,article.getNoCategorie());
				pstmt.setString(8, article.getEtatVente());
				pstmt.setString(9, article.getImage());
				
				pstmt.executeUpdate();
				ResultSet res = pstmt.getGeneratedKeys();
				
				if (res.next()) {
                    int key = res.getInt(1);
                    article.setNoArticle(key);
				}
				cnx.commit();
				
			} catch(SQLException e) {
				   //Si jamais une erreur est catchée lors de l'execution, retour arrière pour récupérer une base propre
                cnx.rollback();
                throw e;
			}
			
		} catch (SQLException e) {
			DALException ex = new DALException("Erreur dans la DAL : Erreur lors de la création de l'article." + e.getMessage());
            throw ex;
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
		ArticleVendu articleSelectionnee = null;
        //Ouverture de la connexion + déclaration du prepared statement
        try(Connection cnx = ConnectionProvider.getConnection();
            PreparedStatement pstmt = cnx.prepareStatement(SELECTBYID)){
            //Désactivation du commit automatique en base > sera pris en charge dans le code java
            try {
                cnx.setAutoCommit(false);
                //Alimentation prepared statement sur la sélection de l'utilisateur
                pstmt.setInt(1, id);
                ResultSet res = pstmt.executeQuery();
                if(res.next()) {
                    String nom = res.getString("nom_article");
                    String description = res.getString("description");
                    LocalDateTime dateDebut = LocalDateTime.of((res.getDate("date_debut_enchere").toLocalDate()),
            													(res.getTime("date_debut_enchere").toLocalTime()));
                    LocalDateTime dateFin = LocalDateTime.of((res.getDate("date_fin_enchere").toLocalDate()),
    															(res.getTime("date_fin_enchere").toLocalTime()));
                    int miseAPrix = res.getInt("prix_initial");
                    int prixVente = res.getInt("prix_vente");
                    int noUser = res.getInt("no_utilisateur");
                    int noCat = res.getInt("no_categorie");
                    String etatVente = res.getString("etat_vente");
                    String image = res.getString("image");
                    
                    
                    articleSelectionnee = new ArticleVendu(id, nom, description, dateDebut, dateFin, miseAPrix, noUser, noCat, image);
                    //Validation de l'ajout en base si aucune erreur n'a été rencontrée
                    cnx.commit();
                } else {
                    throw new SQLException();
                }
            }catch (SQLException e) {
                //Si jamais une erreur est catchée lors de l'execution, retour arrière pour récupérer une base propre
                cnx.rollback();
                throw e;
            }
        }catch (SQLException e) {
            DALException ex = new DALException("Erreur dans la DAL : Article inconnu." + e.getMessage());
            throw ex;
        }
        return articleSelectionnee;
	}

	public void launchProc () throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection();
	            PreparedStatement pstmt = cnx.prepareCall(PROCAUTO)){ 
			try {
				cnx.setAutoCommit(false);
				pstmt.execute();
				cnx.commit();
			} catch(SQLException e) {
				   //Si jamais une erreur est catchée lors de l'execution, retour arrière pour récupérer une base propre
                cnx.rollback();
                throw e;
			}
		} catch (SQLException e) {
			DALException ex = new DALException("Erreur dans la DAL : Erreur lors du lancement de la procédure stockée." + e.getMessage());
            throw ex;
		}
	}
}
