package com.kainos.projectdrill.resource;

import org.junit.Test;

import io.dropwizard.views.View;

import com.kainos.projectdrill.database.JDBCConnector;
import com.kainos.projectdrill.model.framework.Framework;
import com.kainos.projectdrill.views.Index;

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
	ViewsResource resource;
	
	@Test
	public void testIfReturnsFrameworkList() throws SQLException, ClassNotFoundException {
		
		when(mockClient.selectAllFrameworks()).thenReturn(frameworks);
		
		resource = new ViewsResource(mockClient);
		View actualView = resource.getFrameworkList();
		
		assertTrue(actualView instanceof Index);
		
		verify(mockClient).selectAllFrameworks();
	}
	
	@Test
	public void testDefault() {
		assert(true);
	}
}
 