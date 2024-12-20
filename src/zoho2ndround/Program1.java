package zoho2ndround;

import java.util.*;

public class Program1 {

	public static void main(String[] args) {
		String s = "00:24";
		System.out.println(findGreatestTime(s));
	}

	private static String findGreatestTime(String s) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < s.length(); i++) {
			int ch = s.charAt(i) - '0';
			if (ch >= 0 && ch <= 9)
				list.add(ch);
		}
		int hours = findTime(list, 0, 23, 0);
		list = removeDigits(hours, list);
		int minutes = findTime(list, 0, 59, 0);
		return hours+":"+(minutes<9?"0"+minutes:minutes);
	}

	private static int findTime(List<Integer> list, int start, int end, int time) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (i != j) {
					int hours = list.get(i) * 10 + list.get(j);
					if (hours >= start && end >= hours && time < hours)
						time = hours;
				}
			}
		}
		return time;
	}

	private static List<Integer> removeDigits(int hours, List<Integer> list) {
		while (hours > 0) {
			Integer remove = hours % 10;
			list.remove(remove);
			hours /= 10;
		}
		return list;
	}
}
