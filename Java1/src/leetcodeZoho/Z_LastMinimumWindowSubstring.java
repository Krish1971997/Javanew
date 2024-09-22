package leetcodeZoho;

import java.util.HashMap;
import java.util.Map;

//Not touch
public class Z_LastMinimumWindowSubstring {
	public static String minWindowSubstring(String s1, String s2) {
		Map<Character, Integer> targetFreq = new HashMap<>();
		Map<Character, Integer> windowFreq = new HashMap<>();

		// Populate frequency map for s2
		for (char ch : s2.toCharArray()) {
			targetFreq.put(ch, targetFreq.getOrDefault(ch, 0) + 1);
		}

		int left = 0, right = 0;
		int minLen = Integer.MAX_VALUE;
		int minLeft = 0, minRight = 0;

		while (right < s1.length()) {
			char rightChar = s1.charAt(right);
			windowFreq.put(rightChar, windowFreq.getOrDefault(rightChar, 0) + 1);
			right++;

			// Check if current window contains all characters of s2
			if (containsAll(windowFreq, targetFreq)) {
				// Move left pointer to minimize window size
				while (left < right && containsAll(windowFreq, targetFreq)) {
					char leftChar = s1.charAt(left);
					windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);
					if (windowFreq.get(leftChar) == 0) {
						windowFreq.remove(leftChar);
					}
					left++;
				}
				// Update minimum window size if smaller
				int windowSize = right - left + 1;
				if (windowSize < minLen) {
					minLen = windowSize;
					minLeft = left - 1; // Adjust left pointer
					minRight = right; // Adjust right pointer
				}
			}
		}
		return s1.substring(minLeft, minRight);
	}

	private static boolean containsAll(Map<Character, Integer> windowFreq, Map<Character, Integer> targetFreq) {
		for (Map.Entry<Character, Integer> entry : targetFreq.entrySet()) {
			char ch = entry.getKey();
			int targetCount = entry.getValue();
			if (windowFreq.getOrDefault(ch, 0) < targetCount) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String s1 = "this is test string";
		String s2 = "trsi";
		System.out.println(minWindowSubstring(s1, s2)); // Output: " stri"
	}
}