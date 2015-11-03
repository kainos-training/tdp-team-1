package com.kainos.projectdrill.model.framework;

public class Framework {
	
	private int id;
	private String frameworkName;
	private String license;
	private String expert;
	private String vendor;
	
	public Framework(String frameworkName, String license, String expert, String vendor) {
		setFrameworkName(frameworkName);
		setLicense(license);
		setExpert(expert);
		setVendor(vendor);
	}
	
	public Framework(int id, String frameworkName, 
					 String license, String expert, String vendor) {
		setId(id);
		setFrameworkName(frameworkName);
		setLicense(license);
		setExpert(expert);
		setVendor(vendor);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFrameworkName() {
		return frameworkName;
	}
	
	public void setFrameworkName(String frameworkName) {
		this.frameworkName = frameworkName;
	}
	
	public String getLicense() {
		return license;
	}
	
	public void setLicense(String license) {
		this.license = license;
	}
	
	public String getExpert() {
		return expert;
	}
	
	public void setExpert(String expert) {
		this.expert = expert;
	}
	
	public String getVendor() {
		return vendor;
	}
	
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	
}
