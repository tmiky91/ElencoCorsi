package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	private static final String jdbcURL = "jdbc:mysql://localhost/iscritticorsi?user=root&password=root" ;
	private static Connection  conn=null;
	
	public static Connection getConnection() {
		try {
			if(conn== null || conn.isClosed()) {
				conn = DriverManager.getConnection(jdbcURL) ;
			}
		} catch (SQLException e) {
			System.out.println("Non e' possibile aprire la connessione con il DB");
			//e.printStackTrace();
		}
		return conn;
		
	}

}
