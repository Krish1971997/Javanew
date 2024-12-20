package zProgrammingRound;

public class Program2 {
	public static void main(String[] args) {
		// String str = "i came by car";
		String str = "asd fguih jklo";
		findLongestWord(str);
	}

	private static void findLongestWord(String str) {
		String maxWord = "";
		StringBuilder current = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch == ' ') {
				if (maxWord.length() < current.length()) {
					maxWord = current.toString();
				}
				current.setLength(0);
			} else
				current.append(ch);
		}

		if (maxWord.length() < current.length())
			maxWord = current.toString();

		System.out.println(maxWord);
	}

}
