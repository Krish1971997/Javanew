package leetcodeZoho4;

import java.util.Stack;

public class LongestValidParenthesesStack {
	
	public static int longestValidParentheses(String s) {
		Stack<Character> stack = new Stack<>();
		int count=0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(s.charAt(i));
			}else {
				if(s.charAt(i) == ')' &&!stack.isEmpty() && stack.peek()=='(') {
						count=count+2;
						stack.pop();
				}
			}		
		}
		
		return count;
	}

//	public static int longestValidParentheses(String s) {
//		Stack<Integer> stack = new Stack<>();
//		stack.push(-1); // Initialize stack with base index for valid substring calculation
//		int maxLen = 0;
//
//		for (int i = 0; i < s.length(); i++) {
//			if (s.charAt(i) == '(') {
//				stack.push(i);
//			} else {
//				stack.pop();
//				if (stack.isEmpty()) {
//					stack.push(i);
//				} else {
//					maxLen = Math.max(maxLen, i - stack.peek());
//				}
//			}
//		}
//
//		return maxLen;
//	}

	public static void main(String[] args) {
		String s = ")(()())(";
		System.out.println("Longest valid parentheses length: " + longestValidParentheses(s));
	}
}
