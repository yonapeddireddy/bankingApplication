package com.hcl.bank.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TransactionDTO {
	private Integer transactionId;
	private long fromAccount;
	private long toAccount;
	private long amount;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	
	@Override
	public String toString() {
		return "TransactionDTO [transactionId=" + transactionId + ", fromAccount=" + fromAccount + ", toAccount="
				+ toAccount + ", amount=" + amount + ", date=" + date + ", type=" + type + "]";
	}

	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public long getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(long fromAccount) {
		this.fromAccount = fromAccount;
	}

	public long getToAccount() {
		return toAccount;
	}

	public void setToAccount(long toAccount) {
		this.toAccount = toAccount;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

}
