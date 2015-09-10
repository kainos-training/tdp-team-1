package com.kainos.librarysystem.resource;

import io.dropwizard.views.View;


import java.util.List;

import java.util.ArrayList;


import javax.ws.rs.GET;
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
	
	public ViewsResource(DbConnector dbConnector){ 
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

}
