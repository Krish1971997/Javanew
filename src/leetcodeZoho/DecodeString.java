package leetcodeZoho;

import java.util.Stack;
//https://leetcode.com/problems/decode-string/
public class DecodeString {
	public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]")); // Output: "aaabcbc"
        System.out.println(decodeString("3[a2[c]]")); // Output: "accaccacc"
        System.out.println(decodeString("2[abc]3[cd]ef")); // Output: "abcabccdcdcdef"
    }
	public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> resultStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int count = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                count = count * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(count);
                resultStack.push(currentString);
                currentString = new StringBuilder();
                count = 0;
            } else if (ch == ']') {
                int repeatCount = countStack.pop();
                StringBuilder temp = resultStack.pop();
                for (int i = 0; i < repeatCount; i++) {
                    temp.append(currentString);
                }
                currentString = temp;
            } else {
                currentString.append(ch);
            }
        }
        return currentString.toString();
    }
}



/*public class DecodeString {
	public static void main(String[] args) {
		//String s = "3[a]2[bc]";
		String s = "3[a2[c]]";
		Stack<Integer> numberStack = new Stack<>();
		Stack<String> characterStack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				numberStack.push((int) s.charAt(i) - 48);
			} else if (s.charAt(i) == '[') {
				StringBuilder temp = new StringBuilder();
				while (s.charAt(i) != ']') {
					characterStack.push(String.valueOf(s.charAt(i)));
					i++;
				}
				
				while (characterStack.size()>0&&!characterStack.peek().equals("[")) {
					temp.insert(0, characterStack.pop());
				}
				if(characterStack.size()>0&&characterStack.peek().equals("[")) {
					characterStack.pop();
				}
				
				int num = numberStack.pop();
				for (int j = 0; j < num; j++) {
					sb.append(temp.toString());
				}
				if (sb.length()>0) {
					characterStack.push(sb.toString());
				}

			}
		}
		//System.out.println(temp);
		//System.out.println(numberStack);
		System.out.println("Character Stack: " + sb.toString());
	}
}
*/