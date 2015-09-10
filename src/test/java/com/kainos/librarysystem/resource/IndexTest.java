package com.kainos.librarysystem.resource;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.dropwizard.views.View;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import com.kainos.libarysystem.dbConnector.DbConnector;
import com.kainos.librarysystem.models.Book;
import com.kainos.librarysystem.views.Index;
import com.kainos.librarysystem.views.SearchResults;

public class IndexTest {

	@Ignore
	@Test
	public void returnsIndexViewTest() throws Exception {
		// Set up mocking
		DbConnector connector = mock(DbConnector.class);
		when(connector.getBooksFromDB()).thenReturn(new ArrayList<Book>());

		// Call test method
		ViewsResource viewsResource = new ViewsResource(connector);

		try {
			View response = viewsResource.index();
			assertThat(response, instanceOf(Index.class));
			verify(connector.getBooksFromDB());
		} catch (Exception e) {
			assert (false);
		}
	}

	@Ignore
	@Test
	public void returnsSearchResultsEmptyTest() throws Exception {
		DbConnector connector = mock(DbConnector.class);
		when(connector.searchBooks("Pro Git", "Title")).thenReturn(
				new ArrayList<Book>());

		ViewsResource viewsResource = new ViewsResource(connector);

		try {
			View response = viewsResource.searchBooks("Pro Git", "Title");
			assertThat(response, instanceOf(SearchResults.class));
			verify(connector.searchBooks("Pro Git", "Title"));
		} catch (Exception e) {
			assert (false);
		}
	}

	@Ignore
	@Test
	public void returnsSearchResultsTest() throws Exception {
		Book book = new Book(1, "Pro Git", "blah", "blah", 2010);
		ArrayList<Book> books = new ArrayList<Book>();
		books.add(book);

		DbConnector connector = mock(DbConnector.class);
		when(connector.searchBooks("Pro Git", "Title")).thenReturn(books);

		ViewsResource viewsResource = new ViewsResource(connector);

		try {
			View response = viewsResource.searchBooks("Pro Git", "Title");
			assertThat(response, instanceOf(SearchResults.class));
			verify(connector.searchBooks("Pro Git", "Title"));
		} catch (Exception e) {
			assert (false);
		}
	}
}
