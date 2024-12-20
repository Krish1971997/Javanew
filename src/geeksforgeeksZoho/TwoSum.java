package geeksforgeeksZoho;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	    public static void main(String[] args) {
	        int[] arr1 = { 15, 2, 4, 8, 9, 5, 10, 23 };
	        int targetSum = 23;
	        hasPairWithSum(arr1, targetSum); // Output: Yes
	    }

	    static void hasPairWithSum(int[] arr, int targetSum) {
	        Map<Integer, Integer> map = new HashMap<>();

	        for (int i = 0; i < arr.length; i++) {
	            int complement = targetSum - arr[i];
	            
	            if (map.containsKey(complement)) {
	                System.out.println("Pairs: (" + (map.get(complement)+1) + ", " + (i+1) + ")");
	            }
	            map.put(arr[i], i);
	        }

	    	//return false;
/*	        int left = 0;
	        int right = arr.length - 1;

	        while (left < right) {
	            int currentSum = arr[left] + arr[right];

	            if (currentSum == targetSum) {
	                return true; // Pair with the given sum found
	            } else if (currentSum < targetSum) {
	                left++;
	            } else {
	                right--;
	            }
	        }
	        return false; // No pair with the given sum found
	        */
	    }
	}

