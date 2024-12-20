package leetcodeZoho4;

import java.util.Arrays;

public class UniquePath {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] mem=new int[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			Arrays.fill(mem[i], -1);
		}
		
		System.out.println(find1(arr, 0, 0,mem));
	}

	private static int find1(int[][] arr, int i, int j, int[][] mem) {

		if (i == arr.length-1 && j == arr[0].length-1)
			return 1;

		if (i >= arr.length || j >= arr[0].length)
			return 0;

		if(mem[i][j]!=-1)
			return mem[i][j];
		
		int right = find1(arr, i, j + 1,mem);
		int down = find1(arr, i + 1, j,mem);

		return mem[i][j]=right + down;
	}
	
//	private static int find(int[][] arr, int i, int j) {
//
//		if (i == arr.length-1 && j == arr[0].length-1)
//			return 1;
//
//		if (i > arr.length || j >= arr[0].length)
//			return 0;
//
//		int right = find(arr, i, j + 1);
//		int down = find(arr, i + 1, j);
//
//		return right + down;
//	}
}
