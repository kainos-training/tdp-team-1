package com.kainos.projectdrill.resource;

import org.junit.Test;
import io.dropwizard.views.View;
import com.kainos.projectdrill.views.Index;

import database.JDBCConnector;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.sql.SQLException;

public class ViewsResourceTest {
	
	JDBCConnector mockClient = mock(JDBCConnector.class);
	ViewsResource resource;
	
	@Test
	public void testSayHelloReturnsIndexView() throws SQLException, ClassNotFoundException {
		resource = new ViewsResource(mockClient);
		View actualView = resource.sayHello();
		assertTrue(actualView instanceof Index);
	}
}
 