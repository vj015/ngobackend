package com.ngobackend.dto;

public class Loggedinuser {
	
	private String loggedinNumber;
	private int id;
	private String name;
	private String authrole;
	public String getLoggedinNumber() {
		return loggedinNumber;
	}
	public void setLoggedinNumber(String loggedinNumber) {
		this.loggedinNumber = loggedinNumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthrole() {
		return authrole;
	}
	public void setAuthrole(String authrole) {
		this.authrole = authrole;
	}
	public Loggedinuser(String loggedinNumber, int id, String name, String authrole) {
		super();
		this.loggedinNumber = loggedinNumber;
		this.id = id;
		this.name = name;
		this.authrole = authrole;
	}
	public Loggedinuser() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Loggedinuser [loggedinNumber=" + loggedinNumber + ", id=" + id + ", name=" + name + ", authrole="
				+ authrole + "]";
	}
	
	
	
	

}
