package leetcodeZoho6;

import java.util.HashSet;
import java.util.Set;
//https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/description/
public class RowColumnConatinsAllNumbers {
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 1 }, { 3, 1, 2 }, { 2, 3, 1 } };
		System.out.println(findSolution(arr));
	}

	private static boolean findSolution(int[][] arr) {
		Set<Integer> set=new HashSet<>();
		for (int i = 1; i <= arr.length; i++) {
			set.add(i);
		}
		
		for(int i=0;i<arr.length;i++) {
			Set<Integer> row=new HashSet<>();
			Set<Integer> col=new HashSet<>();
			for(int j=0;j<arr.length;j++) {
				row.add(arr[i][j]);
				col.add(arr[j][i]);
			}
			
			if(!(set.equals(row)) && (set.equals(col)))
				return false;
		}
		
		return true;
	}
}
