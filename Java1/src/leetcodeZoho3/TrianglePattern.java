package leetcodeZoho3;

public class TrianglePattern {
	public static void main(String[] args) {
		int N = 6;

		for (int i = 1; i <= N; i++) {
			int value = i;
			int increment = N;

			for (int j = 0; j < N - i + 1; j++) {
				System.out.print(value + " ");
				value += increment;
				increment--;
			}
			System.out.println(); // Move to the next line after each row
		}
	}
}
