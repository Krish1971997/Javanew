package leetcodeZoho4;

//From rajesh bro
public class WildcardPatternMatching11 {

	public static void main(String[] args) {
		String s1 = "abcdefg";
		String s2 = "*a*b*c*d*.";
		System.out.println(find(s1, s2, 0, 0));
	}

	public static boolean find(String s1, String s2, int i, int j) {
		if (i == s1.length() && j == s2.length())
			return true;

		if (j == s2.length())
			return false;

		if (s2.charAt(j) == '*') {
			return find(s1, s2, i, j + 1) || 
					(i < s1.length() && find(s1, s2, i + 1, j));
		}

		if ((i < s1.length() && s1.charAt(i) == s2.charAt(j) || s2.charAt(j) == '.'))
			return find(s1, s2, i + 1, j + 1);
		return false;
	}

}
