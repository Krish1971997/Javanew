package leetcodeZoho4;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EqualFrequency {

	public static void main(String[] args) {
		String input1 = "cdcddca";
		String input2 = "aaabbbcc";

		System.out.println(canEqualFrequency(input1)); // Output: true
		System.out.println(canEqualFrequency(input2)); // Output: false
	}

	public static boolean canEqualFrequency(String s) {
		Map<Character, Integer> frequencyMap = new HashMap<>();

		for (char c : s.toCharArray())
			frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);

		Map<Integer, Integer> countMap = new HashMap<>();
		for (int freq : frequencyMap.values())
			countMap.put(freq, countMap.getOrDefault(freq, 0) + 1);

		if (countMap.size() == 1) {
			return true;
		} else if (countMap.size() == 2) {
			Integer[] freqs = toArray(countMap.keySet());
			int freq1 = freqs[0];
			int freq2 = freqs[1];
			int count1 = countMap.get(freq1);
			int count2 = countMap.get(freq2);

			// Check the two conditions:
			// 1. One frequency can be reduced by 1
			// 2. One of the frequencies is 1 and has only one character
			if ((Math.abs(freq1 - freq2) == 1) && 
					(count1 == 1 || count2 == 1))
				return true;

			if ((freq1 == 1 && count1 == 1) || 
					(freq2 == 1 && count2 == 1))
				return true;
		}

		return false;
	}
	
	
	static Integer[] toArray(Set<Integer> set) {
		Integer[] arr=new Integer[set.size()];
		int i=0;
		for (Integer integer : set) 
			arr[i++]=integer;
		return arr;		
	}
}