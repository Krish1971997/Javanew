package leetcodeZoho3;

import java.util.Stack;

public class DailyTemperatures {
	public int[] dailyTemperatures(int[] T) {
		int n = T.length;
		int[] answer = new int[n];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			// Compare the current temperature with the top of the stack
			while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
				int prevIndex = stack.pop();
				answer[prevIndex] = i - prevIndex; 
			}
			stack.push(i); 
		}

		return answer;
	}

	public static void main(String[] args) {
		DailyTemperatures solution = new DailyTemperatures();
		int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
		int[] result = solution.dailyTemperatures(temperatures);

		for (int days : result) {
			System.out.print(days + " ");
		}
	}
}
