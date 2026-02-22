package leetcodeZoho8;

public class DiagonalPattern {

	public static void main(String[] args) {

		int n = 5;

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= n; j++) {

				if (j < i) {
					System.out.print("\t");
				} else {
					int value = (j * (j - 1)) / 2 + i;
					System.out.print(value + "\t");
				}
			}

			System.out.println();
		}
	}
}