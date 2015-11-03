package com.kainos.projectdrill.views;

import java.sql.SQLException;
import java.util.List;

import com.kainos.projectdrill.model.framework.Framework;
import io.dropwizard.views.View;

public class Index extends View {
	
    private final List<Framework> frameworks;
	
	public Index(List<Framework> frameworks) throws SQLException {
		super("/index.ftl");
		this.frameworks = frameworks;
	}
	
	public List<Framework> getFrameworks() {
		return this.frameworks;
	}

}
