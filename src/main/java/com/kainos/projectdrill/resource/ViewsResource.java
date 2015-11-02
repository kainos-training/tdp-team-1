package com.kainos.projectdrill.resource;

import io.dropwizard.views.View;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.codahale.metrics.annotation.Timed;
import com.kainos.projectdrill.views.Index;

@Path("/")
public class ViewsResource {
	
	@GET
	@Timed
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public View sayHello() throws SQLException{
					
		return new Index();
	}
	
}
