package fr.eni.encheres.bo;


import java.time.LocalDate;
import java.time.LocalTime;

public class ArticleVendu {

	private int noArticle;
	private String nom;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalTime heureDebutEncheres;
	private LocalDate dateFinEncheres;
	private LocalTime heureFinEncheres;
	private int miseAprix;
	private int prixVente;
	private String etatVente;
	int noUtilisateur;
	int noCategorie;
	private String image;
	
	
	public ArticleVendu(int noArticle, String nom, String description, LocalDate dateDebutEncheres, LocalTime heureDebutEncheres, LocalDate dateFinEncheres,
			LocalTime heureFinEncheres, int miseAprix, int noUtilisateur, int noCategorie, String image) {
		this.noArticle = noArticle;
		this.nom = nom;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.heureDebutEncheres = heureDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.heureFinEncheres = heureFinEncheres;
		this.miseAprix = miseAprix;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
		this.etatVente = "CR";
		this.image = image;
		
		
	}
	
	public ArticleVendu(String nom, String description, LocalDate dateDebutEncheres, LocalTime heureDebutEncheres, LocalDate dateFinEncheres,
			LocalTime heureFinEncheres, int miseAprix, int noUtilisateur, int noCategorie, String image) {
		this.nom = nom;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.heureDebutEncheres = heureDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.heureFinEncheres = heureFinEncheres;
		this.miseAprix = miseAprix;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
		this.etatVente = "CR";
		this.image = image;
		
	}

	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}
	
	public LocalTime getHeureDebutEncheres() {
		return heureDebutEncheres;
	}

	public void setHeureDebutEncheres(LocalTime heureDebutEncheres) {
		this.heureDebutEncheres = heureDebutEncheres;
	}

	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	public LocalTime getHeureFinEncheres() {
		return heureFinEncheres;
	}

	public void setHeureFinEncheres(LocalTime heureFinEncheres) {
		this.heureFinEncheres = heureFinEncheres;
	}

	public int getMiseAprix() {
		return miseAprix;
	}

	public void setMiseAprix(int miseAprix) {
		this.miseAprix = miseAprix;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public String getEtatVente() {
		return etatVente;
	}

	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}

	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public int getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nom=" + nom + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", miseAprix="
				+ miseAprix + ", prixVente=" + prixVente + ", etatVente=" + etatVente + ", noUtilisateur="
				+ noUtilisateur + ", noCategorie=" + noCategorie + ", image=" + image + "]";
	}

	
	
}
