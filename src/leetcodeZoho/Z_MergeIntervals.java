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
		int[][] arr =  {{1,3},{2,6},{8,10},{15,18}};
		int[][] arr1 = mergeIntervals(arr);
		for (int[] interval : arr1) {
			System.out.println(Arrays.toString(interval));
		}
	}

	private static int[][] mergeIntervals(int[][] intervals) {
	//	Arrays.sort(intervals,Comparator.comparingInt(ar -> ar[0]));
		Arrays.sort(intervals,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
			
		}); 
	
		List<int[]> result = new ArrayList<>();

        int[] current = intervals[0];
        result.add(current);

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] <= current[1]) {
                // Overlapping → merge
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                // No overlap
                current = intervals[i];
                result.add(current);
            }
        }

        return result.toArray(new int[result.size()][]);
	
	}
}
