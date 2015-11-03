package com.kainos.projectdrill.views;

import io.dropwizard.views.View;

public class selectOneFramework extends View {
	
	private int projectId;
	
	public selectOneFramework(int projectId){
		super("/selectOneFramework.ftl");
		this.projectId = projectId;
	}
	
	public int getProjectID() {
		return projectId;
	}
	
	public void setProjectId(int projId){
		this.projectId = projId;
	}

}
