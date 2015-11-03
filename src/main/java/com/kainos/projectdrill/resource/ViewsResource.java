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
import com.kainos.projectdrill.views.ErrorView;
import com.kainos.projectdrill.views.Index;
import com.kainos.projectdrill.views.selectOneFramework;

@Path("/")
public class ViewsResource {
	
	JDBCConnector database;
	
	public ViewsResource(JDBCConnector database) throws SQLException, ClassNotFoundException{
		this.database = new JDBCConnector();
	}
	
	@GET
	@Timed
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public View sayHello() throws SQLException{
		
		List<Framework> allFrameworks = database.selectAllFrameworks();
		return new Index(allFrameworks);
	}

	@GET
	@Timed
	@Path("/selectOneFramework/{id}")
	@Produces(MediaType.TEXT_HTML)
	public View selectOneFramework(@PathParam("id") int id) {
		Framework framework;
		try {
			framework = database.selectOneFramework(id);
			return new selectOneFramework(framework);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ErrorView();
		}
		
		
	}
}
