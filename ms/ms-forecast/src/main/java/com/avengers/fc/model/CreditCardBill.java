package com.avengers.fc.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CreditCardBill implements Data {

	protected String accountHolder;
	protected String cardNumber;
	@JsonFormat(pattern = "yyyy-MM-dd")
	protected Date date;
	protected BigDecimal amount;

	public CreditCardBill() {
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public CreditCardBill setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
		return this;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public CreditCardBill setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
		return this;
	}

	public Date getDate() {
		return date;
	}

	public CreditCardBill setDate(Date date) {
		this.date = date;
		return this;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public CreditCardBill setAmount(BigDecimal amount) {
		this.amount = amount;
		return this;
	}

}
