package geeksforgeeksZoho;

import java.util.HashMap;
import java.util.Map.Entry;

//https://www.geeksforgeeks.org/problems/find-duplicates-in-an-array/
//1?page=1&company=Zoho&sortBy=submissions
public class FindDuplicatesInAnArray {

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 6, 3, 6, 1};
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i]))
				map.put(arr[i], 1);
			else {
				int value = map.get(arr[i]);
				map.put(arr[i], value + 1);
			}
		}

		for (Entry<Integer, Integer> i : map.entrySet()) {
			if (i.getValue() > 1)
				System.out.println(i.getKey());
		}
	}
}
