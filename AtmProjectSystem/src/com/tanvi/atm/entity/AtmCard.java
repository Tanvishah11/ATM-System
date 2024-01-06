package com.tanvi.atm.entity;


import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class AtmCard {

	@Id
	@Column(length=16, nullable = false)
	private String cardNo;
	
	@Column(length=15, nullable = false)
	private LocalDate issueDate;
	
	@Column(length=15, nullable = false)
	private LocalDate expiryDate;
	
	@Column(length=3, nullable = false)
	private String cvvNo;
	
	@Column(length=4, nullable = false)
	private String cardPin;
	
	@Column(length=15, nullable = false)
	private String cardType;
	
	@Column(length=8, nullable = false)
	private String cardStatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "accountNo",nullable = false)
	private Account account ;

	
	
	
	
	
	
	
	
	
	
	
	
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCvvNo() {
		return cvvNo;
	}

	public void setCvvNo(String cvvNo) {
		this.cvvNo = cvvNo;
	}

	public String getCardPin() {
		return cardPin;
	}

	public void setCardPin(String cardPin) {
		this.cardPin = cardPin;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardStatus() {
		return cardStatus;
	}

	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}
/*
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	*/
	
	
}
