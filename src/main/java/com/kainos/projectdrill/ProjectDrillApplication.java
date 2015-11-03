package com.kainos.projectdrill;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

import com.google.common.collect.ImmutableMap;
import com.kainos.projectdrill.configuration.ProjectDrillConfiguration;
import com.kainos.projectdrill.database.JDBCConnector;
import com.kainos.projectdrill.resource.ViewsResource;

public class ProjectDrillApplication extends Application<ProjectDrillConfiguration> {
	
	public static void main(String[] args) throws Exception {
		new ProjectDrillApplication().run(args);
	}

	@Override
	public void run(ProjectDrillConfiguration configuration, Environment environment)
			throws Exception {

		JDBCConnector connector = new JDBCConnector();
		
		final ViewsResource resource = new ViewsResource(connector);
		environment.jersey().register(resource);
	}
	
	@Override
	public void initialize(Bootstrap<ProjectDrillConfiguration> bootstrap){
		bootstrap.addBundle(new ViewBundle<ProjectDrillConfiguration>() {
	        @Override
	        public ImmutableMap<String, ImmutableMap<String, String>> getViewConfiguration(ProjectDrillConfiguration config) {
	            return config.getViewRendererConfiguration();
	        }
        });   
		
		bootstrap.addBundle(new AssetsBundle("/public/assets", "/assets"));
	}

}
