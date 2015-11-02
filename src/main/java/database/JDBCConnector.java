package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnector {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_ADDRESS = "jdbc://localhost:1111/team1"; //TODO: Fix port number
	private static final String USERNAME = "user";
	private static final String PASSWORD = "password";
	private Connection connection;
	
	
	public JDBCConnector() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		
		connection = DriverManager.getConnection(DB_ADDRESS);
		
	}
}
