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
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ArticleDAO;
import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.dal.DALException;

public class ArticleDAOJdbcImpl implements ArticleDAO{
	
	private static final String INSERT = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, no_utilisateur, no_categorie, etat_vente, image)\r\n"
			+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String PROCAUTO = "{call updateArticle}";
	private static final String SELECTBYID ="SELECT a.no_article AS a_no_article, a.nom_article AS a_nom_article, a.description AS a_description, a.date_debut_enchere AS a_date_debut_enchere, a.date_fin_enchere AS a_date_fin_enchere, a.prix_initial AS a_prix_initial, a.prix_vente AS a_prix_vente, a.no_utilisateur AS a_no_utilisateur, a.no_categorie AS a_no_categorie, a.etat_vente AS a_etat_vente, a.image AS a_image, e.no_utilisateur AS e_no_utilisateur, e.no_article AS e_no_article, e.date_enchere AS e_date_enchere, e.montant_enchere AS e_montant_enchere, u.no_utilisateur AS u_no_utilisateur, u.pseudo AS u_pseudo, u.nom AS u_nom, u.prenom AS u_prenom, u.email AS u_email, u.telephone AS u_telephone, u.rue AS u_rue, u.code_postal AS u_code_postal, u.ville AS u_ville, u.credit AS u_credit, u.administrateur AS u_administrateur, c.no_categorie AS c_no_categorie, c.libelle AS c_libelle FROM ARTICLES_VENDUS a INNER JOIN UTILISATEURS u ON u.no_utilisateur = a.no_utilisateur LEFT JOIN  ENCHERES e ON e.no_article = a.no_article INNER JOIN CATEGORIES c ON c.no_categorie = a.no_categorie WHERE a_no_article = ?";
	
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
                	
                	int eNoUser = res.getInt("e_no_utilisateur");
                	
                	if (eNoUser == 0) {
         // ELEMENTS ARTICLE
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
	     //ELEMENTS UTILISATEUR
		                    int noUtilisateur = res.getInt("u_no_utilisateur");
							String pseudo = res.getString("u_pseudo");
							String nomUtilisateur = res.getString("u_nom");
							String prenomUtilisateur = res.getString("u_prenom");
							String email = res.getString("u_email");
							String telephone = res.getString("u_telephone");
							String rue = res.getString("u_rue");
							String codePostal = res.getString("u_code_postal");
							String ville = res.getString("u_ville");
							int credit = res.getInt("u_credit");
        // ELEMENTS CATEGORIE
							int noCategorie = res.getInt("c_no_categorie");
							String libelleCat = res.getString("c_libelle");
                	
							Utilisateur user = new Utilisateur(noUtilisateur,pseudo,nomUtilisateur,prenomUtilisateur,email,telephone,rue,codePostal,ville,credit);
							Categorie categorie = new Categorie(noCategorie, libelleCat);
							articleSelectionnee = new ArticleVendu(id, nom, description, dateDebut, dateFin, miseAPrix, prixVente, noUser, noCat, image, user, categorie);

                	} else {
                	
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
			 //ELEMENTS UTILISATEUR
			                    int noUtilisateur = res.getInt("u_no_utilisateur");
								String pseudo = res.getString("u_pseudo");
								String nomUtilisateur = res.getString("u_nom");
								String prenomUtilisateur = res.getString("u_prenom");
								String email = res.getString("u_email");
								String telephone = res.getString("u_telephone");
								String rue = res.getString("u_rue");
								String codePostal = res.getString("u_code_postal");
								String ville = res.getString("u_ville");
								int credit = res.getInt("u_credit");
			// ELEMENTS CATEGORIE
								int noCategorie = res.getInt("c_no_categorie");
								String libelleCat = res.getString("c_libelle");
			//ELEMENTS ENCHERE
								int idUser = res.getInt("e_no_utilisateur");
								int idArticle = res.getInt("e_no_article");
								LocalDateTime dateEnchere = LocalDateTime.of((res.getDate("e_date_enchere").toLocalDate()),
								(res.getTime("e_date_enchere").toLocalTime()));
								int montantEnchere = res.getInt("e_montant_enchere");
			        	
								Utilisateur user = new Utilisateur(noUtilisateur,pseudo,nomUtilisateur,prenomUtilisateur,email,telephone,rue,codePostal,ville,credit);
								Categorie categorie = new Categorie(noCategorie, libelleCat);
								Enchere enchere = new Enchere(idUser, idArticle, dateEnchere, montantEnchere);
								articleSelectionnee = new ArticleVendu(id, nom, description, dateDebut, dateFin, miseAPrix, prixVente, noUser, noCat, image, user, enchere, categorie);
                	}
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
