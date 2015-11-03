package com.kainos.projectdrill.database;

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
	private static final String DB_ADDRESS = "jdbc:mysql://localhost:3306/ktechDB"; // TODO:
																					// Fix
																					// port
																					// number
	private static final String USERNAME = "root";
	private static final String PASSWORD = "ch@ngeme1";

	private Connection connection;

	public JDBCConnector() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);

		connection = DriverManager
				.getConnection(DB_ADDRESS, USERNAME, null);
	}

	public List<Framework> selectAllFrameworks() throws SQLException {
		PreparedStatement statement = connection
				.prepareStatement("SELECT id, frameworkName, license, expert, vendor FROM framework");

		ResultSet results = statement.executeQuery();

		List<Framework> frameworkList = new ArrayList<Framework>();

		while (results.next()) {
			Framework newFramework = new Framework(results.getInt(1),
					results.getString(2), results.getString(3),
					results.getString(4), results.getString(5));
			frameworkList.add(newFramework);
		}

		return frameworkList;

	}

	public Framework selectOneFramework(int id) throws SQLException {
		System.out.println("ID" + id);
		
		PreparedStatement statement = connection
				.prepareStatement("SELECT id, frameworkName, license, expert, vendor FROM framework WHERE id = ?");
		statement.setInt(1, id);

		ResultSet results = statement.executeQuery();
		
		System.out.println("Statement executed!!!");
		
		Framework framework;
		
		while(results.next()) {
			framework = new Framework(results.getInt(1),
					results.getString(2), results.getString(3),
					results.getString(4), results.getString(5));
			
			System.out.println(framework);
			
			return framework;
					
			
		}
		
		
		
		return null;
	}

	public void addNewFramework(String newName, String newLicense, String newExpert, String newVendor) throws SQLException {
		PreparedStatement statement = connection.prepareStatement("call insertFramework('" + newName + "', '" + newLicense + "', '" + newExpert + "', '" + newVendor + "')");
		
		statement.execute();
	}
	
	
	public void updateExpert(int frameworkId, String expert) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("UPDATE framework SET expert = ? WHERE framework.id = ?");
		
		ps.setInt(1, frameworkId);
		ps.setString(2, expert);
		
		ps.execute();
	}
}
