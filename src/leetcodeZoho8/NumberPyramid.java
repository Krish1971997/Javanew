package leetcodeZoho8;

public class NumberPyramid {

	public static void main(String[] args) {

		int n = 4; // number of rows

		for (int i = 1; i <= n; i++) {

			// Print spaces
			for (int space = 1; space <= n - i; space++) {
				System.out.print(" ");
			}

			// Print increasing numbers
			for (int num = 1; num <= i; num++) {
				System.out.print(num);
			}

			// Print decreasing numbers
			for (int num = i - 1; num >= 1; num--) {
				System.out.print(num);
			}

			System.out.println();
		}
	}
}