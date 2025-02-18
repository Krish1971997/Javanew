package leetcodeZoho6;

public class CheckSwapStrings {
	public boolean buddyStrings(String s, String goal) {
		if (s.length() != goal.length()) {
			return false;
		}

		// If both strings are the same, check if there is at least one duplicate
		// character
		if (s.equals(goal)) {
			int[] freq = new int[26];
			for (char c : s.toCharArray()) {
				freq[c - 'a']++;
				if (freq[c - 'a'] > 1) {
					return true; // Duplicate character found
				}
			}
			return false;
		}

		// Find indices where s and goal differ
		int first = -1, second = -1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != goal.charAt(i)) {
				if (first == -1) {
					first = i;
				} else if (second == -1) {
					second = i;
				} else {
					return false; // More than two differences
				}
			}
		}

		// Check if swapping makes the strings equal
		return second != -1 && s.charAt(first) == goal.charAt(second) && s.charAt(second) == goal.charAt(first);
	}

	public static void main(String[] args) {
		CheckSwapStrings sol = new CheckSwapStrings();

		// Test Cases
		System.out.println(sol.buddyStrings("ab", "ba")); // true
		System.out.println(sol.buddyStrings("ab", "ab")); // false
		System.out.println(sol.buddyStrings("aa", "aa")); // true
		System.out.println(sol.buddyStrings("aaaaaaabc", "aaaaaaacb")); // true
		System.out.println(sol.buddyStrings("abc", "bca")); // false
	}
}
