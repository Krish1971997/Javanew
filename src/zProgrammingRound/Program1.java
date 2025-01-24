package zProgrammingRound;

public class Program1 {
	public static void main(String[] args) {
		int n = 5;

		for (int i = 1; i <= n; i++) {
			int current = i;
			for (int j = 0; j < i; j++) {
				System.out.print(current + " ");
				current = current + n - 1;
			}
			System.out.println();
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("  ");
			}
			int current = n * (i + 1);
			for (int k = i; k < n; k++) {
				System.out.print(current + " ");
				current = current + n - 1;
			}
			System.out.println();
		}
	}
}
