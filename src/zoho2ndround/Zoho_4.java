package zoho2ndround;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Zoho_4 {

	/*public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		int total = scanner.nextInt();

		Map<String, Integer> map = new HashMap<>();
		pickCoins(0, 0, 0, 0, a, b, c, total, map);
		System.out.println(map.size());
	}

	private static void pickCoins(int one, int two, int five, int tot, int totOne, int totTwo, int totFive, int total,
			Map<String, Integer> map) {
		if (tot == total) {
			map.put((one + "" + two + five), 0);
			return;
		}

		if (one < totOne && tot + 1 <= total) {
			pickCoins(one + 1, two, five, tot + 1, totOne, totTwo, totFive, total, map);
		}
		if (two < totTwo && tot + 2 <= total) {
			pickCoins(one, two + 1, five, tot + 2, totOne, totTwo, totFive, total, map);
		}
		if (five < totFive && tot + 5 <= total) {
			pickCoins(one, two, five + 1, tot + 5, totOne, totTwo, totFive, total, map);
		}
	} */
	
	    public static void main(String[] args) {
	        int A = 3, B = 2, C = 1, T = 5;
	        int ways = countWays(A, B, C, T);
	        System.out.println("Number of ways to pick coins: " + ways);
	    }

	    public static int countWays(int A, int B, int C, int T) {
	        return countWaysHelper(A, B, C, T, 0);
	    }

	    private static int countWaysHelper(int A, int B, int C, int T, int currentSum) {
	        if (currentSum == T) {
	            return 1;
	        }

	        int ways = 0;

	        if (A > 0 && currentSum + 1 <= T) {
	            ways += countWaysHelper(A - 1, B, C, T, currentSum + 1);
	        }

	        if (B > 0 && currentSum + 2 <= T) {
	            ways += countWaysHelper(A, B - 1, C, T, currentSum + 2);
	        }

	        if (C > 0 && currentSum + 5 <= T) {
	            ways += countWaysHelper(A, B, C - 1, T, currentSum + 5);
	        }

	        return ways;
	    }
}
