package fr.eni.encheres.bll;

import java.util.ArrayList;
import java.util.List;

public class BLLException extends Exception{
	private List<Exception> bllExceptionsListe = new ArrayList<Exception>();
	
	
	public boolean isEmpty() {
		return bllExceptionsListe.size() > 0 ? false : true ;
	}
	
	public List<Exception> getBLLExceptions(){
		return bllExceptionsListe;
	}
	
	public void addException (Exception e) {
		bllExceptionsListe.add(e);
	}
}
