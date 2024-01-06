package com.tanvi.atm.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tanvi.atm.entity.Account;
import com.tanvi.atm.entity.AtmCard;
import com.tanvi.atm.entity.Customer;
import com.tanvi.atm.entity.Transaction;

public class AtmDaoImpl implements AtmDao {
	EntityManager entityManager=MyConnection.getEntityManagerObject();
	EntityTransaction entityTransaction=entityManager.getTransaction();

	@Override
	public String deposit(Account account, Integer depositAmount) {		
		Transaction transaction = new Transaction();
		//Account account= customer.getAccount().get(0);
		entityTransaction.begin();
		account.setBalance(account.getBalance()+depositAmount);
		transaction.setAccount(account);
		transaction.setTransactionDate(LocalDate.now());
		transaction.setTransactionTime(LocalTime.now());
		transaction.setTransactionAmount(depositAmount);
		transaction.setTransactionType("Cr");
		entityManager.persist(transaction);
		entityTransaction.commit();
		return "Deposited";
	}

	@Override
	public String withdrawal(Account account, Integer withdrawalAmount) {
		Transaction transaction = new Transaction();
		//Account account= customer.getAccount().get(0);
		entityTransaction.begin();
		account.setBalance(account.getBalance()-withdrawalAmount);
		transaction.setAccount(account);
		transaction.setTransactionDate(LocalDate.now());
		transaction.setTransactionTime(LocalTime.now());
		transaction.setTransactionAmount(withdrawalAmount);
		transaction.setTransactionType("Dr");
		entityManager.persist(transaction);
		entityTransaction.commit();
		return "Withdrawal";
	}

	@Override
	public String changePin(Account account, String pin2) {
		entityTransaction.begin();
		account.getAtmcard().setCardPin(pin2);
		entityTransaction.commit();
		return "Pin Updated";
	}

	@Override
	public Integer balance(Account account) {
		Integer bal=account.getBalance();
		return bal;
	}

	@Override
	public List<Transaction> miniStatement(Account account) {
		String jpql = "select t from Transaction t where t.account.accountNo=:No ORDER BY t.transactionId DESC";
		Query q = entityManager.createQuery(jpql);
		String accNo=account.getAccountNo();
		q.setParameter("No", accNo);
		q.setMaxResults(10);
		return q.getResultList();
	}

	@Override
	public Integer checkTransactionCount(Account account) {
		LocalDate date = LocalDate.now();
		String jpql = "SELECT COUNT(t) FROM Transaction t WHERE t.account.accountNo = :No AND t.transactionType='Cr' AND t.transactionDate = :date";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("No", account.getAccountNo());
		query.setParameter("date", date);
		Long count = (Long) query.getSingleResult();

		return count.intValue();

	}

	@Override
	public Integer withdrawalTransactionCount(Account account) {
		LocalDate date = LocalDate.now();
		String jpql = "SELECT COUNT(t) FROM Transaction t WHERE t.account.accountNo = :No AND t.transactionType='Dr' AND t.transactionDate = :date";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("No", account.getAccountNo());
		query.setParameter("date", date);
		Long count = (Long) query.getSingleResult();

		return count.intValue();
	}

	@Override
	public List<Transaction> receipt(Account account) {
		String jpql = "select t from Transaction t where t.account.accountNo=:No ORDER BY t.transactionId DESC";
		Query q = entityManager.createQuery(jpql);
		String accNo=account.getAccountNo();
		q.setParameter("No", accNo);
		q.setMaxResults(1);
		return q.getResultList();
	}




}
