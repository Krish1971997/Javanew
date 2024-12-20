package geeksforgeeksZoho;

import java.util.*;
import java.util.ArrayList;

class ElementFrequency {
	int element;
	int frequency;

	public ElementFrequency(int element, int frequency) {
		this.element = element;
		this.frequency = frequency;
	}
}

public class Sortelementsbyfrequency {

	public static void main(String[] args) {
		int[] arr1 = { 2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8 };
		sortByFrequency(arr1);
		printArray(arr1); // Output: [8, 8, 8, 2, 2, 5, 5, 6]
	}

	static void sortByFrequency(int[] arr) {
		Map<Integer, Integer> frequencyMap = new HashMap<>();

		for (int num : arr) {
			if (frequencyMap.containsKey(num))
				frequencyMap.put(num, frequencyMap.get(num) + 1);
			else
				frequencyMap.put(num, 1);
		}

		List<ElementFrequency> elementFrequencyList = new ArrayList<ElementFrequency>();
		for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
			elementFrequencyList.add(new ElementFrequency(entry.getKey(), entry.getValue()));
		}

		Collections.sort(elementFrequencyList, new Comparator<ElementFrequency>() {
			@Override
			public int compare(ElementFrequency o1, ElementFrequency o2) {
				return Integer.compare(o2.frequency, o1.frequency);
			}
		});
		
		
	/*	elementFrequencyList.sort((o1,o2)-> {
			return Integer.compare(o2.frequency,o1.frequency);}); */

		// Update the original array with sorted elements
		int index = 0;
		for (ElementFrequency ef : elementFrequencyList) {
			int element = ef.element;
			int frequency = ef.frequency;
			for (int i = 0; i < frequency; i++) {
				arr[index++] = element;
			}
		}

		/**
		 * https://leetcode.com/problems/top-k-frequent-elements int num=3;
		 * Map<Integer,Integer> removeduplicate=new HashMap<Integer, Integer>(); for
		 * (int i = 0; i < elementFrequencyList.size()&&num>removeduplicate.size(); i++)
		 * { int element = elementFrequencyList.get(0).element; int frequency =
		 * elementFrequencyList.get(0).frequency; removeduplicate.put(arr[i], 0); } for
		 * (Map.Entry<Integer,Integer> printmap : removeduplicate.entrySet()) {
		 * System.out.println(printmap.getKey()); }
		 */
	}

	// Function to print an array
	static void printArray(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
}
