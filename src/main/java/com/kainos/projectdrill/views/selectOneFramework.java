package com.kainos.projectdrill.views;

import java.util.List;

import io.dropwizard.views.View;

import com.kainos.projectdrill.model.framework.Framework;

public class selectOneFramework extends View {
	
	private List<String> projects;
	private Framework framework;
	
	public selectOneFramework(Framework framework){
		super("/selectOneFramework.ftl");
		this.framework = framework;
	}
	
	public selectOneFramework(Framework framework, List<String> projects){
		super("/selectOneFramework.ftl");
		this.framework = framework;
		this.projects = projects;
	}

	public Framework getFramework() {
		return framework;
	}

	public void setFramework(Framework framework) {
		this.framework = framework;
	}
	
	public List<String> getProjects() {
		return projects;
	}
}
