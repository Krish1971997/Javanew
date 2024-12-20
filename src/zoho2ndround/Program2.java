package zoho2ndround;

import java.util.*;

public class Program2 {

	public static void main(String[] args) {
		//int[] arr = { 2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12 };
		// int[] arr = { 0, 2, 1, -1, 1, 2, 0, 4, -1, 4 };
		 int[] arr= {4,6,8,2,5,7,9};
		arr = findFrequencyElements(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (arr.length - 1 > i)
				System.out.print(",");
		}
	}

	private static int[] findFrequencyElements(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++)
			map.put(arr[i], getOrDefault(map, arr[i]) + 1);

		List<ElementFrequency> list = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet())
			list.add(new ElementFrequency(entry.getKey(), entry.getValue()));

		Collections.sort(list, new Comparator<ElementFrequency>() {
			@Override
			public int compare(ElementFrequency o1, ElementFrequency o2) {
				if (o1.frequency == o2.frequency)
					return o1.element - o2.element;
				return o2.frequency - o1.frequency;
			}
		});

		int index = 0;
		for (int i = 0; i < list.size(); i++) {
			ElementFrequency el = list.get(i);
			for (int j = 0; j < el.frequency; j++)
				arr[index++] = el.element;
		}
		return arr;
	}

	public static int getOrDefault(Map<Integer, Integer> map, int key) {
		return map.containsKey(key) ? map.get(key) : 0;
	}
}

class ElementFrequency {
	int element;
	int frequency;

	public ElementFrequency(int element, int frequency) {
		this.element = element;
		this.frequency = frequency;
	}
}
