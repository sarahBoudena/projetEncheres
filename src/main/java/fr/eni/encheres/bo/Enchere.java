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
	
	public LocalDateTime getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDateTime dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public int getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	@Override
	public String toString() {
		return "Enchere [idUser=" + idUser + ", idArticle=" + idArticle + ", dateEnchere=" + dateEnchere
				+ ", montantEnchere=" + montantEnchere + "]";
	}
	
	
	
}
