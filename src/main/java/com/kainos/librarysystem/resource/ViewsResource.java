package com.kainos.librarysystem.resource;

import io.dropwizard.views.View;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.kainos.librarysystem.views.Index;

@Path("/")
public class ViewsResource {
	
	public ViewsResource(){ }
	
	@GET
	@Timed
	@Path("/index")
	@Produces(MediaType.TEXT_HTML)
	public View sayHello(){
		return new Index();
	}

}
