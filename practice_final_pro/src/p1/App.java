package p1;

import java.util.Scanner;

public class App {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x = 5;
		// class is a data type
		Customer c1 = new Customer("John", "Doe", "6312029454", "986456841687", 1000.00);
		System.out.printf("%-8s%8s%12s%6s%10.2f\n", c1.getAccountNumber(),
													c1.getFirstName(),
													c1.getLastName(),
													c1.getPhone(),
													c1.getBalance());

		Customer c2 = new Customer("cena", "Doe", "6311234567", "46546548847", 100000.00);
		System.out.printf("%-8s%8s%12s%10s%10.2f\n", c2.getAccountNumber(),
													c2.getFirstName(),
													c2.getLastName(),
													c2.getPhone(),
													c2.getBalance());
		
//		System.out.println(c1);
//		System.out.println(c2);
//		// array of data type
//		Customer[] customers = new Customer[5];
//		customers[0] = c1;
//		customers[1] = c2;
//		System.out.println(customers[0]);

		int count = 0;
		Customer[] customers = new Customer[10000];
		while (count < 3) {
			Customer c3 = createAccount();
			customers[count++] = c3;
		}
		System.out.println();

		for (int i = 0; i < count; i++) {
			System.out.println(customers[i]);
		}

		System.out.println();
		System.out.println("Welcome to TD Bank ATM");
		System.out.println("enter your account Number: ");
		String accNum = input.next();
		
			for (int i = 0; i < count; i++) {
				if (accNum.matches(customers[i].getAccountNumber())) {
					while (true) {
						System.out.println("choose one:");
					showMenu();
					int n = input.nextInt();
					if (n == 1) {
						System.out.println("balance is: " + customers[i].getBalance());
					} else if (n == 2) {
						customers[i].getDeposit(customers[i].getBalance());	
					} else if (n == 3) {
						customers[i].getWithdrawal(customers[i].getBalance());
					} else if (n == 4) {
						break;
					}
				}
			}
		}
			
		System.out.println("Which account do you want to delete?\n'0' for 1st, '1' for 2nd, '2' for 3rd  so on.... :");
		int delete = input.nextInt();
		customers[delete].close();

		for (int i = 0; i < count; i++) {
			System.out.println(customers[i]);
		}
	}
	
	public static Customer createAccount() {
		System.out.println("enter first name: ");
		String fName = input.next();
		System.out.println("enter last name: ");
		String lName = input.next();
		System.out.println("enter phone number: ");
		String phone = input.next();
		System.out.println("enter account number: ");
		String accountNumber = input.next();
		System.out.println("enter the initial balance: ");
		double balance = Double.parseDouble(input.next());
		Customer c = new Customer(fName, lName, phone, accountNumber, balance);
		System.out.println(c);
		c.getInterest(balance);
		c.checkDeposit();
		System.out.println();
		c.checkWithdraw();
		return c;
	}
	
	public static void showMenu() {
		System.out.println("Main Menu");
		System.out.println("1.check balance: \n" + "2.deposit \n" + "3.withdraw \n" + "4.exit");
	}

}
