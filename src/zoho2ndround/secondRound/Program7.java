package zoho2ndround.secondRound;

import java.util.Scanner;
import java.util.Stack;

public class Program7 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Read the sizes of the three stacks
		int n1 = scanner.nextInt();
		int n2 = scanner.nextInt();
		int n3 = scanner.nextInt();

		// Read the heights of the cylinders in each stack
		Stack<Integer> stack1 = readStack(scanner, n1);
		Stack<Integer> stack2 = readStack(scanner, n2);
		Stack<Integer> stack3 = readStack(scanner, n3);

		// Calculate the heights of the three stacks
		int height1 = calculateHeight(stack1);
		int height2 = calculateHeight(stack2);
		int height3 = calculateHeight(stack3);

		// Keep removing cylinders from the tallest stack until all stacks are of equal
		// height
		while (!(height1 == height2 && height2 == height3)) {
			if (height1 >= height2 && height1 >= height3) {
				height1 -= stack1.pop();
			} else if (height2 >= height1 && height2 >= height3) {
				height2 -= stack2.pop();
			} else {
				height3 -= stack3.pop();
			}
		}

		// Print the height of the equal stacks
		System.out.println(height1);
	}

	// Function to read the heights of cylinders into a stack
	private static Stack<Integer> readStack(Scanner scanner, int size) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < size; i++) {
			stack.push(scanner.nextInt());
		}
		return stack;
	}

	// Function to calculate the height of a stack
	private static int calculateHeight(Stack<Integer> stack) {
		int height = 0;
		for (int cylinder : stack) {
			height += cylinder;
		}
		return height;
	}
}
