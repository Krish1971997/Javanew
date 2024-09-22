package leetcodeZoho2;

import java.util.Scanner;

public class Z13_RemovePalindromes {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		// System.out.println("Enter the input : ");
		// String str = s.nextLine();
		String str = "He did a good deedd";
		// String str = "Malayalam is my mother tongue";

		String result = removePalindrome(str);
		System.out.println(result);

	}

	private static boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;

		while (start < end) {
			if (toLowerCase(s.charAt(start)) != toLowerCase(s.charAt(end)))
				return false;
			start++;
			end--;
		}
		return true;
	}

	private static String removePalindrome(String s) {
		StringBuilder sb = new StringBuilder();
		StringBuilder res = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == ' ' && sb.length() > 0) {
				if (!isPalindrome(sb.toString()))
					res.append(sb.toString()).append(" ");
				sb = new StringBuilder();
			} else
				sb.append(ch);
		}
		if (sb.length() > 0) {
			if (!isPalindrome(sb.toString()))
				res.append(sb.toString());
		}
		return res.toString();
	}

	private static char toLowerCase(char ch) {
		if (ch >= 'A' && ch <= 'Z') {
			ch = (char) (ch + 32);
			return ch;
		}
		return ch;
	}
}
