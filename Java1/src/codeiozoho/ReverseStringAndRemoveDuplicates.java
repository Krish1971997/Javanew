package codeiozoho;

import java.util.LinkedHashMap;
import java.util.Map;

public class ReverseStringAndRemoveDuplicates {
	public static void main(String[] args) {
		String s = "geeksfor geeks";
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for (int i = s.length() - 1; i > 0; i--) {
			if(Character.isDigit(s.charAt(i))
					||Character.isLetter(s.charAt(i))) {
				map.put(s.charAt(i), 0);
			}
		}
		
		for(Character mapprint:map.keySet()) {
			System.out.print(mapprint);
		}
	}
}
