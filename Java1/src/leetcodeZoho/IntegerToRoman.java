package leetcodeZoho;

public class IntegerToRoman {
	private static final int[] VALUES = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
	private static final String[] SYMBOLS = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

	public static String intToRoman(int num) {
		StringBuilder roman = new StringBuilder();

		for (int i = 0; i < VALUES.length && num > 0; i++) {
			while (num >= VALUES[i]) {
				roman.append(SYMBOLS[i]);
				num -= VALUES[i];
			}
		}
		return roman.toString();
	}

	public static void main(String[] args) {
		int number = 48;
		System.out.println("Integer: " + number + " -> Roman: " + intToRoman(number));
	}
}
