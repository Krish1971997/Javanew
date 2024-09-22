package leetcodeZoho2;

public class EquilibriumIndex {
	public static int findEquilibriumIndex(int[] arr) {
		int totalSum = 0;
		int leftSum = 0;

		for (int num : arr)
			totalSum += num;

		for (int i = 0; i < arr.length; i++) {
			totalSum -= arr[i];

			if (leftSum == totalSum)
				return i + 1; // Return 1-based index
			leftSum += arr[i];
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr1 = { -7, 1, 5, 2, -4, 3, 0 };
		int[] arr2 = { 1, 2, 3 };

		System.out.println("Equilibrium index of arr1: " + findEquilibriumIndex(arr1)); // Output: 4
		System.out.println("Equilibrium index of arr2: " + findEquilibriumIndex(arr2)); // Output: -1
	}
}
