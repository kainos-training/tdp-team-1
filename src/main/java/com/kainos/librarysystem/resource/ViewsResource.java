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
	
	public ViewsResource(){ }
	
	@GET
	@Timed
	@Path("/index")
	@Produces(MediaType.TEXT_HTML)

	public View sayHello(){
		
		ArrayList<Book> booksList = new ArrayList<Book>();
		booksList.add(new Book(1, "Pandora's Box", "Andrew A Adams", "Management", 2008));
		booksList.add(new Book(2, "Puppet 2.7 Cookbook", "John Arundel", "Technical", 2010));
		return new Index(booksList);

	}

}
