package leetcodeZoho7;

import java.util.*;

public class ArraySumExclusion {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 4};

        // 1️⃣ Calculate total sum
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        // 2️⃣ Count frequency sum for each number
        Map<Integer, Integer> freqSum = new HashMap<>();
        for (int num : arr) {
            freqSum.put(num, freqSum.getOrDefault(num, 0) + num);
        }

        // 3️⃣ Compute result
        for (int key : freqSum.keySet()) {
            int result = totalSum - freqSum.get(key);
            System.out.println(key + " → " + result);
        }
    }
}
