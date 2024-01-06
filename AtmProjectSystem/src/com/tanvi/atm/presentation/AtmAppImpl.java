package com.tanvi.atm.presentation;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.tanvi.atm.dao.MyConnection;
import com.tanvi.atm.entity.Account;
import com.tanvi.atm.entity.Customer;
import com.tanvi.atm.entity.Transaction;
import com.tanvi.atm.service.AtmService;
import com.tanvi.atm.service.AtmServiceImpl;
import com.tanvi.atm.validation.MyValidation;

public class AtmAppImpl implements AtmApp {
	Scanner scanner = new Scanner(System.in);
	AtmService atmService= new AtmServiceImpl();
	@Override
	public void deposit(Account account) {
		System.out.println("\n***** Deposit Funds *****");
		System.out.print("Enter the amount to deposit: ");

		try {
			Integer depositAmount = scanner.nextInt();

			String depositResult = atmService.deposit(account, depositAmount);
			System.out.println();
			System.out.println(depositResult);
			System.out.println();
			if(depositResult.equals("Amount Deposited Successfully")){
				System.out.println("\nWant To Print Receipt (y/n):");
				String res=scanner.next();
				if(res.equals("y")) {
					List<Transaction> l = atmService.receipt(account);
					Iterator<Transaction> itr= l.iterator();
					while(itr.hasNext())
					{
						Transaction t = itr.next();
						System.out.println("\n                  ****************************************************");
						System.out.println("                  *                Transaction Receipt                *");
						System.out.println("                  ****************************************************");
						System.out.printf("                   %-20s: %s\n", "Transaction Id", t.getTransactionId());
						System.out.printf("                   %-20s: %s\n", "Account Number", account.getAccountNo());
						System.out.printf("                   %-20s: %s\n", "Transaction Amount", t.getTransactionAmount());
						System.out.printf("                   %-20s: %s\n", "Transaction Type", t.getTransactionType());
						System.out.printf("                   %-20s: %s\n", "Transaction Date", t.getTransactionDate());
						System.out.printf("                   %-20s: %s\n", "Transaction Time", t.getTransactionTime());
						System.out.println();
						System.out.printf("                   %-20s: %s\n", "Available Balance", account.getBalance());
						System.out.println("                  ****************************************************");
						System.out.println();

						
					}
					
				}
				
			}
		} catch (InputMismatchException e) {
			System.out.println("\nInvalid input. Please enter a valid numeric amount.\n");
			scanner.nextLine(); // Consume the invalid input to prevent an infinite loop
		}

	}
	@Override
	public void withdrawal(Account account) {
		System.out.println("\n***** Withdrawal Funds *****");
		System.out.print("Enter the amount to withdraw: ");

		try {
			Integer withdrawalAmount = scanner.nextInt();

			String withdrawalResult = atmService.withdrawal(account, withdrawalAmount);
			System.out.println();
			System.out.println(withdrawalResult);
			System.out.println();
			if(withdrawalResult.equals("Amount Withdrawal Successfully")){
				System.out.println("\nWant To Print Receipt (y/n):");
				String res=scanner.next();
				if(res.equals("y")) {
					List<Transaction> l = atmService.receipt(account);
					Iterator<Transaction> itr= l.iterator();
					while(itr.hasNext())
					{
						Transaction t = itr.next();
						System.out.println("\n                  ****************************************************");
						System.out.println("                  *                Transaction Receipt                *");
						System.out.println("                  ****************************************************");
						System.out.printf("                   %-20s: %s\n", "Transaction Id", t.getTransactionId());
						System.out.printf("                   %-20s: %s\n", "Account Number", account.getAccountNo());
						System.out.printf("                   %-20s: %s\n", "Transaction Amount", t.getTransactionAmount());
						System.out.printf("                   %-20s: %s\n", "Transaction Type", t.getTransactionType());
						System.out.printf("                   %-20s: %s\n", "Transaction Date", t.getTransactionDate());
						System.out.printf("                   %-20s: %s\n", "Transaction Time", t.getTransactionTime());
						System.out.println();
						System.out.printf("                   %-20s: %s\n", "Available Balance", account.getBalance());
						System.out.println("                  ****************************************************");
						System.out.println();
						
					}
					
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("\nInvalid input. Please enter a valid numeric amount.\n");
			scanner.nextLine(); // Consume the invalid input to prevent an infinite loop
		}
	}
	@Override
	public void changePin(Account account) {
		while (true) {
			System.out.println("\n***** Change PIN *****");
			System.out.print("\nEnter New PIN: ");
			String pin1 = scanner.next();

			if (!pin1.equals(account.getAtmcard().getCardPin())) {
				if (MyValidation.isValidPIN(pin1) && MyValidation.hasUniqueDigits(pin1)) {
					System.out.print("\nConfirm New PIN: ");
					String pin2 = scanner.next();

					if (pin1.equals(pin2) && MyValidation.isValidPIN(pin2) && MyValidation.hasUniqueDigits(pin2)) {
						String changePinResult = atmService.changePin(account, pin2);
						System.out.println();
						System.out.println(changePinResult);
						System.out.println();
						break;
					} else {
						System.out.println("\nPINs do not match. Please try again.");
					}
				} else {
					System.out.println("\nInvalid PIN. Please enter a 4-digit PIN with no repeated digits.");
				}
			} else {
				System.out.println("\nNew PIN should not be the same as the old PIN.");
			}
		}

	}
	@Override
	public void balance(Account account) {
		System.out.println("\n***** Account Balance *****");
		Integer accountBalance = atmService.balance(account);

		if (accountBalance != null) {
			System.out.println("\nYour Account Balance: " + accountBalance);
		} else {
			System.out.println("\nUnable to retrieve account balance. Please try again later.\n");
		}
	}
	@Override
	public void miniStatement(Account account) {
		List<Transaction> l = atmService.miniStatement(account);
		if(!l.isEmpty()){
			Iterator<Transaction> itr= l.iterator();
			System.out.println("\n                                                    Mini Statement                                                       ");
			System.out.println("\n       Card Number: "+account.getAtmcard().getCardNo()+"                                            Account Number: "+account.getAccountNo());
			System.out.println("\n-------------------------------------------------------------------------------------------------------------------------");
			System.out.printf("| %-20s | %-25s | %-20s | %-20s | %-20s |\n", "Transaction Id", "Transaction Amount", "Transaction Date", "Transaction Time", "Transaction Type");
			System.out.println("-------------------------------------------------------------------------------------------------------------------------");

			while(itr.hasNext()) {
				Transaction t = itr.next();
				System.out.printf("| %-20s | %-25s | %-20s | %-20s | %-20s |\n", t.getTransactionId(), t.getTransactionAmount(), t.getTransactionDate(), t.getTransactionTime(), t.getTransactionType());
			}
			System.out.println("-------------------------------------------------------------------------------------------------------------------------");
			System.out.println();
		}
		else {
			System.out.println("\nNo Transaction Found\n");
		}
	}



}
