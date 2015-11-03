package com.kainos.projectdrill.model;

public class Review {
	
	private String name;
	private String review;
	private int id;
	private int frameworkId;
	
	public Review(String name, String review, int id, int frameworkId) {
		this.name = name;
		this.review = review;
		this.id = id;
		this.frameworkId = frameworkId;
	}
	
	public Review() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFrameworkId() {
		return frameworkId;
	}

	public void setFrameworkId(int frameworkId) {
		this.frameworkId = frameworkId;
	}
	
	
	
	

}
