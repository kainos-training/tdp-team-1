package com.kainos.librarysystem.resource;

import io.dropwizard.views.View;

import org.junit.Test;

import com.kainos.libarysystem.dbConnector.DbConnector;
import com.kainos.librarysystem.models.Book;
import com.kainos.librarysystem.views.BookDetails;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class DetailsTest {

	@Test
	public void returnsDetailsViewTest() throws Exception{
		DbConnector connector = mock(DbConnector.class);
		int id = 1;
		when(connector.getBookById(id)).thenReturn(new Book());
		
		ViewsResource viewsResource = new ViewsResource(connector);
		
		try {
			View response = viewsResource.getBook(id);
			assertThat(response, instanceOf(BookDetails.class));
			verify(connector.getBookById(id));
		} catch (Exception e) {
			assert(false);
		}		
		
	}
}
