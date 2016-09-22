package com.bankstructure.services;

import java.io.Serializable;

public class EmpDetails implements Serializable{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
//	Declare All Variables	
	
	private int emp_id;
	
	private int area_id;
	private String area_name;
	
	private int branch_id;
	private String branch_name;
	
	private int desk_id;
	private String desk_name;
	
//	Define Constructor

	public EmpDetails(){}
	
	public EmpDetails(int emp_id, int area_id, String area_name, int branch_id, String branch_name, int desk_id, String desk_name) {
	      this.setEmp_id(emp_id);
	      this.setArea_id(area_id);
	      this.setArea_name(area_name);
	      this.setBranch_id(branch_id);
	      this.setBranch_name(branch_name);
	      this.setDesk_id(desk_id);
	      this.setDesk_name(desk_name);
	}

	/**
	 * @return the emp_id
	 */
	public int getEmp_id() {
		return emp_id;
	}

	/**
	 * @param emp_id the emp_id to set
	 */
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	/**
	 * @return the area_id
	 */
	public int getArea_id() {
		return area_id;
	}

	/**
	 * @param area_id the area_id to set
	 */
	public void setArea_id(int area_id) {
		this.area_id = area_id;
	}

	/**
	 * @return the area_name
	 */
	public String getArea_name() {
		return area_name;
	}

	/**
	 * @param area_name the area_name to set
	 */
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}

	/**
	 * @return the branch_id
	 */
	public int getBranch_id() {
		return branch_id;
	}

	/**
	 * @param branch_id the branch_id to set
	 */
	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}

	/**
	 * @return the branch_name
	 */
	public String getBranch_name() {
		return branch_name;
	}

	/**
	 * @param branch_name the branch_name to set
	 */
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	/**
	 * @return the desk_id
	 */
	public int getDesk_id() {
		return desk_id;
	}

	/**
	 * @param desk_id the desk_id to set
	 */
	public void setDesk_id(int desk_id) {
		this.desk_id = desk_id;
	}

	/**
	 * @return the desk_name
	 */
	public String getDesk_name() {
		return desk_name;
	}

	/**
	 * @param desk_name the desk_name to set
	 */
	public void setDesk_name(String desk_name) {
		this.desk_name = desk_name;
	}
}