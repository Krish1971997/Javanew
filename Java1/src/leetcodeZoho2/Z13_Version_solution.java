package leetcodeZoho2;

import java.util.Scanner;

public class Z13_Version_solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Version1 : ");
		String ver1 = s.next();

		System.out.println("Enter the Version2 : ");
		String ver2 = s.next();

		// String ver1="1.9.15";
		// String ver2="1.9.15";

		String result = versionCompare(ver1, ver2);
		System.out.println(result);
	}

	private static String versionCompare(String ver1, String ver2) {
		String[] str1 = splitWords(ver1);
		String[] str2 = splitWords(ver2);

		int length = max(str1.length, str2.length);

		for (int i = 0; i < length; i++) {
			int num1 = stringToInt(i < str1.length ? str1[i] : "0");
			int num2 = stringToInt(i < str2.length ? str2[i] : "0");

			if (num1 > num2)
				return "Downgraded";
			else if (num1 < num2)
				return "Upgraded";
		}

		return "Equal";
	}

	private static String[] splitWords(String s) {
		int wordcount = wordsCount(s);
		String[] words = new String[wordcount];
		StringBuilder sb = new StringBuilder();
		int wordIdx = 0;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '.') {
				if (sb.length() > 0) {
					words[wordIdx++] = sb.toString();
					sb.setLength(0);
				}
			} else {
				sb.append(ch);
			}
		}

		words[wordIdx] = sb.toString();
		return words;
	}

	private static int wordsCount(String s) {
		int count = 1; // start with 1 as there is at least one version number
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '.') {
				count++;
			}
		}
		return count;
	}

	private static int stringToInt(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			result = result * 10 + (s.charAt(i) - '0');
		}
		return result;
	}

	private static int max(int length1, int length2) {
		return (length1 > length2) ? length1 : length2;
	}
}
