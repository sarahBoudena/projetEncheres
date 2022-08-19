package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.encheres.bo.Utilisateur;



public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	
	private static final String SELECTBYID = "SELECT * FROM UTILISATEURS WHERE email=? AND mot_de_passe=?";
	private static final String INSERT = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE UTILISATEURS SET \r\n"
			+ "					pseudo = ?, nom = ? , prenom = ?, email = ?, telephone = ?, rue = ? ,"
			+ "					code_postal = ?, ville = ?, mot_de_passe = ?, credit = ?\r\n"
			+ "					WHERE no_utilisateur = ?;";
	private static final String DELETE = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ?";

	@Override
	public Utilisateur selectById(String email, String mdp) throws DALException {
        Utilisateur personneSelectionnee = null;
        //Ouverture de la connexion + déclaration du prepared statement
		try(Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(SELECTBYID)){
			//Désactivation du commit automatique en base > sera pris en charge dans le code java
			try {
				cnx.setAutoCommit(false);
				//Alimentation prepared statement sur la sélection de l'utilisateur
				pstmt.setString(1, email);
				pstmt.setString(2, mdp);
				ResultSet res = pstmt.executeQuery();
				if(res.next()) {
					int id = res.getInt("no_utilisateur");
					String pseudo = res.getString("pseudo");
					String nom = res.getString("nom");
					String prenom = res.getString("prenom");
					String mail = res.getString("email");
					String telephone = res.getString("telephone");
					String rue = res.getString("rue");
					String codePostal = res.getString("code_postal");
					String ville = res.getString("ville");
					String password = res.getString("mot_de_passe");
					int credit = res.getInt("credit");
					int admin = res.getInt("administrateur");
					boolean administrateur;
					if (admin == 0) {
						administrateur = false;
					}
					else {
						administrateur = true;
					}
			        personneSelectionnee = new Utilisateur(pseudo, nom, prenom, mail, telephone, rue, codePostal, ville, password, credit, administrateur);
		            personneSelectionnee.setNoUtilisateur(id);
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
			DALException ex = new DALException("Erreur dans la DAL : Utilisateur ou mot de passe incorrect." + e.getMessage());
			throw ex;
		}
		return personneSelectionnee;
	}
	

	@Override
	public void insert(Utilisateur user) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS)){	
			//Désactivation du commit automatique en base > sera pris en charge dans le code java
			try {
				cnx.setAutoCommit(false);
				//Alimentation du prepared statement
				pstmt.setString(1, user.getPseudo());
				pstmt.setString(2, user.getNom());
				pstmt.setString(3, user.getPrenom());
				pstmt.setString(4, user.getEmail());
				pstmt.setString(5, user.getTelephone());
				pstmt.setString(6, user.getRue());
				pstmt.setString(7, user.getCodePostal());
				pstmt.setString(8, user.getVille());
				pstmt.setString(9, user.getMotDePasse());
				pstmt.setInt(10, user.getCredit());
				//Transformation du boolean en bit pour la BDD
				if (!user.isAdministrateur()) {
					pstmt.setInt(11, 0);
				} else {
					pstmt.setInt(11, 1);
				}
				//Excecution de la requête
				pstmt.executeUpdate();
				
				//Récupération de la clé générée automatiquement
				ResultSet res = pstmt.getGeneratedKeys();
				if (res.next()) {
					int key = res.getInt(1);
					user.setNoUtilisateur(key);
				}	
				cnx.commit();
			}catch (SQLException e){
				//Si jamais une erreur est catchée lors de l'execution, retour arrière pour récupérer une base propre
				cnx.rollback();
				throw e;
			}		
		} catch (SQLException e) {
			DALException ex = new DALException("Erreur dans la DAL : Erreur lors de la création de l'utilisateur." + e.getMessage());
			throw ex;
		}
	}

	
	@Override
	public void update(Utilisateur user) throws DALException {
		try(Connection cnx = ConnectionProvider.getConnection();
<<<<<<< HEAD
				PreparedStatement pstmt = cnx.prepareStatement(UPDATE)){
				
				pstmt.setString(1, user.getPseudo());
				pstmt.setString(2, user.getNom());
				pstmt.setString(3, user.getPrenom());
				pstmt.setString(4, user.getEmail());
				pstmt.setString(5, user.getTelephone());
				pstmt.setString(6, user.getRue());
				pstmt.setString(7, user.getCodePostal());
				pstmt.setString(8, user.getVille());
				pstmt.setString(9, user.getMotDePasse());
				pstmt.setInt(10, user.getCredit());
				pstmt.setInt(11, user.getNoUtilisateur());	
				pstmt.executeUpdate();
				
			}catch (SQLException e){
				DALException ex = new DALException("Erreur dans la DAL : mise � jour impossible." + e.getMessage());
=======
				PreparedStatement pstmt = cnx.prepareStatement(DELETE)){
				
				pstmt.setString(1, user.getPseudo());
				pstmt.setString(2, user.getNom());
				pstmt.setString(3, user.getPrenom());
				pstmt.setString(4, user.getEmail());
				pstmt.setString(5, user.getTelephone());
				pstmt.setString(6, user.getRue());
				pstmt.setString(7, user.getCodePostal());
				pstmt.setString(8, user.getVille());
				pstmt.setString(9, user.getMotDePasse());
				pstmt.setInt(10, user.getCredit());
				pstmt.setInt(11, user.getNoUtilisateur());	
				pstmt.executeUpdate();
				
			}catch (SQLException e){
				DALException ex = new DALException("Erreur dans la DAL : mise � jour impossible." + e.getMessage());
>>>>>>> branch 'main' of https://github.com/theblack5word/premier_project_enchere.git
				throw ex;
			}
		
	}

	
	@Override
	public void delete(int id) throws DALException {
		try(Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(DELETE)){
			
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
		}catch (SQLException e){
			DALException ex = new DALException("Erreur dans la DAL : Suppression impossible." + e.getMessage());
			throw ex;
		}
	}

	
	@Override
	public List<Utilisateur> selectAll() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Utilisateur selectById(int id) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

}