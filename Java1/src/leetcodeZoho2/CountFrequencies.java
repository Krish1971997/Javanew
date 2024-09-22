package leetcodeZoho2;

import java.util.Arrays;

public class CountFrequencies {

	public static void main(String[] args) {
		int arr[] = {2, 3, 3, 2, 5};
		
		int newarr[]=new int[6];
		for(int i=0;i<arr.length;i++) {
			newarr[arr[i]]++;
		}
		
		System.out.println(Arrays.toString(newarr));
		
	}

}
