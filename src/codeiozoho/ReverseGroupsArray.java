package codeiozoho;

import java.util.Arrays;

public class ReverseGroupsArray {

	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5,6,7};
		int group=3;
		
		
		for(int i=0;i<arr.length;i+=group) {
			int start=i;
			int end=Math.min(arr.length-1, i+group-1);
			while(start<=end) {
				int temp=arr[start];
				arr[start]=arr[end];
				arr[end]=temp;
				start++;
				end--;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
