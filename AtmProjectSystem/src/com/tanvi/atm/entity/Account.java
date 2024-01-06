package com.tanvi.atm.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Account {
	@Id
	@Column(length=16, nullable = false)
	private String accountNo;
	
	@Column(length=10, nullable = false)
	private String accountType;
	
	@Column(length=15, nullable = false)
	private LocalDate accountOpenningDate;
	
	@Column(length=8, nullable = false)
	private String accountStatus;
	
	@Column(length=15, nullable = false)
	private Integer balance;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId",nullable = false)
	private Customer customer;
	
	@OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
	private List<Transaction> transaction;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "account")
	private AtmCard atmcard;
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public AtmCard getAtmcard() {
		return atmcard;
	}

	public void setAtmcard(AtmCard atmcard) {
		this.atmcard = atmcard;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public LocalDate getAccountOpenningDate() {
		return accountOpenningDate;
	}

	public void setAccountOpenningDate(LocalDate accountOpenningDate) {
		this.accountOpenningDate = accountOpenningDate;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + "]";
	}
	

}
