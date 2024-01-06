package com.tanvi.atm.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
public class Transaction {
	@Id
	@Column(length=18,nullable = false)
	@GenericGenerator(name = "transaction_id_generator", strategy = "com.tanvi.atm.TransactionIdGenerator")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "transaction_id_generator")
	private String transactionId;
	
	@Column(length=15,nullable = false)
	private Integer transactionAmount;
	
	@Column(length=2,nullable = false)
	private String transactionType;
	
	@Column(length=15,nullable = false)
	private LocalDate transactionDate;
	
	@Column(length=15,nullable = false)
	private LocalTime transactionTime;

	@ManyToOne
	@JoinColumn(name="accountNo" ,nullable = false)
	private Account account;

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Integer getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Integer transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public LocalTime getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(LocalTime transactionTime) {
		this.transactionTime = transactionTime;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	
	
	
}
