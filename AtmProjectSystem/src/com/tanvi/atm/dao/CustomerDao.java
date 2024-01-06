package com.tanvi.atm.dao;

import com.tanvi.atm.entity.Account;
import com.tanvi.atm.entity.Customer;

public interface CustomerDao {
	Account findCardno(String cardNo);
	String updateCardStatus(Account account);
}
