package leetcodeZoho2;
//https://leetcode.com/problems/house-robber/description/

import java.util.Arrays;

//This program more complex
public class HouseRobber {
	public static void main(String[] args) {
		int[] arr = { 2, 7, 9, 3, 1 };
		// System.out.println(find(arr));
		int[] mem = new int[arr.length];
		Arrays.fill(mem, -1);
		System.out.println(find2(arr, mem, 0));
	}

	// 1st way
	public static int find(int[] arr) {

		if (arr.length == 0)
			return 0;

		int prev1 = 0, prev2 = 0;
		for (int i = 0; i < arr.length; i++) {
			int temp = prev1;
			prev1 = Math.max(prev1, prev2 + arr[i]);
			prev2 = temp;

		}
		return prev1;
	}

	// 2nd way
	public static int find2(int[] arr, int[] mem, int index) {

		if (index >= arr.length)
			return 0;
		if (mem[index] != -1)
			return mem[index];

		int left = arr[index] + find2(arr, mem, index + 2);
		int right = find2(arr, mem, index + 1);

		return mem[index] = Math.max(left, right);
	}
}