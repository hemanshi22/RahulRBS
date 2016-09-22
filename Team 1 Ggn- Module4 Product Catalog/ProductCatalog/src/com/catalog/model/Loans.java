package com.catalog.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Loans implements Serializable{

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private int loanId, maximumDuration,  productId = 1;
	private String loanType, description;
	private double interestRate;
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public int getMaximumDuration() {
		return maximumDuration;
	}
	public void setMaximumDuration(int maximumDuration) {
		this.maximumDuration = maximumDuration;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	
}
