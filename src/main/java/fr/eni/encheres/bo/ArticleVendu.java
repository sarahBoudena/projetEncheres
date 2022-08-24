package fr.eni.encheres.bo;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



public class ArticleVendu {

	private int noArticle;
	private String nom;
	private String description;
	private LocalDateTime dateDebutEncheres;
	private LocalDateTime dateFinEncheres;
	private int miseAprix;
	private int prixVente;
	private String etatVente;
	int noUtilisateur;
	int noCategorie;
	private String image;
	private List<Utilisateur> listeUtilisateur;
	private List<Enchere> listeEnchere;
	private List<Categorie> listeCategorie;
	
	
	
	public ArticleVendu(int noArticle, String nom, String description, LocalDateTime dateDebutEncheres, LocalDateTime dateFinEncheres,
			int miseAprix, int noUtilisateur, int noCategorie, String image) {
		this.noArticle = noArticle;
		this.nom = nom;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAprix = miseAprix;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
		this.etatVente = "CR";
		this.image = image;
		listeUtilisateur = new ArrayList<Utilisateur>();
		listeEnchere = new ArrayList<Enchere>();
		listeCategorie = new ArrayList<Categorie>();
	
	}
	
	public ArticleVendu(String nom, String description, LocalDateTime dateDebutEncheres, LocalDateTime dateFinEncheres,
			int miseAprix, int noUtilisateur, int noCategorie, String image) {
		this.nom = nom;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAprix = miseAprix;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
		this.etatVente = "CR";
		this.image = image;
		listeUtilisateur = new ArrayList<Utilisateur>();
		listeEnchere = new ArrayList<Enchere>();
		listeCategorie = new ArrayList<Categorie>();
		
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

	public LocalDateTime getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres (LocalDateTime dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}
	

	public LocalDateTime getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(LocalDateTime dateFinEncheres) {
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

	public List<Utilisateur> getUtilisateur() {
		return listeUtilisateur;
	}

	public void setUtilisateur(List<Utilisateur> utilisateur) {
		this.listeUtilisateur = utilisateur;
	}

	public List<Enchere> getEnchere() {
		return listeEnchere;
	}

	public void setEnchere(List<Enchere> enchere) {
		this.listeEnchere = enchere;
	}

	public List<Categorie> getCategorie() {
		return listeCategorie;
	}

	public void setCategorie(List<Categorie> categorie) {
		this.listeCategorie = categorie;
	}

	public void addUtilisateur(Utilisateur user) {
		listeUtilisateur.add(user);
	}
	
	public void addEnchere(Enchere enchere) {
		listeEnchere.add(enchere);
	}
	
	public void addCategorie (Categorie categorie) {
		listeCategorie.add(categorie);
	}
	
	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nom=" + nom + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", miseAprix="
				+ miseAprix + ", prixVente=" + prixVente + ", etatVente=" + etatVente + ", noUtilisateur="
				+ noUtilisateur + ", noCategorie=" + noCategorie + ", image=" + image + "]";
	}

	
	
}
