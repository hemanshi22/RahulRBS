package rbs.module.transaction.model;

public class TermDepositTransaction extends Transaction {
	@Override
	public String toString() {
		return "TermDepositTransaction [transactionId=" + transactionId + ", transactionDesc=" + transactionDesc
				+ ", rate=" + rate + ", getTransactionDate()=" + getTransactionDate() + ", getTransactionFrom()="
				+ getTransactionFrom() + ", getTransactionFromType()=" + getTransactionFromType()
				+ ", getTransactionTo()=" + getTransactionTo() + ", getTransactionToType()=" + getTransactionToType()
				+ ", getAmount()=" + getAmount() + ", getAccountType()=" + getAccountType() + "]";
	}
	private double transactionId;
	private String transactionDesc;
	private double rate;
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
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
}
