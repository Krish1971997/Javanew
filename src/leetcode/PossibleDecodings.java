package leetcode;


import java.util.HashMap;
import java.util.Map;

public class PossibleDecodings {
	public static void main(String[] args) {
		char ch='A';
		Map<Integer, Character> decode=new HashMap<>();
		for (int i = 0; i < 26; i++,ch++) {
			decode.put(i, ch);
		}
		
		for (Map.Entry<Integer, Character> entry : decode.entrySet()) {
			Integer key = entry.getKey();
			Character val = entry.getValue();
			System.out.println(key+" ---> "+val);
			
		}
	}
}
