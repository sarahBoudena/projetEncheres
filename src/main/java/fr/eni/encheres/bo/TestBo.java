package fr.eni.encheres.bo;


import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

public class TestBo {

	public static void main(String[] args) {
		
		Utilisateur Jose = new Utilisateur (1, "JoseTheKing", "Bachelier", "Jose", "jose.bachelier@eni.com", "0607080910", "rue des gendarmes", "44500", "Blain", 15, false);
		Utilisateur Jose2 = new Utilisateur ("JoseTheKing", "Bachelier", "Jose", "jose.bachelier@eni.com", "0607080910", "rue des gendarmes", "44500", "Blain", "Pa$$w0rd", 15, false);

		System.out.println(Jose.toString());
		System.out.println(Jose2.toString());
		
		
		int id = Jose.getNoUtilisateur();
		System.out.println(id);
		
		
		ArticleVendu JoseArt = new ArticleVendu(1, "Jose", "C'est Jose", Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()), 100, 1, 2, null);
		System.out.println(JoseArt.toString());
	
	
	}
	
	

}
