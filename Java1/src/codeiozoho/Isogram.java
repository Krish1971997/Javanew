package codeiozoho;

import java.util.LinkedHashMap;
import java.util.Map;

public class Isogram {
	public static void main(String[] args) {
		String s="Machine ";
		if(!isogram(s)) {
			System.out.println(s+" this word is not isogram");
		}else
			System.out.println(s+" this word is isogram");
	
	}
	public static boolean isogram(String s) {
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for(int i=0;i<s.length();i++) {
			if(map.containsKey(s.charAt(i))) {
				return false;
			}
			map.put(s.charAt(i), 1);
		}
		return true;
	}
}
