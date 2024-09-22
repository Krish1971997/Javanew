package geeksforgeeksZoho;

import java.util.LinkedHashMap;
import java.util.Map;

public class FrequenciesofLimitedRangeArrayElements {
	public static void main(String[] args) {
		int arr[] = { 2, 3, 2, 3, 5 };
		int n = 5;
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		int start = 1;
		
		for (int i = 0; i < n; i++) {
			map.put(start, 0);
			start++;
		}
		
		for (int i : arr) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);	
			}
		}

		for (Map.Entry<Integer, Integer> forloop : map.entrySet()) {
			System.out.println(forloop.getKey() + " -> " + forloop.getValue());
		}
	}
}
