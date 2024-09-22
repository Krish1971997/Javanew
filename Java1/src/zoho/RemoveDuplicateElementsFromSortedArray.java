package zoho;

import java.util.Arrays;

public class RemoveDuplicateElementsFromSortedArray {
	public static void main(String[] args) {
		int[] A = { 1, 1, 3, 3, 4, 4, 5, 6, 6, 12, 12, 13, 17, 17, 19, 19, 22 };
		System.out.println(Arrays.toString(A));
		int distinctCount = remove_duplicate(A, A.length);
		for (int i = 0; i < distinctCount; i++) {
			System.out.print(A[i] + " ");
		}
	}

	static int remove_duplicate(int A[], int N) {
		int distinctCount = 1;
		for (int i = 1; i < A.length; i++) {
			if (A[i] != A[i - 1]) {
				A[distinctCount] = A[i];
				distinctCount++;
			}
		}
		return distinctCount;
	}
}
