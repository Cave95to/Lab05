package it.polito.tdp.anagrammi.dao;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

public class ConnectDB {
	
	static private final String jdbcUrl = "jdbc:mysql://localhost/dizionario?user=root&password=root";

	static private HikariDataSource ds = null;
	
	public static Connection getConnection() {
		
		if(ds==null) {
		ds = new HikariDataSource();
		
		ds.setJdbcUrl(jdbcUrl);
		
		// non servono SE le abbiamo gia messe nel jdbcUrl sopra
		// ds.setUsername("root");
		// ds.setPassword("root");
		}
		
		try {
				// usiamo hikari per connetterci a database
				Connection connection = ds.getConnection();
				//Connection connection = DriverManager.getConnection(jdbcUrl);
				return connection;

		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException("Cannot get a connection " + jdbcUrl, e);
		}
	}

}
