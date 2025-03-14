package geeksforgeeksZoho;

public class FindSubArrayWithGivenSum {

	public static void main(String[] args) {
		int[] arr1 = {15, 2, 4, 8, 9, 5, 10, 23 };
		int sum1 = 23;
		findSubarrayWithSum(arr1, sum1); // Output: Sum found between indexes 2 and 4
	}

	static void findSubarrayWithSum(int[] arr, int targetSum) {
		int n = arr.length;
		int start = 0, end = 0, currentSum = 0;

		while (end <=n) {
			if (currentSum == targetSum) {
				System.out.println("Sum found between indexes " + start + " and " + (end - 1));
				return;
			}

			if (currentSum < targetSum && end < n) {
				currentSum += arr[end];
				end++;
			} else {
				currentSum -= arr[start];
				start++;
			}
		}

		System.out.println("No subarray found");
	}
}
