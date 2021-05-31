package com.cg.fms.entity;

public class Login {
	
	private String employeeName;
	private String employeePassword;
	
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Login(String employeeName, String employeePassword) {
		super();
		this.employeeName = employeeName;
		this.employeePassword = employeePassword;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public String getEmployeePassword() {
		return employeePassword;
	}


	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	
}
