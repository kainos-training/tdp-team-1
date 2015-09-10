package com.kainos.librarysystem.dbConnector;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.kainos.libarysystem.dbConnector.DbConnector;
import com.kainos.librarysystem.models.Book;
import com.mockrunner.jdbc.BasicJDBCTestCaseAdapter;
import com.mockrunner.jdbc.StatementResultSetHandler;
import com.mockrunner.mock.jdbc.MockConnection;
import com.mockrunner.mock.jdbc.MockResultSet;

public class DbConnectorTests extends BasicJDBCTestCaseAdapter {
	
	@Before
	public void testSetupEmptyResultsSet() {
		MockConnection connection = getJDBCMockObjectFactory().getMockConnection();
		StatementResultSetHandler statementHandler = connection.getStatementResultSetHandler();
		MockResultSet mockResult = statementHandler.createResultSet();
		statementHandler.prepareGlobalResultSet(mockResult);
	}
	
	
	@Test
	public void testGetBooksFromDB_returnAllBooks() throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnector();
		List<Book> books = connector.getBooksFromDB();
		verifySQLStatementExecuted("SELECT * FROM books");
		verifyAllResultSetsClosed();
		verifyAllStatementsClosed();
		verifyConnectionClosed();
	}
	
	@Test
	public void testSearchQuery_byTitle() throws ClassNotFoundException, SQLException {
		DbConnector connector = new DbConnector();
		List<Book> books = connector.searchBooks("ProGit", "title");
		verifyAllResultSetsClosed();
		verifyAllStatementsClosed();
		verifyConnectionClosed();
	}
	
	@Test
	public void testSearchQuery_byAuthor() throws ClassNotFoundException, SQLException {
		DbConnector connector = new DbConnector();
		List<Book> books = connector.searchBooks("Jimmy Jazz", "author");
		verifyAllResultSetsClosed();
		verifyAllStatementsClosed();
		verifyConnectionClosed();
	}
	
	@Test
	public void testSearchQuery_byCategory() throws ClassNotFoundException, SQLException {
		DbConnector connector = new DbConnector();
		List<Book> books = connector.searchBooks("Jimmy Jazz", "category");
		verifyAllResultSetsClosed();
		verifyAllStatementsClosed();
		verifyConnectionClosed();
	}
	
	@Test
	public void testSearchQuery_byDate() throws ClassNotFoundException, SQLException {
		DbConnector connector = new DbConnector();
		List<Book> books = connector.searchBooks("Jimmy Jazz", "date");
		verifyAllResultSetsClosed();
		verifyAllStatementsClosed();
		verifyConnectionClosed();
	}
	
	
	@Test
	public void testBorrowBook() throws ClassNotFoundException, SQLException {
		DbConnector connector = new DbConnector();
		connector.borrowBook("Marc", 1);
		verifyAllStatementsClosed();
		verifyConnectionClosed();
	}
	
	@Test
	public void testReturnBook() throws ClassNotFoundException, SQLException {
		DbConnector connector = new DbConnector();
		connector.returnBook(1);
		verifyAllStatementsClosed();
		verifyConnectionClosed();
	}
	
}
