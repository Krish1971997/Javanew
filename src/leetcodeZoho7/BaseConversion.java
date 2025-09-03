package leetcodeZoho7;

public class BaseConversion {

	public static String toBase(int number, int base) {
		if (number == 0)
			return "0";

		StringBuilder result = new StringBuilder();

		while (number > 0) {
			int remainder = number % base; //13%3  111
			result.append(remainder);
			number /= base; //41
		}

		// Reverse because we collected digits in reverse order
		return result.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.print("Enter number: ");
		int number = 13;
		System.out.print("Enter base: ");
		int base = 3;

		// Conversion
		String result = toBase(number, base);
		System.out.println("Output: " + result);

	}
}
