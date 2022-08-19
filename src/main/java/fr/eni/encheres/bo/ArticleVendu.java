package fr.eni.encheres.bo;


import java.time.LocalDate;

public class ArticleVendu {

	private int noArticle;
	private String nom;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private int miseAprix;
	private int prixVente;
	private String etatVente;
	Utilisateur noUtilisateur;
	
	
	public ArticleVendu(int noArticle, String nom, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
				int miseAprix, int prixVente, String etatVente, Utilisateur noUtilisateur) {
		this.noArticle = noArticle;
		this.nom = nom;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAprix = miseAprix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.noUtilisateur = noUtilisateur;
	}
	
	public ArticleVendu(String nom, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
						int miseAprix, int prixVente, String etatVente, Utilisateur noUtilisateur) {
		this.nom = nom;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAprix = miseAprix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.noUtilisateur = noUtilisateur;
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

	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
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

	public Utilisateur getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(Utilisateur noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}
	
	
}
