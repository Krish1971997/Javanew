package leetcodeZoho5_dp;

public class ReverseSubstrings {
	public static String reverseParentheses(String s) {
        char[] stack = new char[s.length()];
        int top = -1; // Stack pointer

        for (char c : s.toCharArray()) {
            if (c != ')') {
                stack[++top] = c; 
            } else {
                StringBuilder temp = new StringBuilder();
                
                while (top >= 0 && stack[top] != '(') {
                    temp.append(stack[top--]);
                }
                top--; // Remove '('

                for (char ch : temp.toString().toCharArray()) {
                    stack[++top] = ch;
                }
            }
        }

        // Build final result
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= top; i++) {
            result.append(stack[i]);
        }

        return result.toString();
    }

	public static void main(String[] args) {
		//String str1 = "(skeeg(for)skeeg)";
		String str2 = "(ed(et(oc))el)";

		//System.out.println(reverseParentheses(str1)); // Output: geeksforgeeks
		System.out.println(reverseParentheses(str2)); // Output: camping
	}
}
