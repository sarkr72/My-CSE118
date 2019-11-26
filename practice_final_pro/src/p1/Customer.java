package p1;

import java.util.Scanner;

public class Customer {
 public static Scanner input = new Scanner(System.in);
	static String lastName;
	static String firstName;
	String phone;
	static String accountNumber;
	double balance;
	
	public Customer(String firstName, String lastName, String phoneNumber, String accountNumber, double balance) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phoneNumber;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	
	
	public static String getFirstName() {
		return firstName;
	}
	
	public static String getLastName() {
		return lastName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public static String getAccountNumber() {
		return accountNumber;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public String toString() {
		return (accountNumber + " " + firstName + " " + lastName + " " + phone + " " + balance);
	}
	
}
