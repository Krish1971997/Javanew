package leetcodeZoho4;

import java.util.Arrays;

public class TrappingRainWater {
	public static void main(String[] args) {
		int[] arr= {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(Arrays.toString(arr));
		System.out.println(findMaxHeight(arr));
	}

	private static int findMaxHeight(int[] arr) {
		int len=arr.length;
		int leftarr[]=new int[len];
		int rightarr[]=new int[len];
		
		leftarr[0]=arr[0];
		for (int i = 1; i < leftarr.length; i++) {
			leftarr[i]=Math.max(leftarr[i-1], arr[i]);
		}
		System.out.println(Arrays.toString(leftarr));
		
		rightarr[len-1]=arr[len-1];
		for (int i = rightarr.length-2;i>=0; i--) {
			rightarr[i]=Math.max(rightarr[i+1],arr[i]);
		}
		System.out.println(Arrays.toString(rightarr));
		int total=0;
		for (int i = 0; i < rightarr.length; i++) {
			int min=Math.min(leftarr[i],rightarr[i]);
			total+=min-arr[i];
		}
		return total;
	}

}
