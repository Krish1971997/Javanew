package zoho;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class SortElementsByFrequency {

	static LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
	public static void main(String[] args) {

		int arr[] = { 2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8, 6 };
		for (int i : arr) {
			map.put(i, map.getOrDefault(i, 0) + 1);
			//map.put(i, getOrDefault(i, 0) + 1);
			
		}

		List<Entry<Integer, Integer>> list = new LinkedList<Entry<Integer, Integer>>(map.entrySet());
		
		list.sort((o1,o2) ->{
			return o2.getValue().compareTo(o1.getValue());
		});

	/*	Collections.sort(list, new Comparator<Entry<Integer, Integer>>() {
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
*/
		map.clear();
		for (Entry<Integer, Integer> entry : list) {
			map.put(entry.getKey(), entry.getValue());
		}

		for (Entry<Integer, Integer> i : map.entrySet()) {
			System.out.println(i.getKey() + " --> " + i.getValue());
		}
	}
	
	public static int getOrDefault(Integer i,int defaultValue) {
		int res=map.get(i);
		return res+defaultValue;
	}
}
