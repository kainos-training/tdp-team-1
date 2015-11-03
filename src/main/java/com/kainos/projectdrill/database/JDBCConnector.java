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
				.getConnection(DB_ADDRESS, USERNAME, PASSWORD);
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

	public List<String> selectProjectsForFramework(int frameworkId) throws SQLException {
		PreparedStatement statement = connection.prepareStatement("CALL getProjects(?)");
		statement.setInt(1, frameworkId);
		
		ResultSet results = statement.executeQuery();
		
		List<String> projectNames = new ArrayList<>();
		
		while(results.next()) {
			projectNames.add(results.getString(1));
		}
		
		return projectNames;
	}
	
	public List<String> selectDevelopersForFramework(int frameworkId) throws SQLException {
		PreparedStatement statement = connection.prepareStatement("CALL getDevelopers(?)");
		statement.setInt(1, frameworkId);
		
		ResultSet results = statement.executeQuery();
		
		List<String> developerNames = new ArrayList<>();
		
		while(results.next()) {
			developerNames.add(results.getString(1));
		}
		
		return developerNames;
	}
	



	public Framework selectOneFramework(int id) throws SQLException{
		
		PreparedStatement statement = connection
				.prepareStatement("SELECT id, frameworkName, license, expert, vendor FROM framework WHERE id = ?");
		statement.setInt(1, id);

		ResultSet results = statement.executeQuery();
		
		Framework framework;
		
		while(results.next()) {
			framework = new Framework(results.getInt(1),
					results.getString(2), results.getString(3),
					results.getString(4), results.getString(5));
			
			return framework;
		}		
		return null;
	}

	public void addNewFramework(String newName, String newLicense, String newExpert, String newVendor) throws SQLException {
		PreparedStatement statement = connection.prepareStatement("call insertFramework('" + newName + "', '" + newLicense + "', '" + newExpert + "', '" + newVendor + "')");
		
		statement.execute();
	}
	
	public void updateExpert(int frameworkId, String expert) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("UPDATE framework SET expert = ? WHERE id = ?");
		
		ps.setString(1, expert);
		ps.setInt(2, frameworkId);
		
		
		ps.execute();
	}

	public List<Framework> searchBy(String searchType, String searchName) throws SQLException {
		
		List<Framework> frameworkList = new ArrayList<Framework>();
		
		switch (searchType) {
		case "frameworkName":
			frameworkList = searchByName(searchName);
			break;
		case "license":
			frameworkList = searchByLicense(searchName);
			break;
		case "expert":
			frameworkList = searchByExpert(searchName);
			break;
		case "vendor":
			frameworkList = searchByVendor(searchName);
			break;
		default:
			break;
		}
		return frameworkList;
	}
	
	public List<Framework> searchByName(String searchName) throws SQLException {
		
		PreparedStatement statement = connection.prepareStatement("SELECT id, frameworkName, license, expert, vendor FROM framework WHERE frameworkName LIKE ?;");
		statement.setString(1, "%" + searchName + "%");
		
		ResultSet results = statement.executeQuery();
		
		ArrayList<Framework> frameworkList = new ArrayList<Framework>();
		
		while (results.next()) {
			Framework newFramework = new Framework(results.getInt(1),
					results.getString(2), results.getString(3),
					results.getString(4), results.getString(5));
			frameworkList.add(newFramework);
		}
		return frameworkList;
	}
	
	public List<Framework> searchByLicense(String searchName) throws SQLException {
		
		PreparedStatement statement = connection.prepareStatement("SELECT id, frameworkName, license, expert, vendor FROM framework WHERE license LIKE ?;");
		statement.setString(1, "%" + searchName + "%");
		
		ResultSet results = statement.executeQuery();
		
		ArrayList<Framework> frameworkList = new ArrayList<Framework>();
		
		while (results.next()) {
			Framework newFramework = new Framework(results.getInt(1),
					results.getString(2), results.getString(3),
					results.getString(4), results.getString(5));
			frameworkList.add(newFramework);
		}
		return frameworkList;
	}
	
	public List<Framework> searchByExpert(String searchName) throws SQLException {
		
		PreparedStatement statement = connection.prepareStatement("SELECT id, frameworkName, license, expert, vendor FROM framework WHERE expert LIKE ?;");
		statement.setString(1, "%" + searchName + "%");
		
		ResultSet results = statement.executeQuery();
		
		ArrayList<Framework> frameworkList = new ArrayList<Framework>();
		
		while (results.next()) {
			Framework newFramework = new Framework(results.getInt(1),
					results.getString(2), results.getString(3),
					results.getString(4), results.getString(5));
			frameworkList.add(newFramework);
		}
		return frameworkList;
	}
	
	public List<Framework> searchByVendor(String searchName) throws SQLException {
		
		PreparedStatement statement = connection.prepareStatement("SELECT id, frameworkName, license, expert, vendor FROM framework WHERE vendor LIKE ?;");
		statement.setString(1, "%" + searchName + "%");
		
		ResultSet results = statement.executeQuery();
		
		ArrayList<Framework> frameworkList = new ArrayList<Framework>();
		
		while (results.next()) {
			Framework newFramework = new Framework(results.getInt(1),
					results.getString(2), results.getString(3),
					results.getString(4), results.getString(5));
			frameworkList.add(newFramework);
		}
		return frameworkList;
	}
}
