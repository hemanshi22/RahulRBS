package com.j2ee.AccountOpeningServlet;

import java.sql.Date;

public class AccountSearch {
	private long CUST_ID;
	private long ACC_NO;
	@Override
	public String toString() {
		return "AccountSearch [CUST_ID=" + CUST_ID + ", ACC_NO=" + ACC_NO + ", ACC_TYPE=" + ACC_TYPE + ", DOO=" + DOO
				+ ", INITIAL_DEPOSIT=" + INITIAL_DEPOSIT + ", NOMINEE_NAME=" + NOMINEE_NAME + ", BRANCH_CODE="
				+ BRANCH_CODE + ", BALANCE=" + BALANCE + ", INTEREST_RATE=" + INTEREST_RATE + ", DATE_OF_MATURITY="
				+ DATE_OF_MATURITY + ", ARCHIVED_STATUS=" + ARCHIVED_STATUS + "]";
	}
	private String ACC_TYPE;
	private Date DOO;
	private double INITIAL_DEPOSIT;
	private String NOMINEE_NAME;
	private int BRANCH_CODE;
	private double BALANCE;
	private double INTEREST_RATE;
	private Date DATE_OF_MATURITY;
	private int ARCHIVED_STATUS;
	
	public long getCUST_ID() {
		return CUST_ID;
	}
	public void setCUST_ID(long cUST_ID) {
		CUST_ID = cUST_ID;
	}
	public long getACC_NO() {
		return ACC_NO;
	}
	public void setACC_NO(long aCC_NO) {
		ACC_NO = aCC_NO;
	}
	public String getACC_TYPE() {
		return ACC_TYPE;
	}
	public void setACC_TYPE(String aCC_TYPE) {
		ACC_TYPE = aCC_TYPE;
	}
	public Date getDOO() {
		return DOO;
	}
	public void setDOO(Date dOO) {
		DOO = dOO;
	}
	public double getINITIAL_DEPOSIT() {
		return INITIAL_DEPOSIT;
	}
	public void setINITIAL_DEPOSIT(double iNITIAL_DEPOSIT) {
		INITIAL_DEPOSIT = iNITIAL_DEPOSIT;
	}
	public String getNOMINEE_NAME() {
		return NOMINEE_NAME;
	}
	public void setNOMINEE_NAME(String nOMINEE_NAME) {
		NOMINEE_NAME = nOMINEE_NAME;
	}
	public int getBRANCH_CODE() {
		return BRANCH_CODE;
	}
	public void setBRANCH_CODE(int bRANCH_CODE) {
		BRANCH_CODE = bRANCH_CODE;
	}
	public double getBALANCE() {
		return BALANCE;
	}
	public void setBALANCE(double bALANCE) {
		BALANCE = bALANCE;
	}
	public double getINTEREST_RATE() {
		return INTEREST_RATE;
	}
	public void setINTEREST_RATE(double iNTEREST_RATE) {
		INTEREST_RATE = iNTEREST_RATE;
	}
	public Date getDATE_OF_MATURITY() {
		return DATE_OF_MATURITY;
	}
	public void setDATE_OF_MATURITY(Date dATE_OF_MATURITY) {
		DATE_OF_MATURITY = dATE_OF_MATURITY;
	}
	public int getARCHIVED_STATUS() {
		return ARCHIVED_STATUS;
	}
	public void setARCHIVED_STATUS(int aRCHIVED_STATUS) {
		ARCHIVED_STATUS = aRCHIVED_STATUS;
	}

	
	//@Override
//	public String toString() {
//		return "Transaction [transactionId=" + transactionId + ", transactionDate=" + transactionDate
//				+ ", transactionFrom=" + transactionFrom + ", transactionFromType=" + transactionFromType
//				+ ", transactionTo=" + transactionTo + ", transactionToType=" + transactionToType + ", amount=" + amount
//				+ ", transactionType=" + accountType + "]";
	}
	
	

