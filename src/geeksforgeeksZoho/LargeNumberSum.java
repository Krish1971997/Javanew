package geeksforgeeksZoho;

import java.util.Arrays;

public class LargeNumberSum {
	public static String findSum(String str1, String str2) {
		// Make the lengths of both strings equal
		int len1 = str1.length();
		int len2 = str2.length();

		if (len1 < len2) {
			char[] zeros = new char[len2 - len1];
			Arrays.fill(zeros, '0');
			str1 = new String(zeros) + str1;
		} else {
			char[] zeros = new char[len1 - len2];
			Arrays.fill(zeros, '0');
			str2 = new String(zeros) + str2;
		}

		// Initialize variables
		StringBuilder result = new StringBuilder();
		int carry = 0;

		// Iterate over the strings from right to left
		for (int i = str1.length() - 1; i >= 0; i--) {
			int digitSum = Character.getNumericValue(str1.charAt(i)) +
					Character.getNumericValue(str2.charAt(i))
					+ carry;
			//System.out.println("Digitsum - > " + digitSum);
			result.insert(0, digitSum % 10);
			//System.out.println("digitSum % 10 - >" + digitSum % 10);
			carry = digitSum / 10;
			//System.out.println("carry = digitSum / 10 - >" + carry);
			//System.out.println("Sb.tostring -> " + result.toString());
		}

		// Handle the remaining carry
		if (carry > 0) {
			result.insert(0, carry);
		}

		return result.toString();
	}

	public static void main(String[] args) {
		// Test cases
		String str1 = "3333311111111111";
		String str2 = "44422222221119";
		System.out.println(findSum(str1, str2));

		/*
		 * str1 = "7777555511111111"; str2 = "3332222221111";
		 * System.out.println(findSum(str1, str2));
		 */
	}
}
