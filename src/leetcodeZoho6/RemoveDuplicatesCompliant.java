package leetcodeZoho6;

/** Remove all duplicate characters from the given string while preserving the order.

Constraints:
Do not use any built-in functions.
Perform the operation using in-place memory (do not use an additional variable to store the result).
For alphabets, keep only the first occurrence.
For digits, keep only the last occurrence.

Example:
Input:  a1b2c34c3b2cb3a1d
Output: abc4231d
 */

public class RemoveDuplicatesCompliant {
	public static String removeDuplicates(char[] str) {
		if (str == null || str.length == 0)
			return "";

		boolean[] alphabetSeen = new boolean[26];
		int[] digitLastIndex = new int[10];

		for (int i = 0; i < 10; i++) {
			digitLastIndex[i] = -1;
		}

		for (int i = 0; i < str.length; i++) {
			if (str[i] >= 'a' && str[i] <= 'z') { // Check for alphabet
				int index = str[i] - 'a';
				if (!alphabetSeen[index]) {
					alphabetSeen[index] = true;
				} else {
					str[i] = '#';
				}
			} else if (str[i] >= '0' && str[i] <= '9') { // Check for digit
				int digit = str[i] - '0';
				if (digitLastIndex[digit] != -1) {
					str[digitLastIndex[digit]] = '#';
				}
				digitLastIndex[digit] = i;
			}
		}

		int writeIndex = 0;
		char[] result = new char[str.length];
		for (int i = 0; i < str.length; i++) {
			if (str[i] != '#')
				result[writeIndex++] = str[i];
		}
		return new String(result);
	}

	public static void main(String[] args) {
		String input = "a1b2c34c3b2cb3a1d";
		char[] str = input.toCharArray();
		String result = removeDuplicates(str);
		System.out.println("Input: " + input);
		System.out.println("Output: " + result);
	}
}