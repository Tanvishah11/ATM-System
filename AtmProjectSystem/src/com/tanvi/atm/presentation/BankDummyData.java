package com.tanvi.atm.presentation;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tanvi.atm.dao.MyConnection;
import com.tanvi.atm.entity.Account;
import com.tanvi.atm.entity.AtmCard;
import com.tanvi.atm.entity.Bank;
import com.tanvi.atm.entity.Customer;

public class BankDummyData {

	public static void main(String[] args) 
	{
		Bank bank1= new Bank();
		Bank bank2= new Bank();

		Customer c1 = new Customer();
		Customer c2 = new Customer();
		Customer c3 = new Customer();
		Customer c4= new Customer();

		AtmCard atmCard1 = new AtmCard();
		AtmCard atmCard2 = new AtmCard();
		AtmCard atmCard3 = new AtmCard();
		AtmCard atmCard4 = new AtmCard();

		Account account1 = new Account();
		Account account2 = new Account();
		Account account3 = new Account();
		Account account4 = new Account();

		List<AtmCard> listCard1=List.of(atmCard1,atmCard2);
		List<AtmCard> listCard2=List.of(atmCard3,atmCard4);

		List<Account> listAccount1=List.of(account1,account2);
		List<Account> listAccount2=List.of(account3,account4);

		List<Customer> cust=List.of(c1);
		List<Customer> cust1=List.of(c2);

		bank1.setIfscode("HDFC0003335");
		bank1.setBankName("HDFC");
		bank1.setBranchCode("3335");
		bank1.setCustomer(cust);

		bank2.setIfscode("SBIN0021225");
		bank2.setBankName("SBI");
		bank2.setBranchCode("21225");
		bank2.setCustomer(cust1);

		c1.setCustomerId(197337079);
		c1.setCustomerName("Tanvi");
		c1.setDateOfBirth("11/10/2000");
		c1.setGender('F');
		c1.setEmailId("tanvishah1317@gmail.com");
		c1.setCutomerContact("9067718645");
		c1.setAddress("Chopda");
		c1.setAddharNumber("245994924475");
		c1.setPanNumber("OZHPS5747C");
		c1.setAccount(listAccount1);
		c1.setBank(bank1);
		//c1.setAtmcard(listCard1);

		c2.setCustomerId(217733246);
		c2.setCustomerName("Nilam");
		c2.setDateOfBirth("10/10/2002");
		c2.setGender('F');
		c2.setEmailId("nilam@gmail.com");
		c2.setCutomerContact("9087654356");
		c2.setAddress("savantwadi");
		c2.setAddharNumber("345974922254");
		c2.setPanNumber("NTHPS5849S");
		c2.setAccount(listAccount2);
		c2.setBank(bank2);
		//c2.setAtmcard(listCard2);

		/*c3.setCustomerId(11223388);
			c3.setCustomerName("nilam");
			c3.setDateOfBirth("11/12/2002");
			c3.setGender('F');
			c3.setEmailId("nilam@gmail.com");
			c3.setCutomerContact("9098909999");
			c3.setAddress("mumbai");
			c3.setAddharNumber("111111111111");
			c3.setPanNumber("1111111111");
			c3.setAccount(listAccount1);
			c3.setBank(bank2);
			//c3.setAtmcard(listCard1);

			c4.setCustomerId(1112222222);
			c4.setCustomerName("xyz");
			c4.setDateOfBirth("10/10/2023");
			c4.setGender('F');
			c4.setEmailId("xyz@gmail.com");
			c4.setCutomerContact("9087654356");
			c4.setAddress("savantwadi");
			c4.setAddharNumber("222222222222");
			c4.setPanNumber("222EW22222");
			c4.setAccount(listAccount2);
			c4.setBank(bank2);
			//c4.setAtmcard(listCard2);*/
		account1.setAccountNo("50100526132812");
		account1.setAccountOpenningDate(LocalDate.now());
		account1.setAccountStatus("Active");
		account1.setAccountType("Saving");
		account1.setBalance(15000);
		account1.setCustomer(c1);
		account1.setAtmcard(atmCard1);
		account1.setTransaction(null);

		account2.setAccountNo("50100526132822");
		account2.setAccountOpenningDate(LocalDate.now());
		account2.setAccountStatus("Active");
		account2.setAccountType("Current");
		account2.setBalance(17000);
		account2.setCustomer(c1);
		account2.setAtmcard(atmCard2);
		account2.setTransaction(null);

		account3.setAccountNo("62353960795");
		account3.setAccountOpenningDate(LocalDate.now());
		account3.setAccountStatus("Active");
		account3.setAccountType("Saving");
		account3.setBalance(10000);
		account3.setCustomer(c2);
		account3.setAtmcard(atmCard3);
		account3.setTransaction(null);

		account4.setAccountNo("62353960685");
		account4.setAccountOpenningDate(LocalDate.now());
		account4.setAccountStatus("Active");
		account4.setAccountType("Current");
		account4.setBalance(12000);
		account4.setCustomer(c2);
		account4.setAtmcard(atmCard4);
		account4.setTransaction(null);

		atmCard1.setCardNo("4592000214197135");
		atmCard1.setCardPin("2345");
		atmCard1.setIssueDate(LocalDate.now());
		atmCard1.setExpiryDate(LocalDate.of(2025,11,21));
		atmCard1.setCvvNo("891");
		atmCard1.setCardType("Atm card");
		atmCard1.setCardStatus("Active");
		atmCard1.setAccount(account1);
		//atmCard1.setCustomer(c1);

		atmCard2.setCardNo("3592230214186431");
		atmCard2.setCardPin("5678");
		atmCard2.setIssueDate(LocalDate.now());
		atmCard2.setExpiryDate(LocalDate.of(2025,11,21));
		atmCard2.setCvvNo("457");
		atmCard2.setCardType("Debit card");
		atmCard2.setCardStatus("Active");
		atmCard2.setAccount(account2);
		//atmCard2.setCustomer(c2);

		atmCard3.setCardNo("5672781214100178");
		atmCard3.setCardPin("1479");
		atmCard3.setIssueDate(LocalDate.now());
		atmCard3.setExpiryDate(LocalDate.of(2025,11,21));
		atmCard3.setCvvNo("856");
		atmCard3.setCardType("Atm card");
		atmCard3.setCardStatus("Active");
		atmCard3.setAccount(account3);
		//atmCard3.setCustomer(c1);

		atmCard4.setCardNo("3789102004197567");
		atmCard4.setCardPin("2580");
		atmCard4.setIssueDate(LocalDate.now());
		atmCard4.setExpiryDate(LocalDate.of(2025,11,21));
		atmCard4.setCvvNo("647");
		atmCard4.setCardType("Debit card");
		atmCard4.setCardStatus("Active");
		atmCard4.setAccount(account4);
		//atmCard4.setCustomer(c2);



		EntityManager entityManager = MyConnection.getEntityManagerObject();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(bank1);
		entityManager.persist(bank2);

		entityTransaction.commit();
		System.out.println("data added");
	}

}


