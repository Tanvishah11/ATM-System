package com.tanvi.atm.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
public class Customer {
	@Id
	@Column(length=15, nullable = false)
	private Integer customerId;
	
	@Column(length=15, nullable = false)
	private String customerName;
	
	@Column(length=15, nullable = false)
	private String dateOfBirth;
	
	@Column(length=1, nullable = false)
	private Character gender;
	
	@Column(length=30)
	private String emailId;
	
	@Column(length=10, nullable = false)
	private String cutomerContact;
	
	@Column(length=15, nullable = false)
	private String address;
	
	@Column(length=12, nullable = false,unique = true)
	private String addharNumber;
	
	@Column(length=10, nullable = false,unique=true)
	private String panNumber;
	
	@ManyToOne
	@JoinColumn(name="ifscode",nullable = false)
	private Bank bank;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	private List<Account> account;

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCutomerContact() {
		return cutomerContact;
	}

	public void setCutomerContact(String cutomerContact) {
		this.cutomerContact = cutomerContact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddharNumber() {
		return addharNumber;
	}

	public void setAddharNumber(String addharNumber) {
		this.addharNumber = addharNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}
/*
	public List<AtmCard> getAtmcard() {
		return atmcard;
	}

	public void setAtmcard(List<AtmCard> atmcard) {
		this.atmcard = atmcard;
	}*/

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return  customerName;
	}
	


}
