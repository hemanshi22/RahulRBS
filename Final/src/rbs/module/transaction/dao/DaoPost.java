package rbs.module.transaction.dao;

import rbs.module.transaction.model.LoanTransaction;

public interface DaoPost {
	String CreateTransactions(LoanTransaction lt);
	String CreateTransactions(int amount,String type,int account_no, String description,int empid);
	String CreateTransactions(int amount,int account_no, String description,int empid);
}
