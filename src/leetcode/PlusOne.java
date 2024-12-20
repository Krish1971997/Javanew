package leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/plus-one/
public class PlusOne {
	public static void main(String[] args) {
		// int digits[] = { 1, 2, 3 };
		int digits[] = {// 7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1,
				//1, 1, 7, 4, 0, 0, 9 };
				9,9,9,9,9};		
		int[] arr = plusOne(digits);
		System.out.println(Arrays.toString(arr));
	}

	public static int[] plusOne(int[] digits) {
		int n=digits.length;
		for (int i = n-1; i >=0; i--) {
			if(digits[i]<9) {
				digits[i]++;
				return digits;		
			}
			digits[i]=0;
		}
		int arr1[]=new int[n+1];
		arr1[0]=1;	
		return arr1;
	}
}