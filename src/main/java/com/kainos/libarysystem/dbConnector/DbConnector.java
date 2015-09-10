package com.kainos.libarysystem.dbConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kainos.librarysystem.models.Book;

public class DbConnector {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	List<Book> books;

	public void connection() throws SQLException, ClassNotFoundException {

	}

	public List<Book> getBooksFromDB() throws SQLException,
			ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost/library", "library_user",
					"kainos2015");

			String returnAllQuery = "SELECT * FROM books";
			preparedStatement = connection.prepareStatement(returnAllQuery);
			ResultSet rs = preparedStatement.executeQuery();

			int bookID;
			String bookTitle;
			String bookAuthor;
			String bookCategory;
			int bookPublishedYear;
			books = new ArrayList<Book>();

			while (rs.next()) {
				bookID = rs.getInt("id");
				bookTitle = rs.getString("title");
				bookAuthor = rs.getString("author");
				bookCategory = rs.getString("category");
				bookPublishedYear = rs.getInt("publish_year");
				Book book = new Book(bookID, bookTitle, bookAuthor,
						bookCategory, bookPublishedYear);
				books.add(book);
			}
		} finally {
			if (connection != null) {
				connection.close();
			}

			if (preparedStatement != null) {
				preparedStatement.close();
			}
		}
		return books;
	}

	public List<Book> searchBooks(String searchText, String searchBy)
			throws SQLException, ClassNotFoundException {
		List<Book> books = new ArrayList<Book>();
		String searchByColumnName;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost/library", "library_user",
					"kainos2015");
			System.out.println("**************************");
			System.out.println(searchText);
			System.out.println(searchBy);
			System.out.println("**************************");
			switch (searchBy) {
			case "Year":
				searchByColumnName = "publish_year";
				break;
			case "Author":
				searchByColumnName = "author";
				break;
			case "Title":
				searchByColumnName = "title";
				break;
			case "Category":
				searchByColumnName = "category";
				break;
			default:
				return books;
			}

			String query = "SELECT * FROM books WHERE " + searchByColumnName
					+ " = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, searchText);

			System.out.println(query);
			System.out.println("**************************");
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Book book = new Book(rs.getInt("id"), rs.getString("title"),
						rs.getString("author"), rs.getString("category"),
						rs.getInt("publish_year"));
				books.add(book);
			}
			return books;
		} catch (SQLException e) {
			return books;
		} finally {
			if (connection != null) {
				connection.close();
			}

			if (preparedStatement != null) {
				preparedStatement.close();
			}
		}
	}
}
