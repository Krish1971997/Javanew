package leetcodeZoho;

import java.util.List;

public class FIndMaxSum {
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {

		int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
//		List<Integer> list = new ArrayList<>();
//		find(mat, 0, 0, 0, list);
//		System.out.println(max);
		System.out.println(find(mat, 0, 0, 0));
	}

	static void find(int[][] mat, int i, int j, int sum, List<Integer> list) {
		if (i == mat.length - 1 && j == mat[0].length - 1) {
			sum+=sum+mat[i][j];
			if (sum > max) {
				max = sum;
				System.out.println(list);
			}
			return;
		}
		if (i >= mat.length || j >= mat[0].length)
			return;

		list.add(mat[i][j]);
		find(mat, i, j + 1, sum + mat[i][j], list);
		list.remove(list.size() - 1);
		list.add(mat[i][j]);
		find(mat, i + 1, j, sum + mat[i][j], list);
		list.remove(list.size() - 1);
	}
	
	static int find(int[][] mat,int i,int j,int sum) {
		
		if(i==mat.length-1 && j==mat[0].length-1)
			return sum+mat[i][j];
		
		if(i>=mat.length || j==mat[0].length)
			return 0;
				
		int right=find(mat, i,j+1, sum+mat[i][j]);
		int down=find(mat, i+1,j, sum+mat[i][j]);
		
		return Math.max(right, down);
	}
}