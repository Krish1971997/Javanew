package leetcodeZoho6;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		MinimumWindowSubstring solver = new MinimumWindowSubstring();

		String s = "ADOBECODEBANC";
		String t = "ABC";

		String result = solver.minWindow(s, t);
		System.out.println("Minimum window substring is: \"" + result + "\"");
	}

	public String minWindow(String s, String t) {
		if (s == null || t == null || s.length() < t.length())
			return "";

		// Build frequency map for t
		Map<Character, Integer> need = new HashMap<>();
		for (char c : t.toCharArray()) {
			need.put(c, need.getOrDefault(c, 0) + 1);
		}

		Map<Character, Integer> windowCounts = new HashMap<>();
		int required = need.size();
		int formed = 0;

		int left = 0, right = 0;
		int minLen = Integer.MAX_VALUE;
		int minLeft = 0;

		while (right < s.length()) {
			char c = s.charAt(right);
			windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

			if (need.containsKey(c) && windowCounts.get(c).intValue() == need.get(c).intValue()) {
				formed++;
			}

			while (left <= right && formed == required) {
				// Update minimum window
				if (right - left + 1 < minLen) {
					minLen = right - left + 1;
					minLeft = left;
				}

				char leftChar = s.charAt(left);
				windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);
				if (need.containsKey(leftChar)
						&& windowCounts.get(leftChar).intValue() < need.get(leftChar).intValue()) {
					formed--;
				}

				left++;
			}

			right++;
		}

		return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
	}
}
