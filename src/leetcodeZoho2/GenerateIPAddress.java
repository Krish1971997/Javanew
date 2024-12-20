package leetcodeZoho2;

import java.util.*;

public class GenerateIPAddress {
	static int count=0;
    public static void main(String[] args) {
        List<String> str = restoreIpAddresses("1921680168");
        str.forEach(n -> System.out.println(n));
       // System.out.println("Count -> "+count);
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(String s, int start, List<String> segments, List<String> res) {
    	//count++;
    	//System.out.println("segments - "+count+" - >"+segments);
        if (segments.size() == 4) {
            if (start == s.length()) {
                //res.add(String.join(".", segments));
            	res.add(segments.get(0) + "." + segments.get(1) + "." + segments.get(2) + "." + segments.get(3));
                return;
            }
            return;
        }

        for (int i = start; i < s.length(); i++) {
             String segment = s.substring(start, i + 1);
            // Check if the segment has leading zeroes or is greater than 255
            if (segment.length() > 1 && segment.charAt(0) == '0') {
                continue;
            }
            if (segment.length() > 3 || Integer.parseInt(segment) > 255) {
                continue;
            }
            segments.add(segment);
             backtrack(s, i + 1, segments, res);
            segments.remove(segments.size() - 1);
        }
    }
}