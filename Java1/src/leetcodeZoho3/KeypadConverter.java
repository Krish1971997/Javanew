package leetcodeZoho3;

public class KeypadConverter {
	public static void main(String[] args) {
		String input = "sour mango";
		String output = convertToKeypad(input);
		System.out.println("Input: " + input);
		System.out.println("Output: " + output);
	}

	public static String convertToKeypad(String input) {
		String[] keypad = { "2", "22", "222", // 2
				"3", "33", "333", // 3
				"4", "44", "444", // 4
				"5", "55", "555", // 5
				"6", "66", "666", // 6
				"7", "77", "777", "7777", // 7
				"8", "88", "888", // 8
				"9", "99", "999", "9999" // 9
		};

		StringBuilder result = new StringBuilder();
		input = input.toLowerCase(); // Convert the input to lowercase

		for (char c : input.toCharArray()) {
			if (c == ' ') {
				result.append("0");
			} else if (c >= 'a' && c <= 'z') {
				int index = c - 'a'; // Calculate the index for the letter
				result.append(keypad[index]);
			}
		}

		return result.toString();
	}

}
