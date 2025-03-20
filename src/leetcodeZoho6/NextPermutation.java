package leetcodeZoho6;

public class NextPermutation {
	public static String nextPermutation(int n) {
		
		char[] arr = String.valueOf(n).toCharArray();
		int len = arr.length;

		// Step 1: Find the first decreasing element from the right
		int i = len - 2;
		while (i >= 0 && arr[i] >= arr[i + 1]) {
			i--;
		}

		// If no such element is found, it's the last permutation
		if (i == -1) {
			return "Not Possible";
		}

		// Step 2: Find the smallest number greater than arr[i] from the right
		int j = len - 1;
		while (arr[j] <= arr[i]) {
			j--;
		}

		// Step 3: Swap arr[i] and arr[j]
		swap(arr, i, j);

		// Step 4: Reverse the part after index i
		reverse(arr, i + 1, len - 1);

		return new String(arr);
	}

	// Swap helper function
	private static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// Reverse helper function
	private static void reverse(char[] arr, int start, int end) {
		while (start < end) {
			swap(arr, start, end);
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		int n = 218765; // 251678

		// i/p 1234 o/p 1243
		// i/p 4321 o/p not possible

		String result = nextPermutation(n);
		System.out.println("Output: " + result);

	}
}
