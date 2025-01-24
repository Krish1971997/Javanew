package leetcodeZoho1;

import java.util.Stack;

public class CountOfSmallerNumbersAfterSelf {

	public static void main(String[] args) {
		 int[] nums = { 5, 2, 6, 1 };
		//int[] nums = { -1 };
		find(nums, new int[nums.length]);
	}

	private static void find(int[] nums, int[] res) {
//		Stack<Integer> stack = new Stack<Integer>();
//		res[nums.length - 1] = 0;
//		stack.push(0);
//		for (int i = nums.length - 2; i >= 0; i--) {
//
//			while (!stack.isEmpty() && nums[i] <= stack.peek()) {
//				stack.pop();
//			}
//
//			if (stack.isEmpty()) {
//				stack.push(Integer.MAX_VALUE);
//			}
//
//			if (nums[i] > stack.peek()) {
//				res[i] = stack.size();
//				stack.push(nums[i]);
//			}
//		}	
//
//		System.out.println(Arrays.toString(res));
//		return Arrays.asList(res);
		
		int[] newArray = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= nums[i]) {
                stack.pop();
            }
            newArray[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }

        for (int element : newArray) {
            System.out.print(element + " ");
        }
	}
}
