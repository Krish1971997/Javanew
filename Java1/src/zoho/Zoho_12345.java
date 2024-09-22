package zoho;


import java.util.Stack;

/*
 * https://www.geeksforgeeks.org/zoho-interview-experience-off-campus-january-2021/
 Input: "12345*+-+"
Result: 6 [Explanation: 1 * 2 + 3 - 4 + 5 = 6]
Input: "374291--*+-"
Result: -4 [Explanation: 3 - 7 - 4 * 2 + 9 - 1 = -4]
 */

public class Zoho_12345 {
	public static void main(String[] args) {
		//String s = "374291--*+-";
		//String s="12345*+-+";
		String s="23+3*4+/3-2";
		//String s = "231*+9-";
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				stack.push(s.charAt(i) - '0');
				
			} else if(stack.size()>1){
				int num1 = stack.pop();
				int num2 = stack.pop();

				switch (s.charAt(i)) {
				case '+': {
					stack.push(num1 + num2);
					break;
				}
				case '-': {
					stack.push(num1 - num2);
					break;
				}
				case '*': {
					stack.push(num1 * num2);
					break;
				}
				case '/': {
					stack.push(num1 / num2);
					break;
				}
				}
			}

		}
			
		if (stack.size() == 1) {
			int result = stack.pop();
			System.out.println("Result: " + result);
		} else {
			System.out.println("Invalid expression");
		}
	}

}	
		
		/*int arr[] = new int[s.length() / 2 + 1];
		int j = 0, sum = 0,  x = 1, y = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				arr[j++] = Character.getNumericValue(s.charAt(i));
			} else
				sp += (s.charAt(i));
		}
		sum = arr[0];
		for (int i = 0; i < sp.length(); i++) {
			sum = calculation(sum, arr[x++], sp.charAt(y++));
		}
		System.out.println("Sum ---> "+sum);
	}

	public static int calculation(int summ, int arr, char c) {
		int sum=0;
		switch (c) {
		case '+': sum=summ+arr; return sum;
		case '-': sum=summ-arr; return sum;
		case '*': sum=summ*arr; return sum;
		case '/': sum=summ/arr; return sum;
		default:
			throw new IllegalArgumentException("Unexpected value: " + c);
		} */
		
