package com.kainos.projectdrill.resource;

import org.junit.Test;

import io.dropwizard.views.View;

import com.kainos.projectdrill.database.JDBCConnector;
import com.kainos.projectdrill.model.framework.Framework;
import com.kainos.projectdrill.views.Index;
import com.kainos.projectdrill.views.selectOneFramework;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

public class ViewsResourceTest {
	
	JDBCConnector mockClient = mock(JDBCConnector.class);
	List<Framework> frameworks =  new ArrayList<Framework>();
	List<String> project =  new ArrayList<String>();
	ViewsResource resource;
	
	@Test
	public void testIfReturnsFrameworkList() throws SQLException, ClassNotFoundException {
				
		resource = new ViewsResource(mockClient);
		View actualView = resource.getFrameworkList();
		
		assertTrue(actualView instanceof Index);
		
		verify(mockClient).selectAllFrameworks();
	}
	
	@Test
	public void testIfReturnsProjectList() throws SQLException, ClassNotFoundException {
				
		resource = new ViewsResource(mockClient);
		View actualView = resource.selectOneFramework(1);
		
		assertTrue(actualView instanceof selectOneFramework);
		
		verify(mockClient).selectProjectsForFramework(1);
	}
	
	@Test
	public void testIfSelectDevelopersIsCalled() throws ClassNotFoundException, SQLException {
		resource = new ViewsResource(mockClient);
		View actualView = resource.selectOneFramework(1);
		
		assertTrue(actualView instanceof selectOneFramework);
		
		verify(mockClient).selectDevelopersForFramework(1);
	}
	
	@Test
	public void testAddFramework() throws ClassNotFoundException, SQLException {
		resource = new ViewsResource(mockClient);
		Response response = resource.insertFramework("Name", "License", "Vendor", "Expert");
		
		assertTrue(response.getStatus() == 303);
		
		verify(mockClient).addNewFramework("Name", "License", "Vendor", "Expert");

	}
}
 