package leetcodeZoho2;

public class LongestPalindromeSubString_optimize {

	public static void main(String[] args) {
		LongestPalindromeSubString_optimize solution = new LongestPalindromeSubString_optimize();

		String s1 = "dababaad";
		System.out.println("Input: " + s1);
		System.out.println("Output: " + solution.longestPalindrome(s1));

		String s2 = "cbbd";
		System.out.println("\nInput: " + s2);
		System.out.println("Output: " + solution.longestPalindrome(s2));
	}

	public String longestPalindrome(String s) {
		for (int length = s.length(); length > 0; length--) {
			for (int start = 0; start <= s.length() - length; start++) {
				if (check(start, start + length, s)) {
					//System.out.println("start ->"+start +" end "+(start+length) );
					return s.substring(start, start + length);
				}
			}
		}

		return "";
	}

	private boolean check(int i, int j, String s) {
		int left = i;
		int right = j - 1;

		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}

			left++;
			right--;
		}

		return true;
	}
}