package com.tanvi.atm.presentation;

import com.tanvi.atm.entity.Account;
import com.tanvi.atm.entity.Customer;

public interface AtmApp {

	void deposit(Account account);
	void withdrawal(Account account);
	void changePin(Account account);
	void balance(Account account);
	void miniStatement(Account account);
}
