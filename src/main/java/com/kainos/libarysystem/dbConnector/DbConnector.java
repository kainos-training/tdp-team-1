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

	public void connection() throws SQLException, ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost/library", "library_user",
					"kainos2015");
		} finally {
			if (connection != null) {
				connection.close();
			}

			if (preparedStatement != null) {
				preparedStatement.close();
			}
		}
	}

	public void getBooksFromDB() throws SQLException, ClassNotFoundException {
		connection();
		String returnAllQuery = "SELECT * FROM books";
		preparedStatement = connection.prepareStatement(returnAllQuery);
		ResultSet rs = preparedStatement.executeQuery();

		int bookID;
		String bookTitle;
		String bookAuthor;
		String bookCategory;
		int bookPublishedYear;
		List<Book> books = new ArrayList<Book>();

		while (rs.next()) {
			bookID = rs.getInt("id");
			bookTitle = rs.getString("title");
			bookAuthor = rs.getString("author");
			bookCategory = rs.getString("category");
			bookPublishedYear = rs.getInt("publish_year");
			Book book = new Book(bookTitle, bookAuthor, bookCategory,
					bookPublishedYear);
			books.add(book);
			System.out.println(book);
		}

	}

	public List<Book> searchForBook(String searchText, String searchBy)
			throws SQLException, ClassNotFoundException {
		switch (searchBy) {
		case "date":
		case "author":
		case "title":
		case "category":
			List<Book> books = new ArrayList<Book>();
			String query = "SELECT * FROM books WHERE ? = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, searchBy);
			preparedStatement.setString(2, searchText);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Book book = new Book(rs.getString("title"),
						rs.getString("author"), rs.getString("category"),
						rs.getInt("publish_year"));
				books.add(book);
			}
			return books;

		default:
			return new ArrayList<Book>();
		}
	}
}
