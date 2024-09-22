package leetcodeZoho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]] Output:
 * [[1,6],[8,10],[12,13],[15,18]]
 */
public class Z_MergeIntervals {
	public static void main(String[] args) {
		int[][] arr = { { 1, 3 }, { 12, 13 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		int[][] arr1 = mergeIntervals(arr);
		for (int[] interval : arr1) {
			System.out.println(Arrays.toString(interval));
		}
	}

	private static int[][] mergeIntervals(int[][] arr) {
		List<int[]> merged = new ArrayList<>();
		// Comparator.comparingInt(a -> a[0])
		//Arrays.sort(arr,(o1,o2)->o1[0] - o2[0]);
		Arrays.sort(arr,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
			
		});
		
		int current[] = arr[0];

	/*	for (int[] is : arr) {
			if (is[0] < current[1]) {
				current[1] = Math.max(is[1], current[1]);
			} else {
				merged.add(current);
				current = is;
			}
		} */
		
		for (int i = 1; i < arr.length; i++) {
			if (arr[i][0] < current[1]) {
				current[1] = Math.max(arr[i][0], current[1]);
			} else {
				merged.add(current);
				current = arr[i];
			}
		}
		merged.add(current);
		return merged.toArray(new int[merged.size()][]);
	}
}
