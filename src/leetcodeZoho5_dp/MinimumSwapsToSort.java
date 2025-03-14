package leetcodeZoho5_dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//working
public class MinimumSwapsToSort {
	public static void swap(int[] arr) {
        int swap = 0;
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
           // int min = arr[i];
            int min_index = i;

            // Find the minimum element in the unsorted part of the array
            for (int j = i + 1; j < arr.length; j++) {
            	if (arr[j] < arr[min_index]) { //if (arr[j] < min) {
                    //min = arr[j];
                    min_index = j;
                }
            }

            // If the minimum element is not at the correct position, swap it
            if (min_index != i) {
                list.add(new int[]{i, min_index});
                swap++;

                // Perform the swap
                int temp = arr[i];
                arr[i] = arr[min_index];
                arr[min_index] = temp;
            }
        }

        System.out.println("Number of swaps: " + swap);
        System.out.println("Swapped indices:");
        for (int[] a : list) {
            System.out.println(a[0] + " <--> " + a[1]);
        }
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] temp = {3, 2, 4, 1, 5};
        System.out.println("Original Array: " + Arrays.toString(temp));
        swap(temp);
    }

}
//public static int minSwaps(int[] arr) {
//        int n = arr.length;
//
//        int[][] pairs = new int[n][2];
//        for (int i = 0; i < n; i++) {
//            pairs[i][0] = arr[i]; // Element value
//            pairs[i][1] = i;      // Original index
//        }
//
//        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
//
//        // Visited array to mark visited indices
//        boolean[] visited = new boolean[n];
//        int swaps = 0;
//
//        for (int i = 0; i < n; i++) {
//            // If already visited or already in correct position, skip
//            if (visited[i] || pairs[i][1] == i) continue;
//
//            int cycleSize = 0;
//            int j = i;
//
//            while (!visited[j]) {
//                visited[j] = true;
//                j = pairs[j][1]; // Move to the next index in the cycle
//                cycleSize++;
//            }
//
//            // If cycle size is `n`, we need `n-1` swaps
//            if (cycleSize > 1) {
//                swaps += (cycleSize - 1);
//            }
//        }
//
//        return swaps;
//    }
//
//    public static void main(String[] args) {
//        int[] arr = {4, 3, 2, 1};
//        System.out.println("Minimum swaps needed: " + minSwaps(arr)); // Output: 2
//
//        int[] arr2 = {1, 5, 4, 3, 2};
//        System.out.println("Minimum swaps needed: " + minSwaps(arr2)); // Output: 2
//    }
//}
