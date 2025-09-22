package zsecondroundL2;

public class MiniRegexFinder {

	public static String findFirstMatch(String text, String pattern) {
		for (int i = 0; i < text.length(); i++) {
			String match = tryMatch(text, pattern, i);
			if (match != null) {
				return match;
			}
		}
		return "No match found";
	}

	private static String tryMatch(String text, String pattern, int start) {
		int ti = start, pi = 0;
		StringBuilder sb = new StringBuilder();

		while (pi < pattern.length()) {
			if (ti >= text.length())
				return null;

			char pc = pattern.charAt(pi);

			// Check if next char in pattern is * or +
			if (pi + 1 < pattern.length() && (pattern.charAt(pi + 1) == '*' || pattern.charAt(pi + 1) == '+')) {
				char op = pattern.charAt(pi + 1);

				if (op == '*') {
					// zero or more occurrences
					while (ti < text.length() && text.charAt(ti) == pc) {
						sb.append(text.charAt(ti));
						ti++;
					}
					pi += 2; // skip char and '*'
				} else { // '+'
					// must match at least once
					if (ti >= text.length() || text.charAt(ti) != pc)
						return null;
					while (ti < text.length() && text.charAt(ti) == pc) {
						sb.append(text.charAt(ti));
						ti++;
					}
					pi += 2; // skip char and '+'
				}
			} else {
				// exact match
				if (text.charAt(ti) != pc)
					return null;
				sb.append(text.charAt(ti));
				ti++;
				pi++;
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String text1 = "abcbbcabb";
		String pattern1 = "cb*cab+";
		System.out.println(findFirstMatch(text1, pattern1)); // cbbcabb

		String text2 = "abcfbbbacbk";
		String pattern2 = "bbk*ac+";
		System.out.println(findFirstMatch(text2, pattern2)); // bbac
	}
}
