package com.tanvi.atm.service;

import com.tanvi.atm.entity.Account;
import com.tanvi.atm.entity.Customer;

public interface CustomerService {
	
	Account findCardno(String cardNo);
	String updateCardStatus(Account account);

}
