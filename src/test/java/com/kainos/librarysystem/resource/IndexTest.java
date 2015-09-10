package com.kainos.librarysystem.resource;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import io.dropwizard.views.View;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.mockito.Mockito.*;

import org.junit.Ignore;
import org.junit.Test;

import com.kainos.libarysystem.dbConnector.DbConnector;
import com.kainos.librarysystem.models.Book;
import com.kainos.librarysystem.views.Index;

public class IndexTest {
	
	@Ignore
	@Test
	public void returnsIndexViewTest() throws Exception{
		// Set up mocking
		DbConnector connector = mock(DbConnector.class);
		when(connector.getBooksFromDB()).thenReturn(new ArrayList<Book>());
		
		// Call test method
		ViewsResource viewsResource = new ViewsResource(connector);
		
		try {
			View response = viewsResource.index();
			assertThat(response, instanceOf(Index.class));
			verify(connector.getBooksFromDB());
		} catch(Exception e) {
			assert(false);
		}
	} 
}
