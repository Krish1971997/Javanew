package prepinsta;

import java.util.Arrays;
import java.util.TreeSet;

public class FindDuplicatesArray {
	public static void main(String[] args) {
		int[] a = { 16, 7, 5, 23, 5, 18, 23, 15, 5, 13, 18, 10, 22, 5, 17, 14, 5, 3, 15, 5, 12, 11, 15, 16, 9, 4, 15 };
		TreeSet<Integer> ans = duplicates(a);
		System.out.println(ans);
	}

	public static TreeSet<Integer> duplicates(int arr[]) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		Arrays.sort(arr);
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[i - 1])
				set.add(arr[i]);
		}
		if (set.size() == 0)
			set.add(-1);
		return set;
	}
}