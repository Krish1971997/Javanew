package geeksforgeeksZoho;

import java.util.Stack;

public class BalancedParantheses {

	public static boolean isBalanced(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '[' || c == '{' || c == '(') {
				stack.push(c);
			} else if (c == ']' || c == '}' || c == ')') {
				if (stack.isEmpty()) {
					return false; 
				}
				char top = stack.pop();
				if ((c == ']' && top != '[') || (c == '}' && top != '{') || (c == ')' && top != '(')) {
					return false; 
				}
			}
		}
		return stack.isEmpty(); 
	}

	public static void main(String[] args) {
		String s = "[()]{}{[()()]())}";
		// String s = "[(])"; // Not balanced
		if (isBalanced(s)) {
			System.out.println("Balanced");
		} else {
			System.out.println("Not Balanced");
		}
	}

	/**
	 * public static void main(String[] args) { //String s = "[()]{}{[()()]()}";
	 * String s="[(])"; Stack<Character> stack=new Stack<Character>(); for (int i =
	 * 0; i < s.length(); i++) {
	 * if((s.charAt(i)=='[')||(s.charAt(i)=='{')||(s.charAt(i)=='(')){
	 * stack.push(s.charAt(i)); }else
	 * if(!stack.isEmpty()&&s.charAt(i)==')'&&stack.peek()=='(') { stack.pop();
	 * }else if(!stack.isEmpty()&&s.charAt(i)==']'&&stack.peek()=='[') {
	 * stack.pop(); }else if(!stack.isEmpty()&&s.charAt(i)=='}'&&stack.peek()=='{')
	 * { stack.pop(); } }
	 * 
	 * if(stack.isEmpty()) { System.out.println("Balanced"); }else
	 * System.out.println("Not Balanced"); }
	 */
}
