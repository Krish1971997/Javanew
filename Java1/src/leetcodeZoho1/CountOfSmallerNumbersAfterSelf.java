package leetcodeZoho1;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CountOfSmallerNumbersAfterSelf {

	public static void main(String[] args) {
		 int[] nums = { 5, 2, 6, 1 };
		//int[] nums = { -1 };
		List<int[]> res=find(nums, new int[nums.length]);
	}

	private static List<int[]> find(int[] nums, int[] res) {
		Stack<Integer> stack = new Stack<Integer>();
		res[nums.length - 1] = 0;
		stack.push(0);
		for (int i = nums.length - 2; i >= 0; i--) {

			while (!stack.isEmpty() && nums[i] <= stack.peek()) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				stack.push(Integer.MAX_VALUE);
			}

			if (nums[i] > stack.peek()) {
				res[i] = stack.size();
				stack.push(nums[i]);
			}
		}	

		System.out.println(Arrays.toString(res));
		return Arrays.asList(res);
	}
}
