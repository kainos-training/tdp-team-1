package com.kainos.projectdrill.resource;

import io.dropwizard.views.View;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.kainos.projectdrill.database.JDBCConnector;
import com.kainos.projectdrill.model.framework.Framework;
import com.kainos.projectdrill.views.Index;

@Path("/")
public class ViewsResource {
	
	JDBCConnector database;
	
	public ViewsResource(JDBCConnector database) throws SQLException, ClassNotFoundException{
		this.database = database;
	}
	
	@GET
	@Timed
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public View getFrameworkList() throws SQLException{
		List<Framework> allFrameworks = database.selectAllFrameworks();	
		return new Index(allFrameworks);
	}
	
	@POST
	@Path("/insertFramework")
	public void insertFramework(@FormParam("nameField") String newName, 
								@FormParam("vendorField") String newVendor, 
								@FormParam("licenseField") String newLicense,
								@FormParam("expertField") String newExpert) throws SQLException {
		
		database.addNewFramework(newName, newLicense, newExpert, newVendor);
		
	}
	
	
}
