package com.kainos.projectdrill.views;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.kainos.projectdrill.model.framework.Framework;

import database.JDBCConnector;



public class IndexTest {
	
	JDBCConnector mockClient = mock(JDBCConnector.class);
	List<Framework> frameworks =  new ArrayList<Framework>();
	
	@Test
	public void testGetFriend() throws SQLException {
		// Set our mocks up to return the results we want
		// addFriend should give us a response
		when(mockClient.selectAllFrameworks()).thenReturn(frameworks);
		
		// run our function
		new Index(mockClient);
		
		// check that our mock was called
		verify(mockClient).selectAllFrameworks();
	}

}
