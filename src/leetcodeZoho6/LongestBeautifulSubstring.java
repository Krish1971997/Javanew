package leetcodeZoho6;


/**Solve the below problem.

 Given a string 'word', find the longest beautiful substring in 'word'. If no such substring exists, return '0'

A substring is considered beautiful if:
1. contains all five vowels (a,e,i,o,u) at least once.
2 The vowels appear in sorted order (i.e., all 'a's before 'e's. all 'e's before 'i's, and so on),

Example:
input1: aeiaaioaaaaeiiiiouuuooaauuaeiu
Output' : The longest beautiful substring is "aaaaeiiiiouuu"
Input2• maeiaaioaaaaeziiiihouuuzooaauuaeiugn
Output3: The longest beautiful substring is 'aaaaeziiiihouuu'
Input3: aeeeiiiioooauuuaeiou
OutB1t3. The longest beautiful substring is 'aeiou'*/

//Need to learn
public class LongestBeautifulSubstring {
	public static String longestBeautifulSubstring(String word) {
		if (word == null || word.length() < 5)
			return "0"; // Need at least 5 vowels

		int maxLength = 0;
		String result = "0";
		int i = 0;
		int vowelCount = 0;
		char prevVowel = 'a' - 1; // Initialize to a char before 'a'

		while (i < word.length()) {
			if (word.charAt(i) == 'a') {
				vowelCount = 1; // Start counting with 'a'
				prevVowel = 'a';
				int start = i;
				i++;

				// Check for consecutive vowels in order
				while (i < word.length() && (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i'
						|| word.charAt(i) == 'o' || word.charAt(i) == 'u')) {
					if (word.charAt(i) >= prevVowel) {
						if (word.charAt(i) > prevVowel) {
							vowelCount++;
							prevVowel = word.charAt(i);
						}
						i++;
					} else {
						break; // Vowel order violated
					}
				}

				// If all 5 vowels are found, update result
				if (vowelCount == 5) {
					int currentLength = i - start;
					if (currentLength > maxLength) {
						maxLength = currentLength;
						result = word.substring(start, i);
					}
				}
			} else {
				i++;
			}
		}

		return "The longest beautiful substring is \"" + result + "\"";
	}

	public static void main(String[] args) {
		String[] tests = { "aeiaaioaaaaeiiiiouuuooaauuaeiu", "maeiaaioaaaaeziiiihouuuzooaauuaeiugn",
				"aeeeiiiioooauuuaeiou" };
		for (String test : tests) {
			System.out.println("Input: " + test);
			System.out.println("Output: " + longestBeautifulSubstring(test));
		}
	}
}