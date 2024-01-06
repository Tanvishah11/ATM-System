package com.tanvi.atm.service;

import com.tanvi.atm.dao.CustomerDao;
import com.tanvi.atm.dao.CustomerDaoImpl;
import com.tanvi.atm.entity.Account;
import com.tanvi.atm.entity.Customer;

public class CustomerServiceImpl implements CustomerService {
	CustomerDao customerDao=new CustomerDaoImpl();

	@Override
	public Account findCardno(String cardNo) {
		// TODO Auto-generated method stub
		return customerDao.findCardno(cardNo);
	}
	@Override
	public String updateCardStatus(Account account) {

		return customerDao.updateCardStatus(account);
	}


}
