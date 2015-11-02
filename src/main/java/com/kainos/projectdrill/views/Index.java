package com.kainos.projectdrill.views;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kainos.projectdrill.model.framework.Framework;

import database.JDBCConnector;
import io.dropwizard.views.View;

public class Index extends View {
	
    private final List<Framework> frameworks;
	
	public Index(JDBCConnector database) throws SQLException {
		super("/index.ftl");
		
		database.selectAllFrameworks();
		
		this.frameworks = new ArrayList<Framework>();
		this.frameworks.add(new Framework(1, "Java", "0.2", "Bob Smith", "Oracle"));
		this.frameworks.add(new Framework(1, "JavaScript", "0.2", "Bob Smith", "Oracle"));
		this.frameworks.add(new Framework(1, "PHP", "0.2", "Bob Smith", "Oracle"));
		this.frameworks.add(new Framework(1, "Angular", "0.2", "Bob Smith", "Oracle"));
		this.frameworks.add(new Framework(1, "GO", "0.2", "Bob Smith", "Oracle"));
	
	}
	
	public List<Framework> getFrameworks() {
		return this.frameworks;
	}

}
