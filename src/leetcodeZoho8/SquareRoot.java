package leetcodeZoho8;

import java.util.Scanner;

public class SquareRoot {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number: ");
		int n = sc.nextInt();

		int start = 0;
		int end = n-1;
		int ans = 0;

		while (start <= end) {
			int mid = (start + end) / 2;

			if (mid * mid == n) {
				ans = mid;
				break;
			} else if (mid * mid < n) {
				ans = mid; // store possible answer
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		System.out.println("Square Root = " + ans);
	}
}