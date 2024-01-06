package com.tanvi.atm.service;

import java.util.List;

import com.tanvi.atm.entity.Account;
import com.tanvi.atm.entity.AtmCard;
import com.tanvi.atm.entity.Customer;
import com.tanvi.atm.entity.Transaction;

public interface AtmService {
	String deposit(Account account,Integer depositAmount);
	String withdrawal(Account account,Integer withdrawalAmount);
	String changePin(Account account, String pin2);
	Integer balance(Account account);
	List<Transaction> miniStatement(Account account);
	List<Transaction> receipt(Account account);

}
