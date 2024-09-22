package geeksforgeeksZoho;

import java.util.Arrays;

public class Segregate0and1s {

	public static void main(String[] args) {
		int arr[]= {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
		int zeroindex=0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==0) {
				int temp=arr[i];
				arr[i]=arr[zeroindex];
				arr[zeroindex++]=temp;
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
}
