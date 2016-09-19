package rbs.module.transaction.model;

public class LoanTransaction extends Transaction {
	private double transactionId;
	private String transactionDesc;
	private int loanId;
	public double getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(double transactionId) {
		this.transactionId = transactionId;
	}
	public String getTransactionDesc() {
		return transactionDesc;
	}
	public void setTransactionDesc(String transactionDesc) {
		this.transactionDesc = transactionDesc;
	}
	public double getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	@Override
	public String toString() {
		return transactionId + ", " + transactionDesc+ ", " + loanId
				+ ", " + getTransactionDate() + ", " + getTransactionFrom()
				+ ", " + getTransactionFromType() + ", "
				+ getTransactionTo() + ", " + getTransactionToType() + ", "
				+ getAmount() + ", " + getAccountType() + "\n";
	}
	
}
