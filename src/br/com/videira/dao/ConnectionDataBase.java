package br.com.videira.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDataBase {

	private static final String URL = "jdbc:derby:celula;create=true";
	private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";

	public static Connection getConnection() throws InstantiationException, IllegalAccessException {

			System.out.println("Conectando ao Banco de Dados");
			try {
				Class.forName(DRIVER).newInstance();
				return DriverManager.getConnection(URL);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		return null;
	}
}
