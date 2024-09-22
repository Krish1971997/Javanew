package leetcodeZoho3;

public class FindKthCharacter {

	public static char findKthCharacter(String encodedString, int k) {
		int currentLength = 0; // Track length of decrypted string
		int i = 0; //a2b2c3

		while (i < encodedString.length()) {
			StringBuilder substring = new StringBuilder();

			while (i < encodedString.length() && Character.isLetter(encodedString.charAt(i))) {
				substring.append(encodedString.charAt(i));
				i++;
			}

			StringBuilder number = new StringBuilder();
			while (i < encodedString.length() && Character.isDigit(encodedString.charAt(i))) {
				number.append(encodedString.charAt(i));
				i++;
			}

			int repeatCount = Integer.parseInt(number.toString()); // Convert number part to integer
			int newLength = currentLength + substring.length() * repeatCount; // Update decrypted string length

			if (k <= newLength) {
				int offset = (k - currentLength - 1) % substring.length();
				return substring.charAt(offset);
			}
			currentLength = newLength;
		}

		throw new IllegalArgumentException("k is out of bounds"); // Handle cases where k is invalid
	}

	public static void main(String[] args) {
		String encodedString1 = "a2b2c3";
		int k1 = 5;
		System.out.println(findKthCharacter(encodedString1, k1)); // Output: c

		String encodedString2 = "ab4c2ed3";
		int k2 = 9;
		System.out.println(findKthCharacter(encodedString2, k2)); // Output: c
	}
}
