package geeksforgeeksZoho;

import java.util.Arrays;

//https://www.geeksforgeeks.org/problems/ease-the-array0633/1

public class EaseTheArray {
	public static void main(String[] args) {
		int arr[]={2, 2, 0, 4, 0, 8};
		
		for(int i=1;i<arr.length;i++) {
			if(arr[i]==arr[i-1]) {
				arr[i-1]*=2;
				arr[i]=0;
			}
		}
		
		int zeroindex=0;
		for (int i =0;i<arr.length; i++) {
			if(arr[i]!=0) {
				int temp=arr[zeroindex];
				arr[zeroindex++]=arr[i];
				arr[i]=temp;
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
}
