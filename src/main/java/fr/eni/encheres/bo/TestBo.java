package fr.eni.encheres.bo;

public class TestBo {

	public static void main(String[] args) {
		
		Utilisateur Jose = new Utilisateur (1, "JoseTheKing", "Bachelier", "Jose", "jose.bachelier@eni.com", "0607080910", "rue des gendarmes", "44500", "Blain", 15, false);
		Utilisateur Jose2 = new Utilisateur ("JoseTheKing", "Bachelier", "Jose", "jose.bachelier@eni.com", "0607080910", "rue des gendarmes", "44500", "Blain", 15, false);

		System.out.println(Jose.toString());
		System.out.println(Jose2.toString());
	}

}