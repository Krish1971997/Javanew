package geeksforgeeksZoho;

public class SubsequenceCheck {

	public static void main(String[] args) {
		String str1 = "AXY";
		String str2 = "ADXCPY";
		System.out.println(isSubsequence(str1, str2)); // Output: True

		str1 = "AXY";
		str2 = "YADXCP";
		System.out.println(isSubsequence(str1, str2)); // Output: False

		str1 = "gksrek";
		str2 = "geeksforgeeks";
		System.out.println(isSubsequence(str1, str2)); // Output: True
	}

	static boolean isSubsequence(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();

		int i = 0, j = 0;

		if (m > n) {
			while (i < m && j < n) {
				if (str1.charAt(i) == str2.charAt(j)) {
					i++;
				}
				j++;
			}
		}
		return i == m;
	}
}
