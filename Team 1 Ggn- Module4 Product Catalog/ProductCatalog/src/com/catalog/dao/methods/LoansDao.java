package com.catalog.dao.methods;

import java.util.List;

import com.catalog.model.Loans;

public interface LoansDao{

	public List<Loans> getAllLoans();
	public void updateLoan(int loanId, String loanType, double interestRate, String description, int maximumDuration);
	public void insertLoan(String loanType, double interestRate, String description, int maximumDuration);
}
