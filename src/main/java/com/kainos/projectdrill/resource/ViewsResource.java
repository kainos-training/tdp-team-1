package com.kainos.projectdrill.resource;

import io.dropwizard.views.View;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.kainos.projectdrill.views.Index;	
import com.kainos.projectdrill.views.selectOneFramework;

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

	@GET
	@Timed
	@Path("/selectOneFramework")
	@Produces(MediaType.TEXT_HTML)
	public View selectOneFramework(){
		return new selectOneFramework();
	}
	
}
