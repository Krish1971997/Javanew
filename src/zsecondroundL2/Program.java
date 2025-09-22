package l2Programming;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of the array:");
		int length = sc.nextInt();
		int[] arr = new int[length];
		System.out.println("Enter the " + length + " numbers");
		for (int i = 0; i < length; i++) {
			arr[i] = sc.nextInt();
		}

		// int[] arr = { 9, 4, 3, 2, 7, 8, 5 };

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if ((arr[i] % 2 == 0 && arr[j] % 2 == 0 && arr[i] < arr[j])
						|| (arr[i] % 2 != 0 && arr[j] % 2 != 0 && arr[i] > arr[j])) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (arr.length - 1 > i) {
				System.out.print(", ");
			}
		}
	}

}
