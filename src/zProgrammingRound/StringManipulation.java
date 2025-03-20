package zProgrammingRound;

public class StringManipulation {
	public static void main(String[] args) {
		// case 1
		// String input="aaaaaaa";
		// String pattern="aa"; //Output: Xa
		// case 2
		String input = "abdekwabdkjerwkbabdkl";
		String pattern = "abd"; // Output XekwXkjerwkbXkl

		System.out.println(findOutput(input, pattern));
	}

	private static String findOutput(String input, String pattern) {
		StringBuilder output = new StringBuilder();
		int previousIndex = -1;
		int patternLength = pattern.length();
		for (int i = 0; i < input.length(); i++) {
			if (input.length() >= i + patternLength && input.substring(i, i + patternLength).equals(pattern)) {
				if (i == previousIndex) {
					previousIndex = i + patternLength + 1;
					i = i + patternLength;
					continue;
				}
				previousIndex = i + patternLength + 1;
				i = i + patternLength - 1;
				output.append("X");
			} else {
				output.append(input.charAt(i));
			}
		}

		return output.toString();
	}
}
