package geeksforgeeksZoho;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCombinations {

	public static List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		if (digits == null || digits.length() == 0) {
			return result;
		}
		String[] mapping = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		Queue<String> queue = new LinkedList<String>();
		queue.add("");

		for (int i = 0; i < digits.length(); i++) {
			int digit = digits.charAt(i) - '0';
			while (queue.peek().length() == i) {
				String current = queue.poll();
				for (char c : mapping[digit].toCharArray())
					queue.add(current + c);
			}
		}
		result.addAll(queue);
		return result;
	}

	public static void main(String[] args) {
		String digits = "23";
		List<String> combinations = letterCombinations(digits);
		System.out.println("Letter Combinations: " + combinations);
	}
}