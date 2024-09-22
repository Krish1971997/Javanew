
package geeksforgeeksZoho;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		String s3 = "abbcccbbd";
		System.out.println("Input: " + s3);
		System.out.println("Output: " + lengthOfLongestSubstring(s3));
	}

	public static int lengthOfLongestSubstring(String s) {
		int maxLength = 0, start = 0;
		Map<Character, Integer> charIndexMap = new HashMap<>();
		for (int end = 0; end < s.length(); end++) {
			char currentChar = s.charAt(end);

			if (charIndexMap.containsKey(currentChar)) {
				start = Math.max(start, charIndexMap.get(currentChar) + 1);
			}
			charIndexMap.put(currentChar, end);
			maxLength = Math.max(maxLength, end - start + 1);
		}
		return maxLength;
	}
}
