package br.com.unicid.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	public static Connection getConnection() throws Exception {
	
		try{  
			String user = "root";
			String password = "";
			String url = "jdbc:mysql://localhost:3306/cadastro_aluno";
			Class.forName("com.mysql.jdbc.Driver");  
			return DriverManager.getConnection(url, user, password);
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}