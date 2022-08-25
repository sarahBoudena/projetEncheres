package fr.eni.encheres.dal;

public class DALException extends Exception {

	private static final long serialVersionUID = 1L;
		
	//Constructeur vide
	public DALException() {}
			
	//Constructeur avec message
	public DALException (String message) {
		super(message);
	}
	
	//Constructeur avec message et exception
	public DALException(String message, Throwable exception) {
		super(message, exception);
	}
}
