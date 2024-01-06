package com.tanvi.atm.presentation;

import java.util.Scanner;

import com.tanvi.atm.entity.Account;
import com.tanvi.atm.entity.Customer;
import com.tanvi.atm.service.CustomerService;
import com.tanvi.atm.service.CustomerServiceImpl;

public class MyApp {
	public void displaymenu(Account account) {	

		Integer choice = 0;
		Scanner scanner = new Scanner(System.in);
		AtmApp app = new AtmAppImpl();
		while(choice!=6) {
			System.out.println();
			System.out.println("      ***************************************************************");
			System.out.println("                         Well-Come To ATM System                      ");
			System.out.println("      ***************************************************************");
			System.out.println();
			System.out.println("                              Bank: "+account.getCustomer().getBank().getBankName());
			System.out.println("\n  Welcome " +account.getCustomer().getCustomerName()+"                                    Account No:"+account.getAccountNo());
			System.out.println();
			System.out.println("\n1.Deposit                                                      4.Change Pin");
			System.out.println("\n2.Withdrawal                                                   5.Balance");
			System.out.println("\n3.Mini Statement                                               6.Exit");
			//System.out.println("4.Change Pin");
			//System.out.println("5.Balance ");
			//System.out.println("6.Exit ");
			System.out.println();
			System.out.println("Enter the choice: ");
			choice = scanner.nextInt();

			switch(choice)
			{
			case 1:
				app.deposit(account);
				break;
			case 2:
				app.withdrawal(account);
				break;
			case 3:
				app.miniStatement(account);
				break;
			case 4:
				app.changePin(account);;
				break;
			case 5:
				app.balance(account);
				break;
			case 6:
				System.out.println("\nThank You For Using Out Atm Service. ");
				System.out.println("Visit Again. ");
				System.exit(0);
			}

		}

	}


}
