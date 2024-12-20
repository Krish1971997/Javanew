package leetcodeZoho;

import java.util.Arrays;

public class LargestNumberWithGivenSumAndDigits {
	public static void main(String[] args) {
		int s1 = 3;
		int d1 = 3;
		System.out.println("Output for s = 9, d = 2: " + largestNumber(s1, d1));

		int s2 = 20;
		int d2 = 3;
		System.out.println("Output for s = 20, d = 3: " + largestNumber(s2, d2));
	}

	public static String largestNumber(int s, int d) {
		if (s > 9 * d)
			return "Not possible";

		int[] result = new int[d];
		Arrays.fill(result, 9); // Initialize all digits with 9

		for (int i = 0; i < d; i++) {
			if (s >= 9) {
				result[i] = 9;
				s -= 9;
			} else {
				result[i] = s;
				s = 0;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int digit : result) {
			sb.append(digit);
		}

		return sb.toString();

	}
	/*
	 * public static String largestNumber(int s, int d) { if (s > 9 * d) return
	 * "Not possible";
	 * 
	 * int[] result = new int[d]; Arrays.fill(result, 9); // Initialize all digits
	 * with 9 int largest=9; extracted(s, d, result, largest); StringBuilder sb =
	 * new StringBuilder(); for (int digit : result) { sb.append(digit); } return
	 * sb.toString(); }
	 * 
	 * private static void extracted(int s, int d, int[] result, int largest) { int
	 * backup=s; for (int i = 0; i < d; i++) { if (s >= largest) { result[i] =
	 * largest; s -= largest; } else if(s==0){ extracted(backup, d, result,
	 * largest-1); } else { result[i] =s; } } }
	 */
}
