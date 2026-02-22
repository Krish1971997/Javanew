package leetcodeZoho8;

public class PalindromeMatrix {

	static int n = 3;
	static char[][] matrix = { { 'a', 'a', 'b' }, { 'b', 'a', 'a' }, { 'b', 'b', 'a' } };

	public static void main(String[] args) {
		findPalindromes(0, 0, "");
	}

	static void findPalindromes(int i, int j, String path) {

		// Add current character
		path += matrix[i][j];

		// If reached bottom-right
		if (i == n - 1 && j == n - 1) {
			if (isPalindrome(path)) {
				System.out.println(path);
			}
			return;
		}

		// Move Down
		if (i + 1 < n) {
			findPalindromes(i + 1, j, path);
		}

		// Move Right
		if (j + 1 < n) {
			findPalindromes(i, j + 1, path);
		}
	}

	static boolean isPalindrome(String s) {
		int left = 0, right = s.length() - 1;

		while (left < right) {
			if (s.charAt(left) != s.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}
}