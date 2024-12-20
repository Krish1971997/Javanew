package leetcodeZoho4;

public class LongestRepeatingCharacterReplacement {

	public static void main(String[] args) {
		String s1 = "ABBA";
		int k1 = 2;
		System.out.println("Longest substring length: " + characterReplacement(s1, k1)); // Output: 4

		String s2 = "ADBD";
		int k2 = 1;
		System.out.println("Longest substring length: " + characterReplacement(s2, k2)); // Output: 3
	}

	public static int characterReplacement(String s, int k) {
		int[] charCount = new int[26]; // Frequency array to track character counts
		int left = 0, maxLength = 0, maxCount = 0;

		// Sliding window approach
		for (int right = 0; right < s.length(); right++) {
			charCount[s.charAt(right) - 'A']++; // Increment the count for the current character
			maxCount = Math.max(maxCount, charCount[s.charAt(right) - 'A']); // Update the maxCount in the window

			// Check if the current window is valid
			while ((right - left + 1) - maxCount > k) {
				// If the window is invalid, shrink the window from the left
				charCount[s.charAt(left) - 'A']--;
				left++; // Move the left pointer to shrink the window
			}

			// Calculate the maximum length of the valid window
			maxLength = Math.max(maxLength, right - left + 1);
		}

		return maxLength;
	}
}
