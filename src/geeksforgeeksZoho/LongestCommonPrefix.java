package geeksforgeeksZoho;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		String[] example1 = { "flower", "flow", "floight" };
		String[] example2 = { "dog", "racecar", "dor" };

		System.out.println("Example 1 Output: " + longestCommonPrefix(example1)); // Output: "fl"
		System.out.println("Example 2 Output: " + longestCommonPrefix(example2)); // Output: ""
	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		String prefix = strs[0];

		for (int i = 1; i < strs.length; i++) {
			int j = 0;
			// Compare characters of the current string with the prefix
			while (j < prefix.length() && j < strs[i].length() 
					&& prefix.charAt(j) == strs[i].charAt(j)) {
				j++;
			}
			// Update the prefix based on the common characters
			prefix = prefix.substring(0, j);

			if (prefix.equals("")) {
				break;
			}
		}
		return prefix;
	}
}
