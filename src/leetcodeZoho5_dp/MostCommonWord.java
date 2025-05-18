package leetcodeZoho5_dp;

import java.util.HashMap;
import java.util.Map;

public class MostCommonWord {
	public static void main(String[] args) {
		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit";
		String[] banned = { "hit" };

		paragraph = toLowerCase(paragraph);
		for (int i = 0; i < banned.length; i++) {
			banned[i] = toLowerCase(banned[i]);
		}

		System.out.println(mostCommonWord(paragraph, banned)); // Output: ball
	}

	public static String mostCommonWord(String paragraph, String[] banned) {
		String[] words = splitWords(paragraph);

		Map<String, Integer> frequencyMap = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			frequencyMap.put(words[i], frequencyMap.getOrDefault(words[i], 0) + 1);
		}

		int maxCount = 0;
		String mostCommon = null;

		for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {

			for (int i = 0; i < banned.length; i++) {
				if (maxCount < entry.getValue() && !entry.getKey().equals(banned[i])) {
					maxCount = entry.getValue();
					mostCommon = entry.getKey();
				}
			}
		}
		return mostCommon;
	}

	private static String[] splitWords(String paragraph) {
		StringBuilder tempWord = new StringBuilder();
		int wordCount = wordsCount(paragraph);
		String[] words = new String[wordCount];
		int wordIndex = 0;

		for (int i = 0; i < paragraph.length(); i++) {
			char c = paragraph.charAt(i);

			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
				tempWord.append(c);
			} else if (tempWord.length() > 0) {
				words[wordIndex++] = tempWord.toString();
				tempWord.setLength(0);
			}
		}

		// Handle the last word if not followed by a space
		if (tempWord.length() > 0) {
			words[wordIndex++] = tempWord.toString();
		}

		return words;
	}

	public static int wordsCount(String paragraph) {
		int count = 0;
		boolean inWord = false;

		for (int i = 0; i < paragraph.length(); i++) {
			char c = paragraph.charAt(i);

			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
				if (!inWord) {
					count++;
					inWord = true;
				}
			} else {
				inWord = false;
			}
		}

		return count;
	}

	// Convert a string to lowercase without using inbuilt functions
	private static String toLowerCase(String str) {
		StringBuilder lowerStr = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (c >= 'A' && c <= 'Z') {
				c = (char) (c + ('a' - 'A'));
			}

			lowerStr.append(c);
		}
		return lowerStr.toString();
	}

}
