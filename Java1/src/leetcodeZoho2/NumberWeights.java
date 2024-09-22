package leetcodeZoho2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NumberWeights {
	public static void main(String[] args) {
		int[] numbers = { 10, 36, 54, 89, 12 };
		List<NumberWeight> numberWeights = new ArrayList<>();

		// Calculate weights for each number
		for (int number : numbers) {
			int weight = calculateWeight(number);
			numberWeights.add(new NumberWeight(number, weight));
		}

		// Sort the numbers based on their weights in increasing order
		 //Collections.sort(numberWeights,
		 //Comparator.comparingInt(NumberWeight::getWeight));
		numberWeights.sort((n1, n2) -> Integer.compare(n1.getWeight(), n2.getWeight()));
		//Collections.sort(numberWeights, Comparator.comparingInt(NumberWeight::getWeight));

		// Print the numbers and their weights
		for (NumberWeight nw : numberWeights) {
			System.out.println("<" + nw.getNumber() + "," + nw.getWeight() + ">");
		}
	}

	private static int calculateWeight(int number) {
		int weight = 0;

		if (isPerfectSquare(number)) {
			weight += 5;
		}
		if (number % 4 == 0 && number % 6 == 0) {
			weight += 4;
		}
		if (number % 2 == 0) {
			weight += 3;
		}

		return weight;
	}

		private static boolean isPerfectSquare(int number) {
			int sqrt = (int) Math.sqrt(number);
			return sqrt * sqrt == number;
		}
}

class NumberWeight {
	private int number;
	private int weight;

	public NumberWeight(int number, int weight) {
		this.number = number;
		this.weight = weight;
	}

	public int getNumber() {
		return number;
	}

	public int getWeight() {
		return weight;
	}
}
