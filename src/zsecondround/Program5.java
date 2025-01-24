package zsecondround;

import java.util.HashMap;

public class Program5 {
	public static void main(String[] args) {
		String note = "ZOHO";
		String collection = "HOOZORPC";
//		String note = "INTERVIEW";
//		String collection = "ITVERWN";

		System.out.println((findCollectionOfLetters(note, collection)));

	}

	private static boolean findCollectionOfLetters(String note, String col) {

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < col.length(); i++)
			map.put(col.charAt(i), map.getOrDefault(col.charAt(i), 0) + 1);

		for (int i = 0; i < note.length(); i++) {
			char key = note.charAt(i);
			if (map.get(key) > 0)
				map.put(key, map.get(key) - 1);
			else
				return false;
		}

		return true;
	}

}
