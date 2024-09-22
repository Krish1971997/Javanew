package zoho2ndround.secondRound;

import java.util.Scanner;

public class Program5 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		String s1 = "Sangeet";
		String s2 = "Set";

		boolean result = findSubSequence(s1, s2);
		if (result) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	private static boolean findSubSequence(String s1, String s2) {

		int m = s1.length();
		int n = s2.length();
		int i = 0, j = 0;
		if (m < n) {
			while (i < m && j < n) {
				if (s1.charAt(i) == s2.charAt(j)) {
					i++;
				}
				j++;
			}
		}

		return i == m;
	}

}
