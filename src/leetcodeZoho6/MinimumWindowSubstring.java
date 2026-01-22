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

	public String minWindow(String str, String target) {
		if (str == null || target == null || str.length() < target.length())
			return "";

		// Build frequency map for t
		Map<Character, Integer> need = new HashMap<>();
		for (char c : target.toCharArray()) {
			need.put(c, need.getOrDefault(c, 0) + 1);
		}

		Map<Character, Integer> windowCounts = new HashMap<>();
		int required = need.size();
		int formed = 0;

		int left = 0, right = 0;
		int minLen = Integer.MAX_VALUE;
		int minLeft = 0;

		while (right < str.length()) {
			char c = str.charAt(right);
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

				char leftChar = str.charAt(left);
				windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);
				if (need.containsKey(leftChar)
						&& windowCounts.get(leftChar).intValue() < need.get(leftChar).intValue()) {
					formed--;
				}

				left++;
			}

			right++;
		}

		return minLen == Integer.MAX_VALUE ? "" : str.substring(minLeft, minLeft + minLen);
	}
}
