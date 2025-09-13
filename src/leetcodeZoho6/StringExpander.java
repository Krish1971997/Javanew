package leetcodeZoho6;

/**
Expand the given string - The input string contains string (s) followed by (n} denotes s repeating n times
Example:
Input: a(b(c){2}){2}d
Output: abccbccd

Input:((x){3}(y){2}z){2}
Output: xxxyyzxxxyyz
 */

public class StringExpander {
	public static String expandString(String input) {
		StringBuilder result = new StringBuilder();
		int i = 0;

		while (i < input.length()) {
			if (i + 1 < input.length() && input.charAt(i) == '(') {
				int start = i;
				int count = 0;
				i++; // Move past '('

				// Find the matching closing parenthesis
				while (i < input.length()) {
					if (input.charAt(i) == '(')
						count++;
					else if (input.charAt(i) == ')') {
						count--;
						if (count == -1)
							break;
					}
					i++;
				}
				String inner = input.substring(start + 1, i);
				i++; // Move past ')'

				// Find the repetition number
				int numStart = i + 1;
				while (i < input.length() && input.charAt(i) != '}')
					i++;
				int repeat = Integer.parseInt(input.substring(numStart, i));
				i++; // Move past '}'

				// Recursively expand the inner string and repeat
				String expandedInner = expandString(inner);
				for (int j = 0; j < repeat; j++) {
					result.append(expandedInner);
				}
			} else {
				result.append(input.charAt(i));
				i++;
			}
		}

		return result.toString();
	}

	public static void main(String[] args) {
		String[] tests = { "a(b(c){2}){2}d", "((x){3}(y){2}z){2}" };
		for (String test : tests) {
			System.out.println("Input: " + test);
			System.out.println("Output: " + expandString(test));
		}
	}
}