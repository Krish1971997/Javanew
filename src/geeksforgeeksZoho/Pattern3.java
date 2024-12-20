package geeksforgeeksZoho;

public class Pattern3 {

	public static void main(String[] args) {
		String str = "BreakingBad";
		int start = 0, mid = 0;
		for (int i = 1; i < str.length(); i++) {
			if (Character.isUpperCase(str.charAt(i))) {
				mid = i;
				break;
			}
		}

		int length = Math.max(mid, str.length() - mid);

		for (int i = 0; i < length; i++) {
			for (int j = start; j < mid && j <= i; j++) {
				System.out.print(Character.toUpperCase(str.charAt(j)));
			}

			for (int j = mid; j < str.length()&&j<=mid+i; j++) {
				System.out.print(Character.toUpperCase(str.charAt(j)));
			}
			System.out.println();
		}
	}
}
