package com.kainos.librarysystem;

import com.google.common.collect.ImmutableMap;
import com.kainos.librarysystem.configuration.LibrarySystemConfiguration;
import com.kainos.librarysystem.resource.ViewsResource;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;


public class LibrarySystemApplication extends Application<LibrarySystemConfiguration> {
	
	public static void main(String[] args) throws Exception {
		new LibrarySystemApplication().run(args);
	}

	@Override
	public void run(LibrarySystemConfiguration configuration, Environment environment)
			throws Exception {
		final ViewsResource resource = new ViewsResource();
		environment.jersey().register(resource);
	}
	
	@Override
	public void initialize(Bootstrap<LibrarySystemConfiguration> bootstrap){
		bootstrap.addBundle(new ViewBundle<LibrarySystemConfiguration>() {
	        @Override
	        public ImmutableMap<String, ImmutableMap<String, String>> getViewConfiguration(LibrarySystemConfiguration config) {
	            return config.getViewRendererConfiguration();
	        }
        });   
		
		bootstrap.addBundle(new AssetsBundle("/public/assets", "/assets"));
	}

}
