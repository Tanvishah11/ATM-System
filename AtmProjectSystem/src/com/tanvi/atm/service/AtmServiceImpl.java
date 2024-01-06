package com.tanvi.atm.service;

import java.util.List;

import com.tanvi.atm.dao.AtmDao;
import com.tanvi.atm.dao.AtmDaoImpl;
import com.tanvi.atm.entity.Account;
import com.tanvi.atm.entity.AtmCard;
import com.tanvi.atm.entity.Customer;
import com.tanvi.atm.entity.Transaction;

public class AtmServiceImpl implements AtmService {
	AtmDao atmDao = new AtmDaoImpl();

	@Override
	public String deposit(Account account, Integer depositAmount) {
		Integer count = atmDao.checkTransactionCount(account);
		if(count>=3) {
			return "You can deposit only 3 times per day. ";
		}
		else {
			if(depositAmount>100000) {
				return "Amount should be less than 100000 for deposit.";
			}
			else if(depositAmount<100) {
				return "Amount should be Greater than 100 for deposit";

			}
			else if(depositAmount>0) {
				if(depositAmount%100==0 ||depositAmount%200==0 || depositAmount%500==0){
					atmDao.deposit(account, depositAmount);
					return "Amount Deposited Successfully";
				}
				else {
					return "Amount should be a multiple of 100, 200, or 500.";
				}
			}
			else {
				return "Enter a valid positive amount.";
			}
		}
	}

	@Override
	public String withdrawal(Account account, Integer withdrawalAmount) {
		Integer count = atmDao.withdrawalTransactionCount(account);
		if(count>=5) {
			return "You can withdraw only 5 times per day.";
		}
		else {
			if(withdrawalAmount>account.getBalance()) {
				return "Withdrawal amount exceeds your account balance.";
			}
			else if(withdrawalAmount>10000) {
				return "Amount should be less than 10000 for Withdrawal";

			}
			else if(withdrawalAmount<100) {
				return "Amount should be Greater than 100 for Withdrawal";

			}
			else if(withdrawalAmount>0 || withdrawalAmount<100) {
				if(withdrawalAmount%100==0 ||withdrawalAmount%200==0 || withdrawalAmount%500==0){
					atmDao.withdrawal(account, withdrawalAmount);
					return "Amount Withdrawal Successfully";
				}
				else {
					return "Amount should be a multiple of 100, 200, or 500.";
				}
			}
			else {
				return "Amount should be less than or equal to 100000 and more than 0 for withdrawal.";
			}
		}
	}

	@Override
	public String changePin(Account account, String pin2) {
		atmDao.changePin(account, pin2);
		return "Pin Updated Successfully";
	}

	@Override
	public Integer balance(Account account) {
		Integer bal =atmDao.balance(account);
		return bal;
	}

	@Override
	public List<Transaction> miniStatement(Account account) {

		return atmDao.miniStatement(account);
	}

	@Override
	public List<Transaction> receipt(Account account) {
		
		return atmDao.receipt(account);
	}


}
