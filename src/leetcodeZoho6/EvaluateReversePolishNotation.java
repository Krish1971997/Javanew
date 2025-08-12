package leetcodeZoho6;

import java.util.Stack;
//https://leetcode.com/problems/evaluate-reverse-polish-notation/

public class EvaluateReversePolishNotation {
	public static void main(String[] args) {
		String[] tokens1 = { "2", "1", "+", "3", "*" };
		System.out.println(evalRPN(tokens1)); // 9

		String[] tokens2 = { "4", "13", "5", "/", "+" };
		System.out.println(evalRPN(tokens2)); // 6

		String[] tokens3 = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
		System.out.println(evalRPN(tokens3)); // 22
	}

	public static int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (String token : tokens) {
			if (isOperator(token)) {
				int b = stack.pop();
				int a = stack.pop();
				int result = applyOp(a, b, token);
				stack.push(result);
			} else {
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.pop();
	}

	private static boolean isOperator(String token) {
		return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
	}

	private static int applyOp(int a, int b, String op) {
		switch (op) {
		case "+":
			return a + b;
		case "-":
			return a - b;
		case "*":
			return a * b;
		case "/":
			return a / b; // truncate toward zero
		}
		throw new IllegalArgumentException("Invalid operator");
	}
}
