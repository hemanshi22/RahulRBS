package rbs.module.transaction.dao;

import rbs.module.transaction.model.LoanTransaction;
import rbs.module.transaction.model.SavingsTransaction;
import rbs.module.transaction.model.TermDepositTransaction;

public interface DaoPost {
	String CreateTransactions(LoanTransaction lt);
	String CreateTransactions(SavingsTransaction st);
	String CreateTransactions(TermDepositTransaction tdt);
}
