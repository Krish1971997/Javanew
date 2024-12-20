package geeksforgeeksZoho_1;

import java.util.LinkedHashMap;
import java.util.Map;

public class StringChallange {

	static Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();

	public static void main(String[] args) {
		String token = "qoy5kueb4f";
		String input = "wwwbbbw";
		System.out.println("Token :"+token);
		String output = getOutput(input);
		System.out.println("output "+output);
		String FinalOutput = getFinalOutput(output, token);
		System.out.println("Final -> "+FinalOutput);

	}

	public static String getOutput(String input) {
		for (int i = 0; i < input.length(); i++) {
			map.put(input.charAt(i), getOrDefault(input.charAt(i)));
		}
		String s = "";
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			s += entry.getValue() + "" + entry.getKey();
		}

		return s;
	}

	public static int getOrDefault(char c) {
		if (map.containsKey(c)) {
			int res = map.get(c);
			return res + 1;
		}
		return 1;
	}

	public static String getFinalOutput(String output, String token) {

		int i = 0, j = 0;
		String res = "";
		while (i < output.length() && j < token.length()) {
			res += output.charAt(i)+"" + token.charAt(i);
			i++;
			j++;
		}

		while (i < output.length()) {
			res += output.charAt(i);
			i++;
		}
		
		while (j < token.length()) {
			res += token.charAt(j);
			j++;
		}

		return res;
	}
}
