package zoho;

import java.util.Arrays;

public class MoveAllZerosToEnd {

	public static void main(String[] args) {
		int Arr[] = {3, 5, 0, 0, 4};
		int N=5;
		pushZerosToEnd(Arr,N);
		System.out.println(Arrays.toString(Arr));
	}

	private static void pushZerosToEnd(int[] arr, int n) {
		
		int nonZero=0;
		for (int i = 0; i < n; i++) {
			if(arr[i]!=0) {
				int temp=arr[i];
				arr[i]=arr[nonZero];
				arr[nonZero]=temp;
				nonZero++;
			}
		}
		
		/*for (int i = nonZero; i < arr.length; i++) {
			arr[i]=0;
		} */
	}
}
