package leetcodeZoho3;

public class PatternProgram {
	public static void main(String[] args) {
		int n = 4;

		for (int i = 1; i <= n; i++)
			System.out.println(printNumbers(1, i, 0));

		for (int i = 2; i <= n; i++) {
			System.out.print(printNumbers(0, i - 2, 1));
			System.out.println(printNumbers(i, n, 0));
		}
	}

	private static String printNumbers(int start, int end, int space) {
		StringBuilder sb = new StringBuilder();
		for (int j = start; j <= end; j++) {
			if (space > 0)
				sb.append(" ");
			else
				sb.append(j);
		}
		return sb.toString();
	}
}
