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
	
//    public static void main(String[] args) {
//        String s = "00:24";
//        System.out.println(findGreatestTime(s)); // Output: "24:00"
//    }
//
//    private static String findGreatestTime(String s) {
//        List<Integer> digits = new ArrayList<>();
//        
//        // Extract digits from the input string
//        for (int i = 0; i < s.length(); i++) {
//            if (Character.isDigit(s.charAt(i))) {
//                digits.add(s.charAt(i) - '0');
//            }
//        }
//
//        // Generate all permutations of the digits
//        List<String> validTimes = new ArrayList<>();
//        generatePermutations(digits, "", validTimes);
//
//        // Find the greatest valid time
//        String greatestTime = "00:00";
//        for (String time : validTimes) {
//            int hour = Integer.parseInt(time.substring(0, 2));
//            int minute = Integer.parseInt(time.substring(2, 4));
//
//            // Check if the time is valid (hours between 00-23, minutes between 00-59)
//            if (hour <= 23 && minute <= 59) {
//                if (hour > Integer.parseInt(greatestTime.substring(0, 2)) ||
//                    (hour == Integer.parseInt(greatestTime.substring(0, 2)) && minute > Integer.parseInt(greatestTime.substring(3)))) {
//                    greatestTime = time;
//                }
//            }
//        }
//        return greatestTime.substring(0, 2) + ":" + greatestTime.substring(2);
//    }
//
//    // Generate all permutations of the digits and store the valid time strings
//    private static void generatePermutations(List<Integer> digits, String current, List<String> validTimes) {
//        if (current.length() == 4) {
//            validTimes.add(current); // When we have 4 digits, store it as a potential time
//            return;
//        }
//
//        for (int i = 0; i < digits.size(); i++) {
//            List<Integer> remaining = new ArrayList<>(digits);
//            remaining.remove(i);
//            generatePermutations(remaining, current + digits.get(i), validTimes);
//        }
//    }

}
