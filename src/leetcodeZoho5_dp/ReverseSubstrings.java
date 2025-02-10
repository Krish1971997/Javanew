package leetcodeZoho5_dp;

import java.util.*;

public class ReverseSubstrings {
	public static String reverseParentheses(String str) {
		Stack<Character> stack = new Stack<>();

		for (char ch : str.toCharArray()) {
			if (ch == ')') {
				// Extract substring inside the latest parentheses
				StringBuilder temp = new StringBuilder();
				while (!stack.isEmpty() && stack.peek() != '(') {
					temp.append(stack.pop());
				}
				stack.pop(); // Remove the '(' from the stack

				// Push reversed substring back to the stack
				for (char c : temp.toString().toCharArray()) {
					stack.push(c);
				}
			} else {
				stack.push(ch);
			}
		}

		// Convert stack to string
		StringBuilder result = new StringBuilder();
		while (!stack.isEmpty()) {
			result.append(stack.pop());
		}

		return result.reverse().toString();
	}

	public static void main(String[] args) {
		String str1 = "(skeeg(for)skeeg)";
		String str2 = "((ng)ipm(ca))";

		System.out.println(reverseParentheses(str1)); // Output: geeksforgeeks
		System.out.println(reverseParentheses(str2)); // Output: camping
	}
}
