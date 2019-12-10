import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Customer {
	public static void main(String[] args)throws InterruptedException, ParseException{
//			System.out.println(differenceOfDays("12/10/2019", "01/10/2020"));
		Scanner input = new Scanner(System.in);
		String date1 = input.next();
		System.out.println(" when do you want to calculate till: ");
		String date2 = input.next();
		System.out.println("difference of days is: " + differenceOfDays(date1, date2));
		System.out.println("interestEarned is : %.2f", interestEarned);
		//			Date date1 = new Date();
//			long date1Time = date1.getTime();
//			System.out.println(date1.getTime());
//	Thread.sleep(60000);
//	Date date2 = new Date();
//	long date2Time = date2.getTime();
//	long diff = date1Time - date2Time;
//	System.out.println(Math.abs(diff/1000/60));
		
	}
	public static int differenceOfDays(String date1, String date2) throws ParseException{
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	Date myDate1 = dateFormat.parse(date1);
	Date myDate2 = dateFormat.parse(date2);
	long diff = Math.abs((myDate1.getTime() - myDate2.getTime())/(1000*60*60*24));
	return (int)diff;
	}
}
