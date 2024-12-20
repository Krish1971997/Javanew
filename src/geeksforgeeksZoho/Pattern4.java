package geeksforgeeksZoho;

public class Pattern4 {
	public static void main(String[] args) {
		int rows = 5; // You can change the number of rows
		printNumberTriangle(rows);
	}

	private static void printNumberTriangle(int rows) {
		for (int i = 1; i <= rows; i++) {
			// Print spaces for alignment
			for (int j = 1; j <= rows - i; j++) {
				System.out.print("  ");
			}

			// Print increasing numbers
			int num = i;
			for (int k = 1; k <= i; k++) {
				System.out.print(num + " ");
				num++;
			}
			// Print decreasing numbers
			num -= 2;
			for (int l = 1; l <= i - 1; l++) {
				System.out.print(num + " ");
				num--;
			}

			// Move to the next line for the next row
			System.out.println();
		}
	}
}
