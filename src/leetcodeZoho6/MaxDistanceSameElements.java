package leetcodeZoho6;

import java.util.*;

public class MaxDistanceSameElements {

    public static int maxDistance(int[] arr) {
        Map<Integer, Integer> firstIndexMap = new HashMap<>();
        int maxDist = 0;

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            if (!firstIndexMap.containsKey(val)) {
                firstIndexMap.put(val, i); // Store first occurrence
            } else {
                int distance = i - firstIndexMap.get(val);
                maxDist = Math.max(maxDist, distance);
            }
        }
        return maxDist;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 2, 1};
        int[] arr2 = {1, 1, 1, 1};
        int[] arr3 = {5, 6, 7, 8, 9};

        System.out.println("Max Distance (arr1): " + maxDistance(arr1)); // 4
        System.out.println("Max Distance (arr2): " + maxDistance(arr2)); // 3
        System.out.println("Max Distance (arr3): " + maxDistance(arr3)); // 0
    }
}
