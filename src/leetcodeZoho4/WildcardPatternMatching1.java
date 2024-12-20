package leetcodeZoho4;

public class WildcardPatternMatching1 {

	public static void main(String[] args) {
		String s1 = "aaaab";
		String s2 = "a*b";
		System.out.println(find(s1, s2, 0, 0));
	}

	private static boolean find(String s1, String s2, int i, int j) {

		if (i == s1.length() && j == s2.length())
			return true;

		if (j == s2.length())
			return false;

		boolean match = false;
		if (j < s2.length() - 1 && s2.charAt(j + 1) == '*') {

			match = find(s1, s2, i, j + 2);
			if (i < s1.length() && s1.charAt(i) == s2.charAt(j) || s2.charAt(j) == '.') {
				match = match || find(s1, s2, i + 1, j);
			}
			return match;

		} else if (i < s1.length() && s1.charAt(i) == s2.charAt(j) || s2.charAt(j) == '.') {
			return match = find(s1, s2, i + 1, j + 1);
		}

		return false;

	}

}
