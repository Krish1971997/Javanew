package zoho;

import java.util.Stack;

public class ExpressionEvaluator {

    public static void main(String[] args) {
        String s = "23+3*4+/3-2";  // Test expression
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                // Push the digit as an integer onto the stack
                stack.push(ch - '0');
            } else {
                // Process operators when there are at least two operands in the stack
                if (stack.size() > 1) {
                    int num1 = stack.pop();  // Pop the first operand
                    int num2 = stack.pop();  // Pop the second operand

                    switch (ch) {
                        case '+':
                            stack.push(num2 + num1);  // Add
                            break;
                        case '-':
                            stack.push(num2 - num1);  // Subtract
                            break;
                        case '*':
                            stack.push(num2 * num1);  // Multiply
                            break;
                        case '/':
                            if (num1 != 0) {
                                stack.push(num2 / num1);  // Divide (avoid division by zero)
                            } else {
                                System.out.println("Error: Division by zero.");
                                return;
                            }
                            break;
                        default:
                            System.out.println("Invalid operator encountered: " + ch);
                            return;
                    }
                }
            }
        }

        // At the end, there should be exactly one element in the stack, which is the result
        if (stack.size() == 1) {
            int result = stack.pop();
            System.out.println("Result: " + result);
        } else {
            System.out.println("Invalid expression.");
        }
    }
}
