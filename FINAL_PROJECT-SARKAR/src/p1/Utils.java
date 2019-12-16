package p1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Utils {
	public static Scanner input = new Scanner(System.in);
	public static String dLine = "---------------------------------------------------";
	static Customer[] customers = new Customer[10000];
	public static int customerCounter = 0;

	public static int differenceOfDays(String date1, String date2) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date myDate1 = dateFormat.parse(date1);
		Date myDate2 = dateFormat.parse(date2);
		long diff = Math.abs((myDate1.getTime() - myDate2.getTime()) / (1000 * 60 * 60 * 24));
		return (int) diff;
	}

	public static void mainMenu() throws ParseException{
		System.out.println(dLine);
		System.out.println("          Main menu");
		System.out.println("Welcome to td bank");
		System.out.printf("%-10s%-30s\n", "1.", "Window");
		System.out.printf("%-10s%-30s\n", "2.", "ATM");
		System.out.println(dLine);
		System.out.println("How do you want to do banking today?");
		String response = input.next();
		if(response.equals("2")) {
			System.out.println("Enter the account number:");
			String a = input.next();
			System.out.println("There's no account found with this " + a + " account number.\n go to the window please");
		}
		switchBox("1");
	}

	public static void switchBox(String response) throws ParseException {
			switch (response) {
			case "1":
				menuForWindow();
			case "2":
				menuForAtm();
				break;
			default:
				System.out.println("no such service!");
			}
		}

	public static void menuForWindow() throws ParseException {
		System.out.println(dLine);
		System.out.println("          Main menu");
		System.out.println();
		System.out.printf("%-10s%-30s\n", "1.", "Open Account");
		System.out.printf("%-10s%-30s\n", "2.", "Deposit");
		System.out.printf("%-10s%-30s\n", "3.", "Withdarw");
		System.out.println(dLine);
		System.out.println("How do you want to do banking today?");
		String response = input.next();
		windowSwitchBox(response);
	}

	public static void windowSwitchBox(String response) throws ParseException {
		while (true) {
			switch (response) {
			case "1":
				while (customerCounter < 2) {
					Customer c1 = createAccount();
					customers[customerCounter++] = c1;
				}
				for (int i = 0; i < customerCounter; i++) {
					System.out.println(customers[i]);
				}
				System.out.println();
				break;
			case "2":
				System.out.println("Enter your account number: ");
				String accNum = input.next();
				for (int i = 0; i < customerCounter; i++) {
					if (accNum.matches(customers[i].getAccountNumber())) {
						System.out.println("enter the date you want to count till: mm/dd/yyyy :");
						String date1 = input.next();
						String date2 = customers[i].getShortDateAccountCreated();
						double a = checkDeposit(customers[i].getBalance(),
								 customers[i], customers[i].getInterest(customers[i].getBalance(), differenceOfDays(date1, date2)));
						customers[i].balanceAfterDeposit(a);
					}
				}
				;
				break;
			case "3":
				System.out.println("Enter your account number: ");
				String acNum = input.next();
				for (int i = 0; i < customerCounter; i++) {
					if (acNum.matches(customers[i].getAccountNumber())) {
						System.out.println("enter the date you want to count till: mm/dd/yyyy :");
						String date3 = input.next();
						String date4 = customers[i].getShortDateAccountCreated();
						double b = checkWithdraw(customers[i].getBalance(),
								customers[i].getInterest(customers[i].getBalance(), differenceOfDays(date3, date4)),
								customers[i].getShortDateAccountCreated(), customers[i]);
						customers[i].balanceAfterWithdraw(b);
					}
				}
				;
				break;
			default:
				System.out.println();
			}
			System.out.println("Do you want to see window menu again? n for no");
			String ans = input.next();
			if (ans.contentEquals("n")) {
				break;
			} else {
				menuForWindow();
			}
		}
	}

	public static Customer createAccount() throws ParseException {
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
		String date2 = c.getShortDateAccountCreated();
		System.out.println(c);
		System.out.println("DEPOSIT CHECK:");
		System.out.println("enter the date you want to count till: mm/dd/yyyy :");
		String date1 = input.next();
		double a = checkDeposit(balance, c, c.getInterest(c.getBalance(), differenceOfDays(date1, date2)));
		c.balanceAfterDeposit(a);
		System.out.println();
		return c;
	}

	public static void menuForAtm() throws ParseException {
		System.out.println("Welocme to TD Bank's ATM!");
		System.out.println(dLine);
		while (true) {
			System.out.println("Enter you account number");
			String an = input.next();
			for (int i = 0; i < customerCounter; i++) {
				if (an.equals(customers[i].getAccountNumber())) {
					System.out.println("         Main menu");
					System.out.println();
					System.out.printf("%-10s%-30s\n", "1.", "Open Account");
					System.out.printf("%-10s%-30s\n", "2.", "Check Balance");
					System.out.printf("%-10s%-30s\n", "3.", "Deposit");
					System.out.printf("%-10s%-30s\n", "4.", "Withdraw");
					System.out.printf("%-10s%-30s\n", "5.", "total interest earned");
					System.out.printf("%-10s%-30s\n", "6.", "Delete your Account");
					System.out.printf("%-10s%-30s\n", "7.", "Exit");
					System.out.println(dLine);
					System.out.println("How do you want to do banking today?");
					String ans = input.next();
					switch (ans) {
					case "1":
						System.out.println("We can't make account in the ATM");
						break;
					case "2":
						System.out.print("Balance is: $");
						double c = customers[i].getBalance(); 
						System.out.printf("%10.2f\n", c);
						break;
					case "3":
						System.out.println("enter the date you want to count till: mm/dd/yyyy :");
						String date1 = input.next();
						String date2 = customers[i].getShortDateAccountCreated();
						double a = checkDeposit(customers[i].getBalance(), customers[i],
								customers[i].getInterest(customers[i].getBalance(), differenceOfDays(date1, date2)));
						customers[i].balanceAfterDeposit(a);
						break;
					case "4":
						System.out.println("enter the date you want to count till: mm/dd/yyyy :");
						String date3 = input.next();
						String date4 = customers[i].getShortDateAccountCreated();
						double b = checkWithdraw(customers[i].getBalance(),
								customers[i].getInterest(customers[i].getBalance(), differenceOfDays(date3, date4)),
								customers[i].getShortDateAccountCreated(), customers[i]);
						customers[i].balanceAfterWithdraw(b);
						break;
					case "5":
						System.out.println("enter the date you want to count till: mm/dd/yyyy :");
						String date7 = input.next();
						String date8 = customers[i].getShortDateAccountCreated();
						System.out.println("total interest earned: ");
						System.out.println(
								customers[i].getInterest(customers[i].getBalance(), differenceOfDays(date7, date8)));
						break;
					case "6":
						customers[i].close();
						for (int j = 0; j < customerCounter; j++) {
							System.out.println(customers[j]);
						}
						;
						break;
					case "7":
						System.exit(0);
					default:
						System.out.println("No such thing found!");
					}
				}
			}
			;
			System.out.println();
			System.out.println("do you want to see ATM menu again?'n' for no");
			String res = input.next();
			if (res.equals("n")) {
				break;
			}
		}
	}

	public static Customer findByAccountNumber(Customer[] customerArray, int customerCounter) {
		System.out.println("Enter the account number: ");
		String accountNumber = input.next();
		for (int i = 0; i < customerCounter; i++) {
			if (customerArray[i].getAccountNumber().equals(accountNumber)) {
				return customerArray[i];
			}
		}
		return null;
	}

//	public static void getWithdrawal(double balance, Customer acc, double balanceWithInterest) {
//		System.out.print("Enter the withdrawal amount: ");
//		double withdraw = input.nextDouble();
//		if (withdraw > balance || withdraw < 0) {
//			System.out.println("Sorry, can't process the transaction");
//		} else {
//			balance += balanceWithInterest;
//			balance -= withdraw;
//			System.out.println(dLine);
//			getReceipt(acc);
//			System.out.println("Withdrawal:\t\t" + withdraw);
//			System.out.printf("%-21s%10.2f\n", "Available balance:$", balance);
//			System.out.println(dLine);
//		}
//	}
//
//	public static void getDeposit(double balance, double balanceWithInterest, Customer acc) {
//		System.out.print("enter the deposit: ");
//		double deposit = input.nextDouble();
//		if (deposit <= 0) {
//			System.out.println("Sorry, can't process the transaction");
//		} else {
//			balance += balanceWithInterest;
//			balance += deposit;
//			System.out.println(dLine);
//			getReceipt(acc);
//			System.out.println("Deposit:\t\t" + deposit);
//			System.out.printf("%-21s%10.2f\n", "Available balance:$", balance);
//			System.out.println(dLine);
//		}
//	}

	public static double checkDeposit(double balance, Customer acc, double interest) {
		Scanner input = new Scanner(System.in);
		balance += interest;
		String date = acc.getShortDateAccountCreated();
		System.out.print("Enter check number:");
		String checkNumber = input.next();
		System.out.print("Enter the deposit: ");
		double deposit = input.nextDouble();
		if (deposit <= 0) {
			System.out.println("invalid deposit:");
		} else {
			System.out.println("       Check Deposit");
			System.out.println(dLine);
			System.out.println("| Deposit to the account of                             " + checkNumber + "\n|NAME :"
					+ acc.getFirstName() + " " + acc.getLastName() + "                CASH|");
			System.out.println("| DATE :                         " + date
					+ "\n|      TD Bank\nAmerica's most convienent bank        SUBTOTAL :$" + deposit + "\n"
					+ "| Account Number *:" + acc.getAccountNumber());
			System.out.println("| " + ConvertCurrency.convertCurrency(balance) + "     " + checkNumber);
			balance += deposit;
			getReceipt(acc);
			System.out.println("Deposit:\t\t" + deposit);
			System.out.printf("Available balance:\t $%.2f\n", balance);
			System.out.println(dLine);
			return balance;
		}
		return (Double) null;
	}

	public static double checkWithdraw(double balance, double interest, String dateStr, Customer acc) {
		String halfLine1 = "         |";
		System.out.println("WITHDRAW");
		System.out.print("Enter check number:");
		String checkNumber = input.next();
		System.out.print("Enter the withDraw: ");
		double withDraw = input.nextDouble();
		System.out.print("for?");
		String For = input.next();
		System.out.print("signature: ");
		String signature = input.next();
		System.out.print("Enter the routhing number: ");
		String routing = input.next();
		System.out.println("enter the receiver's name: ");
		String name = input.next();
		if (withDraw <= 0 || withDraw >= balance) {
			System.out.println("invalid withdraw");
		} else {
		System.out.println(dLine + "\n" + "WITHDRAWAL CHECK");
		System.out.println(dLine);
		System.out.printf("%-9s%43s\n%-42s%-10s\n%-42s%-10s\n", "|TD Bank", halfLine1, "|474 PORTION RD", halfLine1,
				"|LAKE RONKONKOMA, NY-11779, USA", halfLine1);
		System.out.printf("%-16s%-10s%-5s%-10s%11s\n", " ", dateStr, " ", checkNumber, halfLine1);
		System.out.printf("%-42s%-10s\n%-10s%-17s%-4s%-10s%11s\n", "|pay to the", halfLine1, "|Order of:", name, "  $",
				withDraw, halfLine1);
		System.out.printf("%-10s%10s\n", "|ConvertCurrency.convertCurrency(balance)", "dollars    |");
		System.out.printf("%-10s%-14s%-10%17s\n", "|TD BANK", "SIGNATURE:", signature, halfLine1);
		System.out.printf("%1s%-10s%-2s%-11s%-2s%-3s%-10s\n", "|", routing, " ", "acc.getAccountNumber()", "   ",
				checkNumber, halfLine1);
		System.out.println(dLine);
		balance -= withDraw;
//		balance += interest;
		getReceipt(acc);
		System.out.println("Withdrawal:\t\t$" + withDraw);
		System.out.printf("%-21s%10.2f", "Available balance:", balance);
		System.out.println();
		System.out.println(dLine);
		return balance;
		}
		return (Double) null;
	}

//	public static String writeCheck(String dateStr, double amount) {
//	String dLine = "---------------------------------------------------------\n";
//	String blankLine = "|                                                        |\n";
//	String halfBlankLine = "|                                 ";
//	String checkFormat = dLine +
//						blankLine +
//						blankLine +
//						halfBlankLine + "Date: %-15s  |\n" +
//						blankLine +
//						halfBlankLine + "Dollar: %-14.2f |\n" +
//						dLine;
//	return String.format(checkFormat, dateStr, amount);
//						
//}

	public static void getReceipt(Customer acc) {
		System.out.println(dLine);
		System.out.println("RECEIPT:");
		System.out.println(dLine);
		System.out.println("\tTD Bank\n\t474 PORTION RD\n\tLAKE RONKONKOMA, NY, USA");
		System.out.println(dLine);
		System.out.println("account number:\t\t" + acc.getAccountNumber() + "\n" + "Name:\t\t" + acc.getFirstName()
				+ " " + acc.getLastName());
	}

	public static String monthConverter(String month) {
		month = month.toLowerCase().substring(0, 3);
		String convertedMonth = "";
		switch (month) {
		case "jan":
			convertedMonth = "01";
			break;
		case "feb":
			convertedMonth = "02";
			break;
		case "mar":
			convertedMonth = "03";
			break;
		case "apr":
			convertedMonth = "04";
			break;
		case "may":
			convertedMonth = "05";
			break;
		case "jun":
			convertedMonth = "06";
			break;
		case "jul":
			convertedMonth = "07";
			break;
		case "aug":
			convertedMonth = "08";
			break;
		case "sep":
			convertedMonth = "09";
			break;
		case "oct":
			convertedMonth = "10";
			break;
		case "nov":
			convertedMonth = "11";
			break;
		case "dec":
			convertedMonth = "12";
			break;

		}
		return convertedMonth;
	}

	public static String dateConverter(Date date) {
		String myDate = date.toString();
		String[] token = myDate.split(" ");
		String myDateString = monthConverter(token[1]) + "/" + token[2] + "/" + token[5];
		return myDateString;
	}

}
