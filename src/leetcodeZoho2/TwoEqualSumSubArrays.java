package leetcodeZoho2;

import java.util.ArrayList;
import java.util.List;

public class TwoEqualSumSubArrays {
	
	public static void main(String[] args) {
		int arr[] = { 1 , 2 , 3 , 4 , 5 , 5  };
		if(!find(arr))
			System.out.println("Not Possible");
	}

	private static boolean find(int[] arr) {
		int sum=0;
		for (int i = 0; i < arr.length; i++) 
			sum+=arr[i];
		
		if(sum%2!=0)
			return false;
		
		List<Integer> first=new ArrayList<>();
		List<Integer> second=new ArrayList<>();
		int target=sum/2;
		
		int firstsum=0, secondsum=0;
		for (int i = 0; i < arr.length; i++) {
			if(firstsum+arr[i]<=target) {
				first.add(arr[i]);
				firstsum+=arr[i];
			}else {
				second.add(arr[i]);
				secondsum+=arr[i];
			}
		}
		
		if(firstsum!=secondsum)
			return false;
		
		System.out.println("First array");
		for (Integer integer : first) {
			System.out.print(integer+", ");
		}
		
		System.out.println("\nSecond array");
		for (Integer integer : second) {
			System.out.print(integer+", ");
		}
		
		return true;
	}
}
