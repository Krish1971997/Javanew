package zProgrammingRound;

public class Program3 {
	public static void main(String[] args) {
		int[] arr = { 3, 5, 8, 10, 27, 45, 49 };
		// int[] arr = { 33, 40, 56, 70, 77, 145 };
		int target = 14;
		System.out.println(findNearestNumber(arr, target));
	}

	private static int findNearestNumber(int[] arr, int target) {
		int nearest = arr[0];
		int minDiff = Math.abs(target - arr[0]);

		for (int i = 1; i < arr.length; i++) {
			int currentDiff = Math.abs(target - arr[i]);

			if (arr[i] == target) {
				return target;
			}

			if (currentDiff < minDiff) {
				minDiff = currentDiff;
				nearest = arr[i];
			}

			else if (arr[i] > target) {
				break;
			}
		}

		return nearest;
	}

}
