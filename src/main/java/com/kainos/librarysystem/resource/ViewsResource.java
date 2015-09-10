package com.kainos.librarysystem.resource;

import io.dropwizard.views.View;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.kainos.libarysystem.dbConnector.DbConnector;
import com.kainos.librarysystem.models.Book;
import com.kainos.librarysystem.views.Index;

@Path("/")
public class ViewsResource {

	private DbConnector dbConnector;

	public ViewsResource(DbConnector dbConnector) {
		this.dbConnector = dbConnector;
	}

	public View index() throws Exception {
		List<Book> booksList = dbConnector.getBooksFromDB();
		return new Index(booksList);
	}

	@POST
	@Timed
	@Path("/search")
	@Produces(MediaType.TEXT_HTML)
	public View searchBooks(@FormParam("searchCriteria") String searchCriteria,
			@FormParam("searchText") String searchText) throws Exception {

		List<Book> books = dbConnector.searchBooks(searchText, searchCriteria);

		if (books.size() == 0) {
			return new Index(books, "No matches for criteria " + searchCriteria
					+ " & " + searchText);
		}
		return new Index(books);
	}
}
