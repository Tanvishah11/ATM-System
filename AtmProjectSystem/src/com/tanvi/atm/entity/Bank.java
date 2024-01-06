package com.tanvi.atm.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
public class Bank {

	@Id
	@Column(length=11, nullable = false)
	private String ifscode;
	
	@Column(length=10,nullable = false)
	private String bankName;
	
	@Column(length=6,nullable=false,unique = true)
	private String branchCode;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "bank")
	private List<Customer> customer;

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//alter table tablename modify columnnamr dataype not null
	
	public String getIfscode() {
		return ifscode;
	}

	public void setIfscode(String ifscode) {
		this.ifscode = ifscode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}
	
	
}
