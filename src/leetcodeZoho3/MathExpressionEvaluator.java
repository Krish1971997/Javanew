package leetcodeZoho3;

import java.util.Stack;

public class MathExpressionEvaluator {
	public static void main(String[] args) {
		//String expression1 = "10-4*5";
		String expression2 = "3.5 + 2.8 * ( 4 - 1.2 ) / 2";

		//System.out.println(evaluate(expression1)); // Output: -10.0
		System.out.println(evaluate(expression2)); // Output: 7.42
	}

	public static double evaluate(String expression) {
		Stack<Double> numbers = new Stack<>();
		Stack<Character> operations = new Stack<>();
		int len = expression.length();

		for (int i = 0; i < len; i++) {
			char ch = expression.charAt(i);

			// Skip spaces
			if (Character.isWhitespace(ch)) {
				continue;
			}

			// If current char is a digit or '.', extract the number (including decimals)
			if (Character.isDigit(ch) || ch == '.') {
				StringBuilder sb = new StringBuilder();
				while (i < len && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
					sb.append(expression.charAt(i++));
				}
				numbers.push(Double.parseDouble(sb.toString()));
				i--; // to correct for the next iteration
			} else if (ch == '(') {
				operations.push(ch);
			} else if (ch == ')') {
				while (operations.peek() != '(') {
					numbers.push(performOperation(operations.pop(), numbers.pop(), numbers.pop()));
				}
				operations.pop(); // remove '('
			} else if (isOperator(ch)) {
				while (!operations.isEmpty() && precedence(ch) <= precedence(operations.peek())) {
					numbers.push(performOperation(operations.pop(), numbers.pop(), numbers.pop()));
				}
				operations.push(ch);
			}
		}

		while (!operations.isEmpty()) {
			numbers.push(performOperation(operations.pop(), numbers.pop(), numbers.pop()));
		}

		return numbers.pop();
	}

	private static boolean isOperator(char ch) {
		return ch == '+' || ch == '-' || ch == '*' || ch == '/';
	}

	private static int precedence(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		default:
			return -1;
		}
	}

	private static double performOperation(char operation, double b, double a) {
		switch (operation) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if (b == 0) {
				throw new ArithmeticException("Cannot divide by zero");
			}
			return a / b;
		default:
			return 0;
		}
	}
}
