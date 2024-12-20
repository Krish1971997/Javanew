package zoho2ndround;

import java.util.Arrays;

public class Zoho_3 {

	public static void main(String[] args) {
		int[] n1 = { 1, 3 };
		int[] n2 = { 2 };
		median(n1, n2);

		int[] m1 = { 1, 2 };
		int[] m2 = { 3, 4 };
		median(m1, m2);
	}

	private static void median(int[] arr1, int[] arr2) {
		int a = arr1.length, b = arr2.length;
		int i = 0, j = 0, k = 0;
		int arr[] = new int[a + b];

		while (i < a && j < b) {
			if (arr1[i] > arr2[j])
				arr[k++] = arr2[j++];
			else
				arr[k++] = arr1[i++];
		}

		while (i < a)
			arr[k++] = arr1[i++];

		while (j < b)
			arr[k++] = arr2[j++];

		System.out.println(Arrays.toString(arr));
		double ans = 0.0;
		if (arr.length % 2 == 0) {
			ans = (double) (arr[arr.length / 2] + arr[(arr.length - 1) / 2]) / 2;
		} else {
			ans = (double) arr[arr.length / 2];
		}
		System.out.println("Ans : " + String.format("%.5f", ans));
	}
}
