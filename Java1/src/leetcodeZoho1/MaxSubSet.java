package leetcodeZoho1;

import java.util.ArrayList;

public class MaxSubSet {

	static int max=Integer.MIN_VALUE;
	public static void main(String[] args) {
		int arr[]= {1,2,3,4};
		find(arr, 0, 0, new ArrayList<>());
		System.out.println("Max -> "+max);
	}
	
	static void find(int[] arr,int index,int sum, ArrayList<Integer> list) {
		if(max<sum) {
			max=sum;
		}
		if(index==arr.length) {
			System.out.println(sum);
			System.out.println(list);
			return;
		}
				
		list.add(arr[index]);
		find(arr, index+1, sum+arr[index], list);
		list.remove(list.size()-1);
		find(arr, index+1, sum, list);
	}
}
