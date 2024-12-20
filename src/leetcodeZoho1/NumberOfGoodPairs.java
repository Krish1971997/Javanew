package leetcodeZoho1;

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 1, 3}; // Expected output: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
        // int[] nums= {1,2,3};
        int count = numIdenticalPairs(nums);
        System.out.println("Total number of good pairs: " + count);
    }

    public static int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            if (map.containsKey(num)) {
                count += map.get(num); // Add the number of occurrences so far to the count
                map.put(num, map.get(num) + 1);
            } else 
                map.put(num, 1);
        }

        return count;
    }
}
