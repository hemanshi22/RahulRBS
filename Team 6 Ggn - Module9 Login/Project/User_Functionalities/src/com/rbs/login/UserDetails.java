package com.rbs.login;

import java.io.Serializable;


public class UserDetails implements Serializable {

	private static final long serialVersionUID = 1L;
//	@SuppressWarnings("unused")
	
	private int userActive,userEmpid, userDeskid;
	private String userName, userEmail ,userPhone;
	
	public int getuserEmpid() {
		return userEmpid;
	}    

	public void setuserEmpid(int userEmpid) {
		this.userEmpid = userEmpid;
	}
	
	public int getuserDeskid() {
		return userDeskid;
	}

	public void setuserDeskid(int userDeskid) {
		this.userDeskid = userDeskid;
	}
	
	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}
		
	public String getuserPhone() {
		return userPhone;
	}

	public void setuserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
	public String getuserEmail() {
		return userEmail;
	}

	public void setuserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
	public int getuserActive() {
		return userActive;
	}

	public void setuserActive(int userActive) {
		this.userActive = userActive;
	}
	
	
}


