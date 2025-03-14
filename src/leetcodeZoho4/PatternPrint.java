package leetcodeZoho4;

public class PatternPrint {

	public static void printPattern(int length) {
		int[][] pattern = new int[length][length];
		int layers = length / 2;

		for (int row = 0; row < layers; row++) {
			int value = length - row;
			for (int col = row; col < length - row; col++) {
				pattern[row][col] = value; // top
				pattern[length - row - 1][col] = value; // down
				pattern[col][row] = value; // left
				pattern[col][length - row - 1] = value; // right
			}
		}

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				System.out.print(pattern[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int n1 = 4;
		System.out.println("Pattern for n = " + n1 + ":");
		printPattern(n1);

		int n2 = 8;
		System.out.println("\nPattern for n = " + n2 + ":");
		printPattern(n2);
	}
}
