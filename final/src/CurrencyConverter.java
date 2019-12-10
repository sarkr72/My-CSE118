
public class CurrencyConverter {

	private static String single_digits[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
			"nine" };
	private static String[] twoDigits = { "ten", "eleven", "twelve", "thirten", "fourten", "fiften", "sixten",
			"seventen", "eighten", "nineten" };
	private static String[] ten_multiples] = {"twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	
	public static void main(String[] args) {
		System.out.println(convertCurrency(23.12));
//		System.out.println(getWholePart(123.14));
//		System.out.println(getFractionPart(123.14));
	}

	private static String convertDoubleDigits(String wholePart) {
		int amount = Integer.parseInt(wholePart);
		if (amount <= 9) {
			return convertSingleDigit(wholePart);
		}
		if (amount / 20 == 0) {// between 10-19
			return twoDigits[amount % 10];
		}
		
		String onesDigit = wholePart.substring(1);
		String tensDigit = wholePart.substring(0, 1);
		
		if(onesDigit.contentEquals("0")) {
			return ten_multiples[Integer.parseInt(tensDigit)];
		}else {
			return ten_multiples[Integer.parseInt(tensDigit)] + " " + single_digits[Integer.parseInt(onesDigit)];
	}
		return null;
		}

	public static String convertCurrency(double amount) {
		String wholePart = getWholePart(amount);
		String fraction = getFractionPart(amount);
		String wholePartInWords = convertDoubleDigits(wholePart);
		String amountInWords = wholePartInWords + " and " + fraction + "/100";
		return amountInWords;
	}

	private static String convertSingleDigit(String wholePart) {
		int wolePartIntDigit = Integer.parseInt(wholePart);
		return single_digits[wolePartIntDigit];
	}

	private static String getFractionPart(double amount) {
		String amountStr = String.valueOf(amount);
		String[] tokens = amountStr.split("\\.");
		return tokens[1];
	}

	private static String getWholePart(double amount) {
		String amountStr = String.valueOf(amount);
		String[] tokens = amountStr.split("\\.");
		return tokens[0];
	}
}
