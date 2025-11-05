package leetcodeZoho7;

public class StringCompression {
	public static void main(String[] args) {
		String input = "Aabbbccc";
		System.out.println(compress(input));
	}

	public static String compress(String s) {
		s = s.toLowerCase(); // make case-insensitive
		StringBuilder result = new StringBuilder();

		int count = 1;
		for (int i = 1; i <= s.length(); i++) {
			if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
				count++;
			} else {
				result.append(s.charAt(i - 1)).append(count);
				count = 1;
			}
		}
		return result.toString();
	}
}
