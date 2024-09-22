package zohofirstRound_31aug;

public class Program4 {
	public static void main(String[] args) {
		int arr[][] = { { 1, 1, 0, 1, 0 }, { 0, 0, 1, 1, 0 }, { 0, 1, 1, 1, 0 }, { 1, 1, 0, 1, 0 } };

		System.out.println("Input array:");
		printArray(arr);

		lateralInversion(arr); // need to reverse the array left to right
		// and right to left

		System.out.println("Output array:");
		stateInversion(arr);
	}

	private static void lateralInversion(int[][] arr) {
		int rows = arr.length;
		int cols = arr[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols / 2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][cols - 1 - j];
				arr[i][cols - 1 - j] = temp;
				//arr[i][j]=arr[i][j]+arr[i][cols - 1 - j];
				//arr[i][cols - 1 - j]=arr[i][j]-arr[i][cols - 1 - j];
				//arr[i][j]=arr[i][j]-arr[i][cols - 1 - j];
			}
		}

		System.out.println("Lateral Inversion:");
		printArray(arr);
	}

	private static void stateInversion(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = arr[i][j] == 1 ? 0 : 1;
			}
		}

		System.out.println("State Inversion:");
		printArray(arr);
	}

	public static void printArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
