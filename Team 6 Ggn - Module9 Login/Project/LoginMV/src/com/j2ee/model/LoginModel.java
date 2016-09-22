package com.j2ee.model;

public class LoginModel {
	private String Login = null;
	private  String Password= null;
	private String Emp = null;
	private String Name = null;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	public String getLogin(){
		return Login;
	}
	public String getPassword(){
		return Password;
	}
	
	public void setPassword(String Password){
		this.Password=Password;
	}
	public void setLogin(String Login){
		this.Login=Login;
	}

	public String getEmp() {
		return Emp;
	}

	public void setEmp(String emp) {
		Emp = emp;
	}
}
