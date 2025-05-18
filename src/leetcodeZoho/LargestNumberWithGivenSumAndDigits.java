package leetcodeZoho;

import java.util.Arrays;

public class LargestNumberWithGivenSumAndDigits {
	public static void main(String[] args) {
		int s1 = 9;
		int d1 = 2;
		System.out.println("Output for s = 9, d = 2: " + largestNumber(s1, d1));

		int s2 = 20;
		int d2 = 3;
		System.out.println("Output for s = 20, d = 3: " + largestNumber(s2, d2));
	}

	public static String largestNumber(int s, int d) {
        // Check if number is possible: sum should be between d (all 1s) and 9*d (all 9s)
        if (s < d || s > 9 * d) {
            return "Not possible";
        }

        int[] result = new int[d];
        // Start with all 1s to avoid zeros
        Arrays.fill(result, 1);
        s -= d; // Subtract 1 for each digit

        // Distribute remaining sum starting from left to maximize the number
        for (int i = 0; i < d && s > 0; i++) {
            int add = Math.min(s, 8); // Can add up to 8 to make digit 9 (1 + 8)
            result[i] += add;
            s -= add;
        }

        // Build the result string
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
