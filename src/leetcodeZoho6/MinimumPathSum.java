package leetcodeZoho6;

import java.util.Arrays;

public class MinimumPathSum {
	public static void main(String[] args) {
		int[][] arr = { { 1, 3, 1 }, 
						{ 1, 5, 1 }, 
						{ 4, 2, 1 } };
		int[][] mem = new int[arr.length][arr[0].length];
		for (int i = 0; i < mem.length; i++) {
			Arrays.fill(mem[i], -1);
		}
		System.out.println(findMinimumPathSum(arr, mem, 0, 0));
	}

	private static int findMinimumPathSum(int[][] arr, int[][] mem, int i, int j) {

		if (i == arr.length - 1 && j == arr[0].length - 1)
			return arr[i][j];

		if (i >= arr.length || j >= arr[0].length)
			return Integer.MAX_VALUE;

		if (mem[i][j] != -1)
			return mem[i][j];

		int left = findMinimumPathSum(arr, mem, i, j + 1);
		int down = findMinimumPathSum(arr, mem, i + 1, j);

		return mem[i][j] = arr[i][j] + Math.min(left, down);

	}
}
