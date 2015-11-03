package com.kainos.projectdrill.views;

import io.dropwizard.views.View;

import com.kainos.projectdrill.model.framework.Framework;

public class selectOneFramework extends View {
	
	private Framework framework;
	
	
	public selectOneFramework(Framework framework){
		super("/selectOneFramework.ftl");
		System.out.println(framework);
		this.framework = framework;
	}


	public Framework getFramework() {
		return framework;
	}


	public void setFramework(Framework framework) {
		this.framework = framework;
	}
	
	

}
