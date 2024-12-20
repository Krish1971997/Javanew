package leetcodeZoho1;

public class WildcardPatternMatching {

	public static boolean isMatch(String text, String pattern) {
		int m = text.length();
		int n = pattern.length();

		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;

		// Initialize the first row (for empty text)
		for (int j = 1; j <= n; j++) {
			if (pattern.charAt(j - 1) == '*') {
				dp[0][j] = dp[0][j - 1];
			}
		}

		// Fill the dp array
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (pattern.charAt(j - 1) == '?' || text.charAt(i - 1) == pattern.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (pattern.charAt(j - 1) == '*') {
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				}
			}
		}

		return dp[m][n];
	}

	public static void main(String[] args) {
		String text = "baaabab";

		String[] patterns = { "*****ba*****ab",
				"baaa?ab", "ba*a?", "a*ab" };

		for (String pattern : patterns) {
			System.out.println("Pattern: " + pattern + ", Output: " + isMatch(text, pattern));
		}
	}
}
