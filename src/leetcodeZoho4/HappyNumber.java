package leetcodeZoho4;

import java.util.HashSet;
import java.util.Scanner;

public class HappyNumber {

	// Method to calculate the sum of the squares of the digits
	public static int sumOfSquares(int n) {
		int sum = 0;
		while (n > 0) {
			int digit = n % 10;
			sum += digit * digit;
			n /= 10;
		}
		return sum;
	}

	// Method to check if a number is a happy number
	public static boolean isHappyNumber(int n) {
		HashSet<Integer> seenNumbers = new HashSet<>();

		while (n != 1 && !seenNumbers.contains(n)) {
			seenNumbers.add(n);
			n = sumOfSquares(n);
		}

		return n == 1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number = scanner.nextInt();

		if (isHappyNumber(number)) {
			System.out.println(number + " is a happy number.");
		} else {
			System.out.println(number + " is not a happy number.");
		}
	}
}
