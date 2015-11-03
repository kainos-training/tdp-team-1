package com.kainos.projectdrill.resource;

import io.dropwizard.views.View;

import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
	public View selectOneFramework(@PathParam("id") int id) {
		
		Framework framework;
		
		try {
			framework = database.selectOneFramework(id);
			List<String> projects = database.selectProjectsForFramework(id);
			
			List<String> developers = database.selectDevelopersForFramework(id);
			
			return new selectOneFramework(framework, projects, developers);
		} catch (SQLException e) {
			e.printStackTrace();
			return new ErrorView();
		}

	}
	
	@POST
	@Path("/insertFramework")
	public Response insertFramework(@FormParam("nameField") String newName, 
								@FormParam("licenseField") String newLicense,
								@FormParam("expertField") String newExpert,
								@FormParam("vendorField") String newVendor 
								) throws SQLException {
		
		database.addNewFramework(newName, newLicense, newExpert, newVendor);
		return Response.seeOther(URI.create("/frameworksList")).build();
	}
	
	@POST
	@Path("/searchFrameworks")
	public View searchFrameworks(@FormParam("searchType") String newSearchType,
								@FormParam("searchName") String newSearchName) throws SQLException {
		List<Framework> frameworkList = database.searchBy(newSearchType, newSearchName);
		
		return new Index(frameworkList);
		
		
	}

}
