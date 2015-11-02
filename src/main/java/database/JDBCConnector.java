package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kainos.projectdrill.model.framework.Framework;

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
	
	public List<Framework> selectAllFrameworks() throws SQLException {
		PreparedStatement statement = connection.prepareStatement("SELECT id, frameworkName, license, expert, vendor FROM framework");
		
		ResultSet results = statement.executeQuery();
		
		List<Framework> frameworkList = new ArrayList<Framework>();
		
		while (results.next()) {
			Framework newFramework = new Framework(results.getInt(1), results.getString(2), results.getString(3), results.getString(4), results.getString(5));
			frameworkList.add(newFramework);
		}
		
		return frameworkList;
		
		
	}
}
