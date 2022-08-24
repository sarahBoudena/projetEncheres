package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.EnchereDAO;

public class EnchereDAOJdbcImpl implements EnchereDAO {
	
	private static String SELECTENCHERESEC = "SELECT a.no_article AS a_no_article, a.nom_article AS a_nom_article, a.description AS a_description, a.date_debut_enchere AS a_date_debut_enchere, a.date_fin_enchere AS a_date_fin_enchere, a.prix_initial AS a_prix_initial, a.prix_vente AS a_prix_vente, a.no_utilisateur AS a_no_utilisateur, a.no_categorie AS a_no_categorie, a.etat_vente AS a_etat_vente, a.image AS a_image, e.no_utilisateur AS e_no_utilisateur, e.no_article AS e_no_article, e.date_enchere AS e_date_enchere, e.montant_enchere AS e_montant_enchere, u.no_utilisateur AS u_no_utilisateur, u.pseudo AS u_pseudo, u.nom AS u_nom, u.prenom AS u_prenom, u.email AS u_email, u.telephone AS u_telephone, u.rue AS u_rue, u.code_postal AS u_code_postal, u.ville AS u_ville, u.credit AS u_credit, u.administrateur AS u_administrateur, c.no_categorie AS c_no_categorie, c.libelle AS c_libelle FROM ARTICLES_VENDUS a INNER JOIN UTILISATEURS u ON u.no_utilisateur = a.no_utilisateur LEFT JOIN  ENCHERES e ON e.no_article = a.no_article INNER JOIN CATEGORIES c ON c.no_categorie = a.no_categorie WHERE a.etat_vente = 'EC'";
	private static final String INSERT = "INSERT INTO ENCHERES(no_utilisateur, no_article, date_enchere, montant_enchere) VALUES (?, ?, ?, ?);";
	private static final String UPDATE = "UPDATE ENCHERES SET no_utilisateur = ?, date_enchere = ?, montant_enchere = ? WHERE no_article = ?";
	
	
	@Override
	public List<ArticleVendu> selectEncheresEC() throws DALException {
		List<ArticleVendu> encheresEnCours = new ArrayList<ArticleVendu>();
		
		try(Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(SELECTENCHERESEC);){
			
			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				
				int eNoUser = res.getInt("e_no_utilisateur");
				
				if (eNoUser == 0) {
					encheresEnCours.add(
				    		  new ArticleVendu(	res.getInt("a_no_article"),
													res.getString("a_nom_article"),
													res.getString("a_description"),
													LocalDateTime.of((res.getDate("a_date_debut_enchere").toLocalDate()),
													(res.getTime("a_date_debut_enchere").toLocalTime())),
													LocalDateTime.of((res.getDate("a_date_fin_enchere").toLocalDate()),
													(res.getTime("a_date_fin_enchere").toLocalTime())),
													res.getInt("a_prix_initial"),
													res.getInt("a_prix_vente"),
													res.getInt("a_no_utilisateur"),
													res.getInt("a_no_categorie"),
													res.getString("a_image"),
													new Utilisateur(res.getInt("u_no_utilisateur"),
																	res.getString("u_pseudo"),
																	res.getString("u_nom"),
																	res.getString("u_prenom"),
																	res.getString("u_email"),
																	res.getString("u_telephone"),
																	res.getString("u_rue"),
																	res.getString("u_code_postal"),
																	res.getString("u_ville"),
																	res.getInt("u_credit")),					
													new Categorie(	res.getInt("c_no_categorie"),
																	res.getString("c_libelle"))
							)
						);
					
				}	
				else {
					encheresEnCours.add(
		    		  new ArticleVendu(	res.getInt("a_no_article"),
											res.getString("a_nom_article"),
											res.getString("a_description"),
											LocalDateTime.of((res.getDate("a_date_debut_enchere").toLocalDate()),
											(res.getTime("a_date_debut_enchere").toLocalTime())),
											LocalDateTime.of((res.getDate("a_date_fin_enchere").toLocalDate()),
											(res.getTime("a_date_fin_enchere").toLocalTime())),
											res.getInt("a_prix_initial"),
											res.getInt("a_prix_vente"),
											res.getInt("a_no_utilisateur"),
											res.getInt("a_no_categorie"),
											res.getString("a_image"),
											new Utilisateur(res.getInt("u_no_utilisateur"),
															res.getString("u_pseudo"),
															res.getString("u_nom"),
															res.getString("u_prenom"),
															res.getString("u_email"),
															res.getString("u_telephone"),
															res.getString("u_rue"),
															res.getString("u_code_postal"),
															res.getString("u_ville"),
															res.getInt("u_credit")),
											new Enchere(	res.getInt("e_no_utilisateur"),
															res.getInt("e_no_article"),
															LocalDateTime.of((res.getDate("e_date_enchere").toLocalDate()),
															(res.getTime("e_date_enchere").toLocalTime())),
															res.getInt("e_montant_enchere")),
											new Categorie(	res.getInt("c_no_categorie"),
															res.getString("c_libelle")))
					);
				}
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
				cnx.commit();
			} catch (SQLException e) {
				cnx.rollback();
				e.printStackTrace();
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
