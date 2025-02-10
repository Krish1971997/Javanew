package leetcodeZoho5_dp;

import java.util.*;

public class FactorialSumChecker {

	// Function to compute factorial of a digit (0-9)
	private static int factorial(int n) {
		if (n == 0 || n == 1)
			return 1;
		int fact = 1;
		for (int i = 2; i <= n; i++) {
			fact *= i;
		}
		return fact;
	}

	// Function to check if a number is in Fibonacci series
	private static boolean isFibonacci(int num) {
		int a = 0, b = 1;
		while (b < num) {
			int temp = b;
			b = a + b;
			a = temp;
		}
		return (b == num); // True if the number is in Fibonacci series
	}

	// Function to check the factorial sum property
	private static boolean isFactorialSum(int num) {
		int sum = 0, temp = num;
		while (temp > 0) {
			int digit = temp % 10;
			sum += factorial(digit);
			temp /= 10;
		}
		return sum == num;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int num = scanner.nextInt();

		// Step 1: Check if Fibonacci
		if (isFibonacci(num)) {
			System.out.println("No check (Fibonacci)");
		} else {
			// Step 2: Check if sum of factorial of digits equals the number
			if (isFactorialSum(num)) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}

		scanner.close();
	}
}
