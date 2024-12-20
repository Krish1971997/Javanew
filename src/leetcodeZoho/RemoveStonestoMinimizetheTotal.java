package leetcodeZoho;

import java.util.PriorityQueue;

public class RemoveStonestoMinimizetheTotal {

	public static void main(String[] args) {
		int[] piles = { 6, 4, 9 };
		int k1 = 2;
		int n = removestones(piles, k1);
		System.out.println(n);
		
        int[] piles2 = {4, 3, 6, 7};
        int k2 = 3;
		int n1 = removestones(piles2, k2);
		System.out.println(n1);
	}

	public static int removestones(int[] piles, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
		/**
		 * default ascending order .
		 * a-b is negative means a first then b
		 * a-b is positive means b first then a
		 * 
		 * decending order
		 * b-a is negative means b first then a
		 * b-a is positive means a first then b 
		 */
		for (int pile : piles) {
			maxHeap.offer(pile);
		}

		for (int i = 0; i < k; i++) {
			int maxPile = maxHeap.poll();
			int newPile = maxPile - (maxPile / 2);
			maxHeap.offer(newPile);
		}

		int totalStones = 0;
		for (int pile : maxHeap) 
			totalStones += pile;		
		return totalStones;
	}
}
