package zohofirstRound_31aug;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class Program2 {

	public static void main(String[] args) {
		String s = "zohO";
		System.out.println(sortOccurence(s));
	}

	public static String sortOccurence(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(map.get(s.charAt(i)),0) + 1);
		}
		List<ElementFrequency> list = new LinkedList<>();
		for (Entry<Character, Integer> listMap : map.entrySet())
			list.add(new ElementFrequency(listMap.getKey(), listMap.getValue(), s.indexOf(listMap.getKey())));
		
	/*	Collections.sort(list, (o1, o2) -> {
			if (o1.frequency == o2.frequency)
				return o1.index > o2.index ? 1 : -1;
			return o1.frequency > o2.frequency ? -1 : 1;
		});

	*/	for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                ElementFrequency o1 = list.get(j);
                ElementFrequency o2 = list.get(j + 1);

                if (o1.frequency < o2.frequency ||
                    (o1.frequency == o2.frequency && o1.index > o2.index)) {
                    list.set(j, o2);
                    list.set(j + 1, o1);
                }
            }
        } 
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			ElementFrequency freqlist = list.get(i);
			char ch = freqlist.element;
			int frequency = freqlist.frequency;
			for (int j = 0; j < frequency; j++)
				sb.append(ch);
		}
		return sb.toString();
	}
}

class ElementFrequency {
	char element;
	int frequency;
	int index;

	public ElementFrequency(char element, int frequency, int index) {
		super();
		this.element = element;
		this.frequency = frequency;
		this.index = index;
	}
}
