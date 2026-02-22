package leetcodeZoho5_dp;

public class PatternZoho {

	public static void main(String[] args) {
		String str = "1234567";
		printPattern(str);
	}

	private static void printPattern(String str) {
		int length = str.length();

		if (length % 2 == 0) {
			int mid = length / 2;
			StringBuilder sb = new StringBuilder(str);
			sb.insert(mid, '*');
			str = sb.toString();
			length = str.length();
		}

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {

				if (i == length / 2) { //mid in row
					System.out.print(str.charAt(j % str.length()) + " ");
				} else if (i == j || i + j == length - 1) { // cross
					System.out.print(str.charAt(i % str.length()) + " ");
				} else if (j == length / 2) { //mid in column
					System.out.print(str.charAt(i % str.length()) + "  ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
}
