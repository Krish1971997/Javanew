package zsecondround;

import java.util.Stack;

public class Program4 {

	public static void main(String[] args) {
		//String str = "3(ab)2(c)";
		String str="10(a)";
		System.out.println(findDecodeVersion(str));
	}
 
	private static String findDecodeVersion(String str) {
		Stack<Integer> number = new Stack<>();
		Stack<StringBuilder> currentStr = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int num = 0;

		for (int i = 0; i < str.length(); i++) {
			while(Character.isDigit(str.charAt(i))) {
				num=num*10+str.charAt(i)-'0';
				i++;
			}
			if (str.charAt(i) == '(') {
				number.add(num);
				num = 0;
				currentStr.add(sb);
				sb = new StringBuilder();
			} else if (str.charAt(i) == ')') {
				int repeatCount = number.pop();
				StringBuilder tempString = currentStr.pop();
				for (int j = 0; j < repeatCount; j++)
					tempString.append(sb);
				sb = tempString;
			} else
				sb.append(str.charAt(i));
		}
		return sb.toString();
	}
}
