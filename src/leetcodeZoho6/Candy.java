package leetcodeZoho6;

import java.util.Arrays;

public class Candy {
	public static void main(String[] args) {
		//int[] arr= {1,0,2};
		int[] arr= {1,2,2};
		int[] candy =findCandyArray(arr);
		System.out.println(Arrays.toString(candy));
	}

	private static int[] findCandyArray(int[] arr) {
		int[] candies=new int[arr.length];
		
		for (int i = 0; i < candies.length; i++) {
			candies[i]=1;
		}	
		
		for (int i = 1; i < candies.length; i++) {
			if(arr[i]>arr[i-1])
				candies[i]=candies[i-1]+1;
		}
		
		for (int i = arr.length-2; i >=0; i--) {
			if(arr[i]>arr[i+1])
				candies[i]=Math.max(candies[i], candies[i+1]+1);
		}
		
		return candies;
	}
}
