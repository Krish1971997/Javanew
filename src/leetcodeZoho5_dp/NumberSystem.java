package leetcodeZoho5_dp;

import java.util.LinkedList;
import java.util.Queue;

public class NumberSystem {
	public static String findNthNumber(int n) {
		// Create a queue to generate numbers
		Queue<String> queue = new LinkedList<>();
		queue.add("3");
		queue.add("4");

		String nthNumber = "";

		for (int i = 1; i <= n; i++) {
			// Get the front element
			nthNumber = queue.poll();

			// Add the next numbers by appending '3' and '4'
			queue.add(nthNumber + "3");
			queue.add(nthNumber + "4");
		}

		return nthNumber;
	}

	public static void main(String[] args) {
		int n = 3; // Example input
		System.out.println("The " + n + "th number in the number system is: " + findNthNumber(n));
	}
}