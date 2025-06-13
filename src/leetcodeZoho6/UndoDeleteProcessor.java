package leetcodeZoho6;

import java.util.*;
//need learn
public class UndoDeleteProcessor {

	public static void main(String[] args) {
		String[] input = { "a", "#", "*", "a", "b", "#" };
		String output = processString(input);
		System.out.println("Output: " + output); // Expected: a
	}

	public static String processString(String[] operations) {
		StringBuilder result = new StringBuilder();
		Stack<String> deleted = new Stack<>();

		for (String op : operations) {
			if (op.equals("#")) {
				// Delete last character if result is non-empty
				if (result.length() > 0) {
					String last = result.substring(result.length() - 1);
					result.deleteCharAt(result.length() - 1);
					deleted.push(last);
				}
			} else if (op.equals("*")) {
				// Undo last deletion if stack is not empty
				if (!deleted.isEmpty()) {
					result.append(deleted.pop());
				}
			} else {
				// Append lowercase letter
				result.append(op);
			}
		}

		return result.toString();
	}
}
