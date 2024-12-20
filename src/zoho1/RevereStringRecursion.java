package zoho1;

import java.util.Arrays;

public class RevereStringRecursion {
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) {
		String input1 = "one two three";
		//String input2 = "I love india";
		
		reverseWords(input1);
		System.out.println("Input 1: " + input1);
		System.out.println("Output 1: " + sb.toString());
	}

	private static void reverseWords(String input1) {
		String arr[]=input1.split("\\s+");
		System.out.println("Array -->"+Arrays.toString(arr));
		reversewords(arr,arr.length-1);
	}

	private static void reversewords(String[] arr, int i) {
		if(i>=0) {
			sb.append(arr[i]);
			if(i>0)
				sb.append(" ");
			reversewords(arr,i-1);
		}
	}
}