package p1;

public class ConvertCurrency {

	private static String single_digits[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
			"nine" };
	private static String[] twoDigits = { "ten", "eleven", "twelve", "thirten", "fourten", "fiften", "sixten",
			"seventen", "eighten", "nineten" };
	private static String[] ten_multiples = { " ", " ", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy",
			"eighty", "ninety" };
	static String[] tens_power = { "hundred", "thousand", "million", "billion" };

	private static String convertTripleDigits(String amountStr) {
		int amount = Integer.parseInt(amountStr);
		String first2Digits = amountStr.substring(1);
		String first2DigitsInWord = convertDoubleDigits(first2Digits);
		String thirdDigitInWord = single_digits[Integer.parseInt(amountStr.substring(0, 1))];
		if (thirdDigitInWord.equals("zero")) {
			thirdDigitInWord = "";
			return first2DigitsInWord;
		}
		return thirdDigitInWord + " " + tens_power[0] + " " + first2DigitsInWord;
	}

	private static String convertDoubleDigits(String wholePart) {
		int amount = Integer.parseInt(wholePart);
		if (amount <= 9) {
			return convertSingleDigit(wholePart);
		}
		if (amount / 20 == 0) {
			return twoDigits[amount % 10];
		}

		String onesDigit = wholePart.substring(1);
		String tensDigit = wholePart.substring(0, 1);

		if (onesDigit.contentEquals("0")) {
			return ten_multiples[Integer.parseInt(tensDigit)];
		} else {
			return ten_multiples[(Integer.parseInt(tensDigit))] + " " + single_digits[Integer.parseInt(onesDigit)];
		}
	}

	public static String convertCurrency(double amount) {
		String wholePart = getWholePart(amount);
		String fraction = getFractionPart(amount);

		String whole = "";
		int len = wholePart.length();
		switch (len) {
		case 1:
			whole = convertSingleDigit(wholePart);
			break;
		case 2:
			whole = convertDoubleDigits(wholePart);
			break;
		case 3:
			whole = convertTripleDigits(wholePart);
			break;
		case 4:
			whole = convertSingleDigit(wholePart.substring(0, 1)) + " " + tens_power[1] + " "
					+ convertTripleDigits(wholePart.substring(1));
			break;
		case 5:
			whole = convertDoubleDigits(wholePart.substring(0, 2)) + " " + tens_power[1] + " "
					+ convertTripleDigits(wholePart.substring(2));
			break;
		case 6:
			whole = convertTripleDigits(wholePart.substring(0, 3)) + " " + tens_power[1] + " "
					+ convertTripleDigits(wholePart.substring(3));
			break;
		case 7:
			whole = convertSingleDigit(wholePart.substring(0, 1)) + " " + tens_power[2] + " "
					+ convertTripleDigits(wholePart.substring(1, 4)) + " " + tens_power[1] + " "
					+ convertTripleDigits(wholePart.substring(5));
		}
		return whole + " and " + fraction + "/100";
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
