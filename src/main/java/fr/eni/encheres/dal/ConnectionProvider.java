package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionProvider {
	
	private static DataSource datasource = null;
	
	static {
		try {
			Context context = new InitialContext();
			datasource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx_qsr");
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("Impossible de charger la ressource.");
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return datasource.getConnection();
	}

}
