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

		int result = compareVersion(ver1, ver2);
		System.out.println(result);
	}
	
	
	public static int compareVersion(String version1, String version2) {

        int i = 0, j = 0;
        int n1 = version1.length();
        int n2 = version2.length();

        while (i < n1 || j < n2) {

            int num1 = 0;
            int num2 = 0;

            // Read number in version1
            while (i < n1 && version1.charAt(i) != '.') {
                char ch = version1.charAt(i);
                num1 = num1 * 10 + (ch - '0');  // manual conversion
                i++;
            }

            // Read number in version2
            while (j < n2 && version2.charAt(j) != '.') {
                char ch = version2.charAt(j);
                num2 = num2 * 10 + (ch - '0');  
                j++;
            }

            // Compare
            if (num1 > num2) return 1;
            if (num1 < num2) return -1;

            // Skip the dot
            i++;
            j++;
        }

        return 0;
    }

//	private static String versionCompare(String ver1, String ver2) {
//		String[] str1 = splitWords(ver1);
//		String[] str2 = splitWords(ver2);
//
//		int length = max(str1.length, str2.length);
//
//		for (int i = 0; i < length; i++) {
//			// int num1 = stringToInt(i < str1.length ? str1[i] : "0");
//			int num1 = i < str1.length ? stringToInt(str1[i]) : 0;
//			// int num2 = stringToInt(i < str2.length ? str2[i] : "0");
//			int num2 = i < str2.length ? stringToInt(str2[i]) : 0;
//
//			if (num1 > num2)
//				return "Downgraded";
//			else if (num1 < num2)
//				return "Upgraded";
//		}
//
//		return "Equal";
//	}
//
//	private static String[] splitWords(String s) {
//		int wordcount = wordsCount(s);
//		String[] words = new String[wordcount];
//		StringBuilder sb = new StringBuilder();
//		int wordIdx = 0;
//
//		for (int i = 0; i < s.length(); i++) {
//			char ch = s.charAt(i);
//
//			if (ch == '.') {
//				if (sb.length() > 0) {
//					words[wordIdx++] = sb.toString();
//					sb.setLength(0);
//				}
//			} else {
//				sb.append(ch);
//			}
//		}
//
//		words[wordIdx] = sb.toString();
//		return words;
//	}
//
//	private static int wordsCount(String s) {
//		int count = 1; // start with 1 as there is at least one version number
//		for (int i = 0; i < s.length(); i++) {
//			if (s.charAt(i) == '.') {
//				count++;
//			}
//		}
//		return count;
//	}
//
//	private static int stringToInt(String s) {
//		int result = 0;
//		for (int i = 0; i < s.length(); i++) {
//			result = result * 10 + (s.charAt(i) - '0');
//		}
//		return result;
//	}
//
//	private static int max(int length1, int length2) {
//		return (length1 > length2) ? length1 : length2;
//	}
}
