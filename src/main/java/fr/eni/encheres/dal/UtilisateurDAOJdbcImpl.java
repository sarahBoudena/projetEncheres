package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.encheres.bo.Utilisateur;



public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	
	private static final String SELECTBYID = "SELECT * FROM UTILISATEURS WHERE email=? AND mot_de_passe=?";

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
					String pseudo = res.getString("pseudo");
					String nom = res.getString("nom");
					String prenom = res.getString("prenom");
					String mail = res.getString("email");
					String telephone = res.getString("telephone");
					String rue = res.getString("rue");
					String codePostal = res.getString("code_postal");
					String ville = res.getString("ville");
					int credit = res.getInt("credit");
					int admin = res.getInt("administrateur");
					boolean administrateur;
					if (admin == 0) {
						administrateur = false;
					}
					else {
						administrateur = true;
					}
			        personneSelectionnee = new Utilisateur(pseudo, nom, prenom, mail, telephone, rue, codePostal, ville, credit, administrateur);
		            
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
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void update(Utilisateur user) throws DALException {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void delete(int id) throws DALException {
		// TODO Auto-generated method stub
		
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
