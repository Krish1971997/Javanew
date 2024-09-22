package geeksforgeeksZoho;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CountFrequenciesOfAllElements {

	public static void main(String[] args) {
		int n = 5;
		int arr[] = { 2, 3, 3, 2, 5 };
		//int arr[] = { 4, 4, 4, 4, 4 };
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

		for (int i = 1; i <= n; i++) {
			map.put(i, 0);
		}

		for (int i = 0; i < arr.length; i++) {
			//Integer value = map.get(arr[i]);
			map.put(arr[i], map.get(arr[i]) + 1);
		}

		for (Entry<Integer, Integer> formap : map.entrySet()) {
			System.out.println(formap.getKey() + " -> " + formap.getValue());
		}
	}
}
