package com.tanvi.atm.presentation;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tanvi.atm.entity.Account;
import com.tanvi.atm.entity.AtmCard;
import com.tanvi.atm.entity.Customer;
import com.tanvi.atm.service.AtmService;
import com.tanvi.atm.service.AtmServiceImpl;
import com.tanvi.atm.service.CustomerService;
import com.tanvi.atm.service.CustomerServiceImpl;
import com.tanvi.atm.validation.MyValidation;

public class Login {

	public static void main(String[] args) {
		//MyValidation myValidation = new MyValidation();
		CustomerService customerService =new CustomerServiceImpl();
		Scanner scanner = new Scanner(System.in);
		boolean flagCard=true;
		boolean flagPin=true;
		while(flagCard) {
			System.out.println("\nEnter 16-digit Card Number: ");
			String cardNo = scanner.next();
			int count =3;
			if(MyValidation.isValidCardNumber(cardNo)) {
				flagCard=false;
				Account account = customerService.findCardno(cardNo);
				//System.out.println(account.getAtmcard().getCardNo());
				//System.out.println(account.getAtmcard().getCardPin());
				String status="Deactive";
				if(account!=null) {
					if(account.getAtmcard().getCardStatus().equals(status)) {
						System.out.println("\nYour Card is Blocked!!");
						System.out.println("Please Contact Your Bank for Assistance.");
						System.exit(0);
					}
					else {
						//if(account!=null) {
						
						while(flagPin) {
							System.out.println("\nEnter 4-digit PIN: ");
							String cardPin = scanner.next();
							if(cardPin.equals(account.getAtmcard().getCardPin()) && MyValidation.isValidPIN(cardPin)) {
								flagPin=false;

								MyApp myApp = new MyApp();
								myApp.displaymenu(account);
							}
							else {
								count--;
								if(count==0) {
									System.out.println("\nToo Many Unsuccessful Attempts. Your Card is Blocked.");
									customerService.updateCardStatus(account);
									System.out.println();
									break;
								}
								else {
									System.out.println("\nIncorrect PIN.");
								}
							}

						}
					}

				}
				else {
					System.out.println("\nCard Not Found. Please Check Your Card Number.");
					System.out.println();
				}


			}
			else {
				System.out.println("\nInvalid Card Number. \nPlease Enter a Valid 16-digit Card Number.");
			}
		}
	}

}
