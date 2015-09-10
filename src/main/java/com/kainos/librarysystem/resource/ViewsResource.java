package com.kainos.librarysystem.resource;

import io.dropwizard.views.View;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import com.codahale.metrics.annotation.Timed;
import com.kainos.libarysystem.dbConnector.DbConnector;
import com.kainos.librarysystem.models.Book;
import com.kainos.librarysystem.views.Index;
import com.kainos.librarysystem.views.SearchResults;

@Path("/")
public class ViewsResource {

	private DbConnector dbConnector;

	public ViewsResource(DbConnector dbConnector) {
		this.dbConnector = dbConnector;
	}

	@GET
	@Timed
	@Path("/index")
	@Produces(MediaType.TEXT_HTML)
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

		String searchMessage = "";
		List<Book> books = dbConnector.searchBooks(searchText, searchCriteria);

		if (books.size() == 0) {
			searchMessage = "No matches for criteria ";
		} else {
			searchMessage = "Matches found for criteria ";
		}
		return new SearchResults(books, searchMessage + searchCriteria + " & "
				+ searchText, searchText);
	}

	@GET
	@Timed
	@Path("/return/{id}")
	@Produces(MediaType.TEXT_HTML)
	public Response returnBook(@PathParam("id") int id) throws Exception{
		System.out.println("Hey!");
		dbConnector.returnBook(id);
		return Response.seeOther(UriBuilder.fromUri("/index").build()).build();	
	}
	
}
