package p1;

import java.util.Scanner;

public class App {
	public   static Scanner input = new Scanner(System.in);
	public static String dLine = "----------------------------------";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int x = 5;
//		// class is a data type
//		Customer c1 = new Customer("John", "Doe", "6312029454", "986456841687", 1000.00);
////		System.out.printf("%-8s%8s%12s%10s%10.2f\n", c1.getAccountnumber(),
////													c1.getFirstName(),
////													c1.getLastName(),
////													c1.getPhone(),
////													c1.getBalance());
//		
//		Customer c2 = new Customer("John", "Doe", "6311234567", "46546548847", 100000.00);
////		System.out.printf("%-8s%8s%12s%10s%10.2f\n", c2.getAccountnumber(),
////													c2.getFirstName(),
////													c2.getLastName(),
////													c2.getPhone(),
////													c2.getBalance());
////		
////		System.out.println(c1);
////		System.out.println(c2);
//		// array of data type
//		Customer[] customers = new Customer[5];
//		customers[0] = c1;
//		customers[1] = c2;
//		System.out.println(customers[0]);
//		
		int count = 0;
		Customer[] customers = new Customer[10000];
		while (count < 2) {
			Customer c1 = createAccount();
			customers[count++] = c1;
		}
		System.out.println();
		
		for(int i = 0; i < count; i++) {
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
		getInterest(balance);
		getDeposit(balance);
		getWithdrawal(balance);
		return c;
	}
	
	public static void getReceipt() {
		System.out.println("\tTD Bank\n\t474 PORTION RD\n\tLAKE RONKONKOMA, NY, USA");
		System.out.println(dLine);
		System.out.println("account number:\t\t" + Customer.getAccountNumber() + "\n" + "Name:\t\t" + Customer.getFirstName() 
							+ " " + Customer.getLastName());
	
	}
	
	public static void getWithdrawal(double balance) {
		System.out.print("Enter the withdrawal amount: ");
		double withdraw = input.nextDouble();
		if(withdraw > balance) {
			System.out.println("Sorry, can't process transaction");
		}else {
		balance -= withdraw;
		System.out.println("Balance after withdrawal " + balance);
		System.out.println(dLine);
		getReceipt();
		System.out.println("Withdrawal:\t\t" + withdraw);
		System.out.println("Available balance:\t" + balance);
		System.out.println(dLine);
		}
	}
	public static void getDeposit(double balance) {
		System.out.print("enter the deposit: ");
		double deposit = input.nextDouble();
		if(deposit <= 0) {
			System.out.println("Sorry, can't process transaction");
		}else {
		balance += deposit;
		System.out.println("balance after deposit: " + balance);
		System.out.println(dLine);
		getReceipt();
		System.out.println("Deposit:\t\t" + deposit);
		System.out.println("Available balance:\t" + balance);
		System.out.println(dLine);
		}
	}
	
	public static void getInterest(double balance) {
		double rate = 0.123;
		double r = balance * rate;
		balance += r;
		System.out.println("balance with interest: " + balance);
	}
}
