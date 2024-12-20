package leetcodeZoho4;

public class ConsecutiveSumWays {

	public static void main(String[] args) {
		int n = 9;
		System.out.println("Result : " + countConsecutiveSumWays(n));
	}

	public static int countConsecutiveSumWays(int n) {
		int count = 0;

		// Loop through possible lengths of consecutive sequences
		for (int k = 1; k * (k + 1) / 2 <= n; k++) {
			// Check if (n - (k * (k - 1) / 2)) is divisible by k
			if ((n - (k * (k - 1) / 2)) % k == 0)
				count++;
		}
		return count;
	}
}