package geeksforgeeksZoho_1;

import java.util.Stack;
//Not working
public class ExpressionQues {

	    public static void main(String[] args) {
	        String expression1 = "(100+23) + (a*50) * (b*c)";
	        evaluateExpression(expression1);

//	        String expression2 = "(100+23) + ((a*50) + (b*c))";
//	        evaluateExpression(expression2);
	        
	        String expression2 = "10-4*5";
	        evaluateExpression(expression2);

	        String expression3 = "(a+b(c-))";
	        evaluateExpression(expression3);

	        String expression4 = "(a*b(c*d))";
	        evaluateExpression(expression4);
	    }

	    public static void evaluateExpression(String expression) {
	        if (isValid(expression)) {
	            int result = calculateExpression(expression);
	            System.out.println("Valid --> " + result);
	        } else {
	            System.out.println("Invalid");
	        }
	    }

	    public static boolean isValid(String expression) {
	        Stack<Character> stack = new Stack<>();

	        for (char ch : expression.toCharArray()) {
	            if (ch == '(') {
	                stack.push(ch);
	            } else if (ch == ')') {
	                if (stack.isEmpty() || stack.pop() != '(') {
	                    return false;
	                }
	            }
	        }

	        return stack.isEmpty();
	    }

	    public static int calculateExpression(String expression) {
	        char[] chars = expression.toCharArray();
	        int result = 0;
	        int sign = 1;

	        for (int i = 0; i < chars.length; i++) {
	            char ch = chars[i];

	            if (Character.isDigit(ch)) {
	                int num = 0;

	                while (i < chars.length && Character.isDigit(chars[i])) {
	                    num = num * 10 + (chars[i] - '0');
	                    i++;
	                }

	                i--;

	                result += sign * num;
	            } else if (ch == '+') {
	                sign = 1;
	            } else if (ch == '-') {
	                sign = -1;
	            } else if (Character.isLetter(ch)) {
	                int num = ch - 'a' + 1;

	                if (i + 1 < chars.length && Character.isLetter(chars[i + 1])) {
	                    num = num * 10 + (chars[i + 1] - 'a' + 1);
	                    i++;
	                }

	                result += sign * num;
	            }
	        }

	        return result;
	}

}
