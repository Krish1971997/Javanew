package leetcodeZoho4;

import java.util.HashSet;

public class LongestUniqueSubstring {

	public static String longestUniqueSubstring(String s) {
		int left = 0;
		int maxLength = 0;
		int startOfLongest = 0;
		HashSet<Character> uniqueChars = new HashSet<>();

		for (int right = 0; right < s.length(); right++) {
			char currentChar = s.charAt(right);

			while (uniqueChars.contains(currentChar)) {
				uniqueChars.remove(s.charAt(left));
				left++;
			}

			uniqueChars.add(currentChar);

			// Update maximum length and starting index of the longest substring found
			if (right - left + 1 > maxLength) {
				maxLength = right - left + 1;
				startOfLongest = left;
			}
		}

		// Return the substring from startOfLongest with maxLength characters
		return s.substring(startOfLongest, startOfLongest + maxLength);
	}

	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println("Longest substring with unique characters: " + longestUniqueSubstring(s));
	}
}
