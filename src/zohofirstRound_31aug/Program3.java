package zohofirstRound_31aug;

public class Program3 {
	public static void main(String[] args) {
		String input = "45345";
		if (SumOfDigits(input))
			System.out.println("Yes");
		else
			System.out.println("No");

	//	System.out.println(subString(input, 0, 2));
		//System.out.println(subString(input, 3));

	}

	public static boolean SumOfDigits(String input) {
		if (input.length() % 2 == 0)
			return false;

		int length = input.length() / 2;
		int leftSum = calculateSum(subString(input, 0, length));
		int rightSum = calculateSum(subString(input, length + 1));

		if (leftSum == rightSum)
			return true;
		return false;
	}

	private static int calculateSum(String substring) {
		int sum = 0;
		for (int i = 0; i < substring.length(); i++)
			sum += substring.charAt(i) - '0';
		return sum;
	}

	public static String subString(String str, int start) {
		return subString(str, start, str.length());
	}

	public static String subString(String str, int start, int end) {
		StringBuilder sb = new StringBuilder();
		for (int i = start; i < end; i++) {
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
}
