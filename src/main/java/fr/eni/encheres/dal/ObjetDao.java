package fr.eni.encheres.dal;

import java.util.List;

public interface ObjetDao <T>{
	
	public T selectByLogin(String login, String mdp) throws DALException;
	
	public void insert(T a) throws DALException;
	
	public void update(T a) throws DALException;
	
	public void delete(int id) throws DALException;
	
	public List<T> selectAll() throws DALException;
	
	public T selectById(int id) throws DALException;

}
