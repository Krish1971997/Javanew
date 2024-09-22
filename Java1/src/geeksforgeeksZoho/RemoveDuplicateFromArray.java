package geeksforgeeksZoho;

public class RemoveDuplicateFromArray {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 2, 3, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5 };
		// 1st method
		/*for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1])
				arr[i] = -1;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != -1)
				System.out.print(arr[i] + " ");
		} */

		// 2nd method
		int unique = 0;
		for (int i = 0; i < arr.length - 1; i++)
			if (arr[i] != arr[i + 1]) {
				int temp = arr[unique];
				arr[unique++] = arr[i];
				arr[i] = temp;
			}
		arr[unique++] = arr[arr.length - 1];

		for (int i = 0; i < unique; i++)
			System.out.println(arr[i]);
	}
}
