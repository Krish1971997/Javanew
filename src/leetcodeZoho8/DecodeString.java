package leetcodeZoho8;

public class DecodeString {

	public static String decode(String str) {

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			if (Character.isLetter(ch)) {
				result.append(ch);

				// If next character is digit
				if (i + 1 < str.length() && Character.isDigit(str.charAt(i + 1))) {
					int shift = str.charAt(i + 1) - '0';
					char shifted = (char) (ch + shift);
					result.append(shifted);
					i++; // skip digit
				}
			}
		}

		return result.toString();
	}

	public static void main(String[] args) {

		System.out.println(decode("a1b1c1"));
		System.out.println(decode("ab1c1de1"));
	}
}