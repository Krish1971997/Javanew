package leetcodeZoho4;

import java.util.Stack;

public class ExpressionValidator {

	public static boolean isValidExpression(String expression) {
		Stack<Character> stack = new Stack<>();
		char prevChar = '\0'; // Track the previous character

		for (int i = 0; i < expression.length(); i++) {
			char currentChar = expression.charAt(i);

			if (currentChar == '(') {
				stack.push(currentChar);
			} else if (currentChar == ')') {
				if(currentChar==')' && isOperator(prevChar))
					return false;
				
				if (stack.isEmpty()) {
					return false; // Unmatched closing parenthesis
				}
				stack.pop();
			}

			// Check for valid operator and operand placement
			if (isOperator(currentChar)) {
				// Operators shouldn't be the first character or placed after another operator
				// or opening parentheses
				if (i == 0 || isOperator(prevChar) || prevChar == '(') {
					return false;
				}
			}

			// Operators can't be at the end of the expression
			if (isOperator(currentChar) && i == expression.length() - 1) {
				return false;
			}

			// Update previous character
			prevChar = currentChar;
		}

		return stack.isEmpty();
	}

	private static boolean isOperator(char ch) {
		return ch == '+' || ch == '-' || ch == '*' || ch == '/';
	}

	public static void main(String[] args) {
		String[] expressions = { "(a+b)(a*b)", // Valid
				"(ab)(ab+)", // Invalid
				"((a+b)", // Invalid
				"(a+b)(c*d)", // Valid
				"(a+b+)", // Invalid
				
				"a+b*(c-d)" // Valid
		};

		for (String expr : expressions) {
			if (isValidExpression(expr)) {
				System.out.println("Input: " + expr + " -> Output: Valid");
			} else {
				System.out.println("Input: " + expr + " -> Output: Invalid");
			}
		}
	}
}
