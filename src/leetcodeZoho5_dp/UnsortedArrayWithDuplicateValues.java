package leetcodeZoho5_dp;

import java.util.HashSet;

public class UnsortedArrayWithDuplicateValues {

	public static void main(String[] args) {
		int[] ary = { 2, 2, 2, 2, 5, 5, 108, 3, 1 };

		HashSet<Integer> existing = new HashSet<>();
		HashSet<Integer> visited = new HashSet<>();

		for (int val : ary) {
			existing.add(val);
		}

		for (int i = 0; i < ary.length; i++) {
			if (!visited.contains(ary[i])) {
				visited.add(ary[i]);
				continue;
			}

			int nextEle = ary[i];
			do {
				nextEle++;
			} while (existing.contains(nextEle) || visited.contains(nextEle));

			ary[i] = nextEle;
			visited.add(nextEle);
		}

		for (int val : ary) {
			System.out.print(val + " ");
		}
	}
}
