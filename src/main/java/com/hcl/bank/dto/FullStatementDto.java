package com.hcl.bank.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class FullStatementDto {
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fromdate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date todate;
	private Integer transactionId;
	private long fromAccount;
	private long toAccount;
	private long amount;
	private String type;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getTodate() {
		return todate;
	}

	public void setTodate(Date todate) {
		this.todate = todate;
	}

	public Date getFromdate() {
		return fromdate;
	}

	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}

}
