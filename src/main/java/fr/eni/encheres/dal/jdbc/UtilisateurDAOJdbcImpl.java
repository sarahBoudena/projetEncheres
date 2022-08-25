package fr.eni.encheres.dal.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.dal.DALException;
import fr.eni.encheres.dal.UtilisateurDAO;


public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
    private static final String SELECTBYID = "SELECT * FROM UTILISATEURS WHERE email=? AND mot_de_passe=?";
    private static final String INSERT = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE UTILISATEURS SET \r\n"
            + "                 pseudo = ?, nom = ? , prenom = ?, email = ?, telephone = ?, rue = ? ,"
            + "                 code_postal = ?, ville = ?, mot_de_passe = ?, credit = ?\r\n"
            + "                 WHERE no_utilisateur = ?;";
    private static final String UPDATE_SANS_MDP = "UPDATE UTILISATEURS SET \r\n"
            + "                 pseudo = ?, nom = ? , prenom = ?, email = ?, telephone = ?, rue = ? ,"
            + "                 code_postal = ?, ville = ?, credit = ?\r\n"
            + "                 WHERE no_utilisateur = ?;";
    private static final String DELETE = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ?";
    private static final String SELECTUSERBYID ="SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, credit, administrateur FROM UTILISATEURS WHERE no_utilisateur = ?";
    
    @Override
    public Utilisateur selectByLogin(String email, String mdp) throws DALException {
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
            DALException ex = new DALException("Utilisateur ou mot de passe incorrect." );
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
        	String message = null;
        	if (e.getMessage().contains("utilisateurs_pseudo_uq")){
        		message = "Le pseudo est déjà utilisé.";
        	}
        	if (e.getMessage().contains("utilisateurs_email_uq")){
        		message = "L'email est déjà utilisé.";
        	}
        	
            DALException ex = new DALException("Erreur lors de la création de l'utilisateur : " + message);
            e.printStackTrace();
            throw ex;
        }
    }
    @Override
    public void update(Utilisateur user) throws DALException {
        try(Connection cnx = ConnectionProvider.getConnection();
                PreparedStatement pstmt = cnx.prepareStatement(UPDATE_SANS_MDP)){
                pstmt.setString(1, user.getPseudo());
                pstmt.setString(2, user.getNom());
                pstmt.setString(3, user.getPrenom());
                pstmt.setString(4, user.getEmail());
                pstmt.setString(5, user.getTelephone());
                pstmt.setString(6, user.getRue());
                pstmt.setString(7, user.getCodePostal());
                pstmt.setString(8, user.getVille());
                pstmt.setInt(9, user.getCredit());
                pstmt.setInt(10, user.getNoUtilisateur());  
                pstmt.executeUpdate();
            }catch (SQLException e){
            	String message = null;
            	if (e.getMessage().contains("utilisateurs_pseudo_uq")){
            		message = "Le pseudo est déjà utilisé.";
            	}
            	if (e.getMessage().contains("utilisateurs_email_uq")){
            		message = "L'email est déjà utilisé.";
            	}
            	e.printStackTrace();
                DALException ex = new DALException("Erreur lors de la mise à jour du profil : " + message);
                e.printStackTrace();
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
    	 Utilisateur personneSelectionnee = null;
         //Ouverture de la connexion + déclaration du prepared statement
         try(Connection cnx = ConnectionProvider.getConnection();
             PreparedStatement pstmt = cnx.prepareStatement(SELECTUSERBYID)){
             //Désactivation du commit automatique en base > sera pris en charge dans le code java
             try {
                 cnx.setAutoCommit(false);
                 //Alimentation prepared statement sur la sélection de l'utilisateur
                 pstmt.setInt(1, id);
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
                     personneSelectionnee = new Utilisateur(id, pseudo, nom, prenom, mail, telephone, rue, codePostal, ville, credit, administrateur);
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
             DALException ex = new DALException("Erreur dans la DAL : Utilisateur inconnu." + e.getMessage());
             throw ex;
         }
         return personneSelectionnee;
    }
	
}