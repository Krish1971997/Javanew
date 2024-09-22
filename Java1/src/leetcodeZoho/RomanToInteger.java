package leetcodeZoho;

import java.util.HashMap;

public class RomanToInteger {
	public static void main(String[] args) {
		String[] inputs = { "VLI", "MCMXCIV", "IIX" };

		for (String input : inputs) {
			System.out.println("Input: " + input);
			System.out.println("Output: " + romanToInt(input));
		}
	}

	public static int romanToInt(String s) {
		HashMap<Character, Integer> values = new HashMap<>();
		values.put('I', 1);
		values.put('V', 5);
		values.put('X', 10);
		values.put('L', 50);
		values.put('C', 100);
		values.put('D', 500);
		values.put('M', 1000);

		int result = 0;
		int prevValue = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			int value = values.get(s.charAt(i));
			
			if (value < prevValue)
				result -= value;
			else
				result += value;
			prevValue = value;
		}
		return result;
	}
}
