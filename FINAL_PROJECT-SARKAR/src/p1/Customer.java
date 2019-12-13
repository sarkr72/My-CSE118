package p1;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class Customer {
	private static final double INTEREST_RATE = 0.012;
	public static String dLine = "----------------------------------";
	public static Scanner input = new Scanner(System.in);
	private String lastName;
	private String firstName;
	private String phone;
	private String accountNumber;
	private double balance;
	private Date dateAccountCreated;
	private String shortDateAccountCreated;

	public Customer(String firstName, String lastName, String phoneNumber, String accountNumber, double balance) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phoneNumber;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.dateAccountCreated = new Date();
		this.shortDateAccountCreated = Utils.dateConverter(dateAccountCreated);
	}
		
	public  double getBalanceWithInterest(double balance, int days) {
		double r = balance * ((INTEREST_RATE / 365) * days);
		balance += r; 
		return balance;
	}
	
	public double getInterest(double balance, int days) {
		double r = balance * ((INTEREST_RATE / 365) * days);
		return r;
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
	
	public String getShortDateAccountCreated() {
		return shortDateAccountCreated;
	}

	public String toString() {
		return (accountNumber + " " + firstName + " " + lastName + " " + phone + " " + balance + " \n" + "dateAccountCreated:"
				+ shortDateAccountCreated);
	}
	
	public Date getDate() {
		return dateAccountCreated;
	}

	public void close() {
		firstName = "not available";
		lastName = "--";
		accountNumber = "--";
		balance = 0;
		phone = "--";
		shortDateAccountCreated = "---";
	}

}