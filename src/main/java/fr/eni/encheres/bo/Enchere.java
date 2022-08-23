package fr.eni.encheres.bo;

import java.sql.Date;

public class Enchere {
	
	private int idUser;
	private int idArticle;
	private Date dateEnchere;
	private int montantEnchere;
	
	//Constructeur vide
	public Enchere() {}
	
	//Constructeur avec tous les attributs
	public Enchere(int idUser, int idArticle, Date dateEnchere, int montantEnchere) {
		this.idUser = idUser;
		this.idArticle = idArticle;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public Date getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public int getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	
}
