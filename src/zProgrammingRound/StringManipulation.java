package zProgrammingRound;

public class StringManipulation {
	public static void main(String[] args) {
		// case 1
//		 String input="aaaaaaa";
//		 String pattern="aa"; //Output: Xa
		// case 2
		String input = "abdekwabdkjerwkbabdkl";
		String pattern = "abd"; // Output XekwXkjerwkbXkl

		System.out.println(findOutput(input, pattern));
	}

	private static String findOutput(String input, String pattern) {
		StringBuilder output = new StringBuilder();
		int previousIndex = -1;
		int patternLength = pattern.length();
		int i = 0;
		while (i < input.length()) {
			if (input.length() >= i + patternLength && input.substring(i, i + patternLength).equals(pattern)) {

				previousIndex = i + patternLength;
				i = i + patternLength;

				if (i == previousIndex)
					continue;

				output.append("X");

			} else {
				output.append(input.charAt(i++));
			}
		}

		return output.toString();
	}
}