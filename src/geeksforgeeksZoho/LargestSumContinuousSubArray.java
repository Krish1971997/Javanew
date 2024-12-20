package geeksforgeeksZoho;

public class LargestSumContinuousSubArray {
//KadanesAlgorithm
	public static void main(String[] args) {
		int[] arr1 = { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println("Largest Sum Contiguous Subarray: " + maxSubarraySum(arr1)); // Output: 7

		//int[] arr2 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		//System.out.println("Largest Sum Contiguous Subarray: " + maxSubarraySum(arr2)); // Output: 6
	}

	// Function to find the largest sum contiguous subarray using Kadane's Algorithm
	static int maxSubarraySum(int[] arr) {
		int maxEndingHere = arr[0];
		int maxSoFar = arr[0];

		for (int i = 1; i < arr.length; i++) {
			// Choose the maximum between the current element and the sum so far plus the
			// current element
			//System.out.println("arr[i] : "+arr[i]);
			//System.out.println("maxEndingHere + arr[i] : "+maxEndingHere + arr[i]);
			maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
			//System.out.println("maxEndingHere : "+maxEndingHere);
			// Update the maximum sum so far
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
			//System.out.println("maxSoFar : "+maxSoFar);
		}

		return maxSoFar;
	}
}
