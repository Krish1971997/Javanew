package leetcodeZoho6;

class NextPermutationWithoutInbuilt {
	public static void findNextPermutation(int n) {
		// Step 1: Extract digits manually and store in an array
		int num = n, len = 0;
		int temp = num;

		// Count the number of digits
		while (temp > 0) {
			len++;
			temp /= 10;
		}

		int[] digits = new int[len];

		// Extract digits and store in reverse order
		temp = num;
		for (int i = len - 1; i >= 0; i--) {
			digits[i] = temp % 10;
			temp /= 10;
		}

		// Step 2: Find the first decreasing digit from the right
		int i = len - 2;
		while (i >= 0 && digits[i] >= digits[i + 1]) {
			i--;
		}

		// If no such digit found, it means we are at the last permutation
		if (i < 0) {
			System.out.println("Not Possible");
			return;
		}

		// Step 3: Find the smallest digit larger than digits[i] to swap
		int j = len - 1;
		while (digits[j] <= digits[i]) {
			j--;
		}

		// Swap digits[i] and digits[j]
		int tempDigit = digits[i];
		digits[i] = digits[j];
		digits[j] = tempDigit;

		// Step 4: Reverse the part after i to get the next smallest permutation
		reverse(digits, i + 1, len - 1);

		// Convert the array back to a number without using inbuilt functions
		int nextPermutation = 0;
		for (int digit : digits) {
			nextPermutation = nextPermutation * 10 + digit;
		}

		// Print the result
		System.out.println(nextPermutation);
	}

	private static void reverse(int[] arr, int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		int num = 218765;
		findNextPermutation(num);
	}
}
