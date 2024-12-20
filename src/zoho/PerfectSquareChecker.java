package zoho;

public class PerfectSquareChecker {
	public static void main(String[] args) {
		int number = 49; // Example number
		System.out.println(isPerfectSquare(number)); // Expected output: true
	}

	private static boolean isPerfectSquare(int number) {
		if (number < 0)
			return false; // Negative numbers cannot be perfect squares

		int left = 1, right = number;

		while (left <= right) {
			int mid = (left + right) / 2;
			int midSquare = mid * mid;

			if (midSquare == number) {
				return true;
			} else if (midSquare < number) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return false;
	}
}
