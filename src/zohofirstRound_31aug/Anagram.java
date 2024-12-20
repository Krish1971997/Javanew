package zohofirstRound_31aug;

public class Anagram {
	public static void main(String[] args) {
		String s1 = "listenl98";
		String s2 = "89lsilent";
		if (isAnagram(s1, s2))
			System.out.println("Yes");
		else
			System.out.println("No");
	}

	private static boolean isAnagram(String s1, String s2) {
		int first = s1.length();
		int second = s2.length();
		if (first != second)
			return false;
		char[] key = new char[first];
		int[] value = new int[first];

		for (int i = 0; i < first; i++) {
			int idx = getIndex(s1.charAt(i), key);
			if (idx >= 0) {
				value[idx]++;
			} else {
				key[i] = s1.charAt(i);
				value[i]++;
			}
		}
		for (int i = 0; i < value.length; i++) {
			if (value[i] != '\0' && !compareArrays(key[i], value[i], s2))
				return false;
		}
		return true;
	}

	private static boolean compareArrays(char key, int value, String s) {
		int count = 0;
		for (int j = 0; j < s.length(); j++) {
			if (s.charAt(j) == key)
				count++;
		}

		if (count != value)
			return false;

		return true;
	}

	private static int getIndex(char ch, char[] key) {
		for (int i = 0; i < key.length; i++) {
			if (ch == key[i])
				return i;
		}
		return -1;
	}
}
