package fr.eni.encheres.bo;

import java.sql.Date;
import java.time.LocalDateTime;

public class Enchere {
	
	private int idUser;
	private int idArticle;
	private LocalDateTime dateEnchere;
	private int montantEnchere;
	
	//Constructeur vide
	public Enchere() {}
	
	//Constructeur avec tous les attributs
	public Enchere(int idUser, int idArticle, LocalDateTime dateEnchere, int montantEnchere) {
		this.idUser = idUser;
		this.idArticle = idArticle;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}

	
}
