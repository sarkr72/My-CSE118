
public class CurrencyConverter {

	private static String single_digits[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

	public static void main(String[] args) {
		System.out.println(convertCurrency(3.12));
//		System.out.println(getWholePart(123.14));
//		System.out.println(getFractionPart(123.14));
	}

	public static String convertCurrency(double amount) {
		String wholePart = getWholePart(amount);
		String fraction = getFractionPart(amount);
		String wholePartInWords = convertSingleDigit(wholePart);
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
