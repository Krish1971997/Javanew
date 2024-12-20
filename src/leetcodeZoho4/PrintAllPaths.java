package leetcodeZoho4;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPaths {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		List<Integer> list=new ArrayList<>();
		find(arr, list,0,0);
	}

	private static void find(int[][] arr, List<Integer> list, int i, int j) {
		
		if(i==arr.length-1 && j==arr[0].length-1) {
			list.add(arr[i][j]);
			System.out.println(list);
			list.remove(list.size()-1);
			return;
		}
		
		if(i>=arr.length || j>=arr[0].length)
			return;
		
		list.add(arr[i][j]);
		find(arr,list,i,j+1);
		list.remove(list.size()-1);
		
		list.add(arr[i][j]);
		find(arr,list,i+1,j);
		list.remove(list.size()-1);
		
	}
}
