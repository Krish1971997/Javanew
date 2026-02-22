package leetcodeZoho8;

public class CollapsedPalindrome {

	// Collapse consecutive duplicates
	public static String collapse(String str) {
		if (str.length() == 0)
			return "";

		StringBuilder sb = new StringBuilder();
		sb.append(str.charAt(0));

		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) != str.charAt(i - 1)) {
				sb.append(str.charAt(i));
			}
		}

		return sb.toString();
	}

	// Check palindrome
	public static boolean isPalindrome(String str) {
		int left = 0;
		int right = str.length() - 1;

		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public static void main(String[] args) {
		String input = "aabccbaa";

		String collapsed = collapse(input);
		System.out.println(collapsed);

		if (isPalindrome(collapsed)) {
			System.out.println("Collapsed Palindrome");
		} else {
			System.out.println("Not a Collapsed Palindrome");
		}
	}
}