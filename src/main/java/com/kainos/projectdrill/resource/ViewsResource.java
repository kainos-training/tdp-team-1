package com.kainos.projectdrill.resource;

import io.dropwizard.views.View;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.kainos.projectdrill.database.JDBCConnector;
import com.kainos.projectdrill.model.framework.Framework;
import com.kainos.projectdrill.views.Index;
import com.kainos.projectdrill.views.selectOneFramework;

@Path("/")
public class ViewsResource {
	
	JDBCConnector database;
	
	public ViewsResource(JDBCConnector database) throws SQLException, ClassNotFoundException{
		this.database = database;
	}
	
	@GET
	@Timed
	@Path("/frameworksList")
	@Produces(MediaType.TEXT_HTML)
	public View getFrameworkList() throws SQLException{
		List<Framework> allFrameworks = database.selectAllFrameworks();	
		return new Index(allFrameworks);
	}

	@GET
	@Timed
	@Path("/selectOneFramework/{id}")
	@Produces(MediaType.TEXT_HTML)
	public View selectOneFramework(@PathParam("id") int id) throws SQLException{
		List<String> projects = database.selectProjectsForFramework(id);
		
		return new selectOneFramework(id, projects);
	}
}
