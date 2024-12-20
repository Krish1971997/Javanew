package zProgrammingRound;

public class Program5 {
	public static void main(String[] args) {
		//int[] arr = { 3, 9, 1, 0 }; // Example input
		 int[] arr = { 3, 2, 1, 4 };
		System.out.println(findLargestNumberInArray(arr)); // Output will be -1
	}

	private static int findLargestNumberInArray(int[] arr) {
		if (arr.length == 0)
			return -1;

		int largestNumber = arr[0];
		boolean isValid = true;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > largestNumber) {
				largestNumber = arr[i];
			}
			if (arr[i] != largestNumber && largestNumber <= arr[i] * 2) {
				isValid = false;
			}
		}

		return isValid ? largestNumber : -1;
	}
}


