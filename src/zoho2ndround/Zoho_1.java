package zoho2ndround;

import java.util.HashMap;
import java.util.Map;

public class Zoho_1 {
	public static void main(String[] args) {
		System.out.println(isMatching("abba", "dog cat cat dog")); // Output: True
		System.out.println(isMatching("abbf", "dog cat cat fish")); // Output: False
		System.out.println(isMatching("aaaa", "dog cat cat dog")); // Output: False
	}

	public static boolean isMatching(String pattern, String s) {
		String[] words = s.split(" ");

		if (pattern.length() != words.length)
			return false;

		Map<Character, String> map = new HashMap<>();

		for (int i = 0; i < pattern.length(); i++) {
			char currentChar = pattern.charAt(i);
			String currentWord = words[i];

			if (!map.containsKey(currentChar)) {
				if (!map.containsValue(currentWord)) {
					map.put(currentChar, currentWord);
				} else
					return false;
			} else {
				String getWord = map.get(currentChar);
				if (!getWord.equals(currentWord))
					return false;
			}
		}
		return true;
	}
}
