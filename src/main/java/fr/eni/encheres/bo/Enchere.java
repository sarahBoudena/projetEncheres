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

	
}
