package com.kainos.projectdrill.views;

import java.util.List;

import io.dropwizard.views.View;

public class selectOneFramework extends View {
	
	private int projectId;
	private List<String> projects;
	
	public selectOneFramework(int projectId){
		super("/selectOneFramework.ftl");
		this.projectId = projectId;
	}
	
	public selectOneFramework(int projectId, List<String> projects){
		super("/selectOneFramework.ftl");
		this.projectId = projectId;
		this.projects = projects;
	}
	
	public int getProjectID() {
		return projectId;
	}
	
	public void setProjectId(int projId){
		this.projectId = projId;
	}

	public List<String> getProjects() {
		return projects;
	}
	
	

}
