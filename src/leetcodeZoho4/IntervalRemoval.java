package leetcodeZoho4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class IntervalRemoval {

	public static void main(String[] args) {
		int[][] intervals = { { 1, 2 }, { 2,3 }, { 3, 4 }, { 1, 3 } };

		int result = minIntervalsToRemove(intervals);
		System.out.println("Minimum number of intervals to remove: " + result);
	}

	public static int minIntervalsToRemove(int[][] intervals) {
		if (intervals.length == 0)
			return 0;

		//Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
		Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		

		int count = 0;
		int end = intervals[0][1];

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] < end) {
				count++;
			} else
				end = intervals[i][1];
		}
		return count;
	}
}