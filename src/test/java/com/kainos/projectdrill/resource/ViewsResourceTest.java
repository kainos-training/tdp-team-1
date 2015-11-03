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
	public void testDefault() {
		assert(true);
	}
}
 