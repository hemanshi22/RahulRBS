package com.catalog.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Deposits implements Serializable {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private int depositId, maximumDuration, productId = 2;
	private double interestRate;
	private String depositType, description;
	public int getDepositId() {
		return depositId;
	}
	public void setDepositId(int depositId) {
		this.depositId = depositId;
	}
	public int getMaximumDuration() {
		return maximumDuration;
	}
	public void setMaximumDuration(int maximumDuration) {
		this.maximumDuration = maximumDuration;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public String getDepositType() {
		return depositType;
	}
	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
}
