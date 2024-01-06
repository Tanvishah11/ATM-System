

package com.tanvi.atm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.tanvi.atm.entity.Account;
import com.tanvi.atm.entity.AtmCard;
import com.tanvi.atm.entity.Customer;

public class CustomerDaoImpl implements CustomerDao {

	EntityManager entityManager=MyConnection.getEntityManagerObject();
	EntityTransaction entityTransaction=entityManager.getTransaction();

	@Override
	public Account findCardno(String cardNo) {
		Customer cust=null;
		Account account1=null;
		String jpql = "select a from Account a";
		Query query =entityManager.createQuery(jpql);
		List<Account> l=query.getResultList();
		for (Account account : l) {
			AtmCard atmCard= account.getAtmcard();
			if(atmCard.getCardNo().equals(cardNo)) {
				account1=atmCard.getAccount();
				//System.out.println(atmCard.getCardNo());
				cust=account1.getCustomer();
				break;
			}
		}
		if(account1!=null) {
			account1 = entityManager.find(Account.class,account1.getAccountNo());
		}
		return account1;
	}
	@Override
	public String updateCardStatus(Account account) {
		entityTransaction.begin();
		account.getAtmcard().setCardStatus("Deactive");;
		entityTransaction.commit();
		return "Card Block";
	}

}
