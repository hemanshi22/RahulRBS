package com.account.model;

import java.io.Serializable;
import java.util.Date;

public class Account implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int getCIF() {
		return CIF;
	}
	

	public void setCIF(int cIF) {
		CIF = cIF;
	}

	public String getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}

	public Date getDate_of_open() {
		return date_of_open;
	}

	public void setDate_of_open(Date startDate) {
		this.date_of_open = startDate;
	}

	public int getInitial_deposit() {
		return initial_deposit;
	}

	public void setInitial_deposit(int initial_deposit) {
		this.initial_deposit = initial_deposit;
	}

	public int getBranch_code() {
		return branch_code;
	}

	public void setBranch_code(int branch_code) {
		this.branch_code = branch_code;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private int CIF;
	private int accountNumber;
	private String Nominee;
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getNominee() {
		return Nominee;
	}

	public void setNominee(String nominee) {
		Nominee = nominee;
	}
	private String acc_type;
	private Date date_of_open;
	private int initial_deposit;
	private int branch_code;
	private double int_rate;
	private Date date_of_maturity;
	
	public Date getDate_of_maturity() {
		return date_of_maturity;
	}


	public void setDate_of_maturity(Date endDate) {
		this.date_of_maturity = endDate;
	}


	public double getInt_rate() {
		return int_rate;
	}


	public void setInt_rate(double int_rate2) {
		this.int_rate = int_rate2;
	}


	public Account(){}
	
	public Account(int accountNumber, String Nominee){
		this.accountNumber = accountNumber;
		this.Nominee = Nominee;
	}
}

	


