package qspiders;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Maxelement_slidingwindow {

	public static void main(String[] args) {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		int[] res = maxSlidingWindow(nums, k);
		System.out.println(Arrays.toString(res));
	}

	public static int[] maxSlidingWindow(int[] nums, int k) {

		int n = nums.length;
		int[] result = new int[n - k + 1];
		Deque<Integer> deque = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			// Remove indices out of the current sliding window
			while (!deque.isEmpty() && deque.peek() < i - k + 1) {
				deque.poll();
			}

			// Remove smaller elements from the tail of the deque
			while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
				deque.pollLast();
			}

			// Add the current index to the deque
			deque.offer(i);

			// Add maximum element to the result array when window size reaches k
			if (i >= k - 1)
				result[i - k + 1] = nums[deque.peek()];
		}
		return result;
	}
}

/*
 * int length=nums.length; int[] res=new int[length-k];
 * 
 * for(int i=0;i<length-k;i++){ int max=Integer.MIN_VALUE; for(int
 * j=i;j<k+i;j++){ max=Math.max(max,nums[i]); } res[i]=max; } return res;
 */
