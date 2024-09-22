package leetcodeZoho2;

public class Pattern1 {
	public static void main(String[] args) {
		int n = 3;
		for (int i = 0; i <= n; i++) {
			// Print leading spaces
			for (int j = 0; j < n - i; j++) {
				System.out.print(" ");
			}
			// Print numbers increasing from i to n
			for (int j = n - i + 1; j <= n; j++) {
				System.out.print(j);
			}
			// Print a zero
			System.out.print(0);
			// Print numbers decreasing from n to n - i + 1
			for (int j = n; j > n - i; j--) {
				System.out.print(j);
			}
			// New line after each row
			System.out.println();
		}
	}
}
