package zProgrammingRound;

public class Program2 {
	public static void main(String[] args) {
		// String str = "i came by car";
		String str = "asd fguih jklo";
		findLongestWord(str);
	}

	private static void findLongestWord(String str) {
		String maxWord = null;
		StringBuilder current = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch == ' ') {
				maxWord = getMaxWord(maxWord, current);
				current.setLength(0);
			} else
				current.append(ch);
		}

		maxWord = getMaxWord(maxWord, current);

		System.out.println(maxWord);
	}

	private static String getMaxWord(String maxWord, StringBuilder current) {
		if (maxWord.length() < current.length()) {
			maxWord = current.toString();
		}
		return maxWord;
	}

}
