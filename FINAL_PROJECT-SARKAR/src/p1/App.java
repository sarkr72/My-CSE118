package p1;

// bring a flash drive//////

import java.text.ParseException;
import java.util.Scanner;
/*
 * Rinku Sarkar
 */
public class App {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws ParseException {
		Utils.mainMenu();
		System.out.println("find your account by number: ");
		System.out.println(Utils.findByAccountNumber(Utils.customers, Utils.customerCounter));	
	}
}
