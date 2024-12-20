package leetcodeZoho2;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	/**
	 * public static List<String> fullJustify(String[] words, int maxWidth) {
	 * List<String> result = new ArrayList<>(); List<String> cur = new
	 * ArrayList<>(); int numOfLetters = 0;
	 * 
	 * for (String word : words) { if (numOfLetters + word.length() + cur.size() >
	 * maxWidth) { int spacesToAdd = maxWidth - numOfLetters; for (int i = 0; i <
	 * spacesToAdd; i++) { int setint = i % (cur.size() - 1); String setString =
	 * cur.get(setint); cur.set(setint, setString + " "); }
	 * result.add(String.join("", cur)); cur.clear(); numOfLetters = 0; }
	 * cur.add(word); numOfLetters += word.length(); } result.add(String.join(" ",
	 * cur) + " ".repeat(maxWidth - numOfLetters - cur.size() + 1));
	 * 
	 * return result; }
	 */

	public static void main(String[] args) {
		// String[] words = { "This", "is", "an", "example", "of", "text",
		// "justification." };
		String[] words = { "What", "must", "be", "acknowledgment", "shall", "be" };
		int maxWidth = 16;
		List<String> justifiedText = fullJustify(words, maxWidth);

		for (String line : justifiedText) {
			System.out.println("'" + line + "'");
		}
	}

	public static List<String> fullJustify(String[] words, int maxWidth) {
		List<String> result = new ArrayList<>();
		List<String> cur = new ArrayList<>();
		int numOfLetters = 0;

		for (String word : words) {
			if (numOfLetters + word.length() + cur.size() > maxWidth) {
				int spacesToAdd = maxWidth - numOfLetters;

				for (int i = 0; i < spacesToAdd; i++) {
					int setIndex = i % (cur.size() > 1 ? (cur.size() - 1) : 1);
					cur.set(setIndex, cur.get(setIndex) + " ");
				}
				result.add(buildLine(cur));
				//result.add(join("", cur));
				
				cur.clear();
				numOfLetters = 0;
			}
			cur.add(word);
			numOfLetters += word.length();
		}
		result.add(buildLastLine(cur, maxWidth));

		return result;
	}

	private static String buildLine(List<String> words) {
		StringBuilder sb = new StringBuilder();
		for (String word : words) {
			sb.append(word);
		}
		return sb.toString();
	}

	private static String buildLastLine(List<String> words, int maxWidth) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < words.size(); i++) {
			sb.append(words.get(i));
			if (i < words.size() - 1) {
				sb.append(" ");
			}
		}
		while (sb.length() < maxWidth) {
			sb.append(" ");
		}
		return sb.toString();
	}
	
	public static String join(String delimiter, List<String> elements) {
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < elements.size(); i++) {
            result.append(elements.get(i));
            if (i < elements.size() - 1) {
                result.append(delimiter);
            }
        }

        return result.toString();
    }
}
