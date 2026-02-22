package leetcodeZoho8;

public class FrequencyCheck {

	public static void printElements(int[] arr, int frq) {
		int count = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[i - 1]) {
				count++;
			} else {
				if (count > frq) {
					System.out.println(arr[i - 1] + " -> " + count);
				}
				count = 1;
			}
		}

		// Check last element group
		if (count > frq) {
			System.out.println(arr[arr.length - 1] + " -> " + count);
		}
	}

	public static void main(String[] args) {

		int[] input = { 1, 1, 1, 2, 2, 2, 2, 2, 4, 5, 5, 5, 5, 10, 10, 10, 10, 22, 22, 22 };
		int frq = 3;

		printElements(input, frq);
	}
}