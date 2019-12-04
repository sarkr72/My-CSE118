package p1;

import java.util.Scanner;

public class Customer {
	public static String dLine = "----------------------------------";
	public static Scanner input = new Scanner(System.in);
	private String lastName;
	private String firstName;
	private String phone;
	private String accountNumber;
	private double balance;

	public Customer(String firstName, String lastName, String phoneNumber, String accountNumber, double balance) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phoneNumber;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public void checkDeposit() {
		System.out.print("Enter the date: ");
		String date = input.next();
		System.out.print("Enter the deposit: ");
		double deposit = input.nextDouble();
		System.out.println(dLine);
		System.out.println( "       Check Deposit");
		System.out.println("Deposit to the account of\nNAME :" + firstName + " " + lastName + "                  CASH");
		System.out.println("DATE :" + date + "\n      TD Bank\nAmerica's most convienent bank        SUBTOTAL :"+ deposit
				+ "\n" + "Account Number *:" + accountNumber + "          $" + deposit);
		balance += deposit;
		System.out.println("balance after deposit: " + balance);
		System.out.println(dLine);
		getReceipt();
		System.out.println("Deposit:\t\t" + deposit);
		System.out.println("Available balance:\t" + balance);
		System.out.println(dLine);
	}

	public void checkWithdraw() {
		System.out.println("WITHDRAW");
		System.out.print("Enter the date: ");
		String date = input.next();
		System.out.print("Enter the withDraw: ");
		double withDraw = input.nextDouble();
		System.out.print("Write out the amount in words:");
		String amount = input.next();
		System.out.print("for?");
		String For = input.next();
		System.out.print("signature: ");
		String signature = input.next();
		System.out.print("Enter the routhing number: ");
		String routing = input.next();
		System.out.println(dLine);
		System.out.println("TD Bank\n\t474 PORTION RD\n\tLAKE RONKONKOMA, NY-11779, USA");
		System.out.println("                                    " + date);
		System.out.println("pay to the\n" + "Order of: " + firstName + " " + lastName + "            $"
				+ withDraw);
		System.out.printf("%-20s%10s\n", amount, "dollars");
		System.out.println("TD BANK\nAmerica's most convienent bank." + "                 for" + For
				+ "        "+signature);
		System.out.print(routing);
		System.out.println("    " + accountNumber);
		balance -= withDraw;
		System.out.println("Balance after withdrawal " + balance);
		System.out.println(dLine);
		getReceipt();
		System.out.println("Withdrawal:\t\t" + withDraw);
		System.out.println("Available balance:\t" + balance);
		System.out.println(dLine);
	}

	public void getReceipt() {
		System.out.println("\tTD Bank\n\t474 PORTION RD\n\tLAKE RONKONKOMA, NY, USA");
		System.out.println(dLine);
		System.out.println("account number:\t\t" + accountNumber + "\n" + "Name:\t\t" + firstName + " " + lastName);
	}

	public void getWithdrawal(double balance) {
		System.out.print("Enter the withdrawal amount: ");
		double withdraw = input.nextDouble();
		if (withdraw > balance || withdraw < 0) {
			System.out.println("Sorry, can't process the transaction");
		} else {
			balance -= withdraw;
			System.out.println("Balance after withdrawal " + balance);
			System.out.println(dLine);
			getReceipt();
			System.out.println("Withdrawal:\t\t" + withdraw);
			System.out.println("Available balance:\t" + balance);
			System.out.println(dLine);
		}
	}

	public void getDeposit(double balance) {
		System.out.print("enter the deposit: ");
		double deposit = input.nextDouble();
		if (deposit <= 0) {
			System.out.println("Sorry, can't process the transaction");
		} else {
			balance += deposit;
			System.out.println("balance after deposit: " + balance);
			System.out.println(dLine);
			getReceipt();
			System.out.println("Deposit:\t\t" + deposit);
			System.out.println("Available balance:\t" + balance);
			System.out.println(dLine);
		}
	}

	public void getInterest(double balance) {
		System.out.println("how many days?");
		int days = input.nextInt();
		double rate = 0.02;
		double r = balance * rate / 365 * days;
		balance += r;
		System.out.println("balance with interest: " + balance);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhone() {
		return phone;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public String toString() {
		return (accountNumber + " " + firstName + " " + lastName + " " + phone + " " + balance);
	}

	public void close() {
		firstName = "closed";
		lastName = "--";
		accountNumber = "--";
		balance = 0;
		phone = "--";
	}

}
