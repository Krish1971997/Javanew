package leetcodeZoho5_dp;

import java.util.HashSet;

public class UnsortedArrayWithDuplicateValues {

	public static void main(String[] args) {
		int[] arr = { 2, 2, 2, 2, 5, 5, 108, 3, 1 };

		HashSet<Integer> existing = new HashSet<>();
		HashSet<Integer> visited = new HashSet<>();

		for (int val : arr) {
			existing.add(val);
		}

		for (int i = 0; i < arr.length; i++) {
			if (!visited.contains(arr[i])) {
				visited.add(arr[i]);
				continue;
			}

			int nextElement = arr[i];
			do {
				nextElement++;
			} while (existing.contains(nextElement) || visited.contains(nextElement));

			arr[i] = nextElement;
			visited.add(nextElement);
		}

		for (int val : arr) {
			System.out.print(val + " ");
		}
	}
}
