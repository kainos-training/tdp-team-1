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
	
}
