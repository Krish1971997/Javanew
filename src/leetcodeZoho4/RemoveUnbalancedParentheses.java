package leetcodeZoho4;

public class RemoveUnbalancedParentheses {

	public static String removeUnbalancedParentheses(String expr) {
		StringBuilder sb = new StringBuilder();
		int openCount = 0;

		// First pass: Remove excess closing parentheses ')'
		for (int i = 0; i < expr.length(); i++) {
			char ch = expr.charAt(i);
			if (ch == '(') {
				openCount++; // Count the number of open parentheses
			} else if (ch == ')') {
				if (openCount == 0) {
					// Skip this unmatched closing parenthesis
					continue;
				}
				openCount--; // If matched, decrement the open count
			}
			sb.append(ch); // Append valid characters to the StringBuilder
		}

		// Second pass: Remove excess open parentheses '(' from the end
		StringBuilder result = new StringBuilder();
		openCount = 0; // Reset the open parentheses count

		// Traverse from right to left to remove unmatched open parentheses
		for (int i = sb.length() - 1; i >= 0; i--) {
			char ch = sb.charAt(i);
			if (ch == ')') {
				openCount++; // Count the number of close parentheses
			} else if (ch == '(') {
				if (openCount == 0) {
					// Skip this unmatched open parenthesis
					continue;
				}
				openCount--; // If matched, decrement the close count
			}
			result.append(ch); // Append valid characters to the result
		}

		// The result is built in reverse order, so reverse it to correct the order
		return result.reverse().toString();
	}

	public static void main(String[] args) {
		String expr1 = "((abc)((de))";
		String expr2 = "(((ab)";

		System.out.println("Input 1 : " + expr1);
		System.out.println("Output 1: " + removeUnbalancedParentheses(expr1));

		System.out.println("Input 2 : " + expr2);
		System.out.println("Output 2: " + removeUnbalancedParentheses(expr2));
	}
}
