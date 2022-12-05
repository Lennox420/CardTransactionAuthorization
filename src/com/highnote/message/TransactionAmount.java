package com.highnote.message;

public class TransactionAmount {
	public final int length = 10;
	private String transactionAmount;
	
	public String getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	
	public double getDoubleValue() {
		return Double.parseDouble(transactionAmount);
	}
	
	
}
