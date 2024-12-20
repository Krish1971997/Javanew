package zohofirstRound_31aug;

public class Roman {
	public static void main(String[] args) {
		String s = "MMMMMMMMCDXXVIII";
		System.out.println(findNumericValue(s));
	}

	private static int findNumericValue(String s) {
		char[] key = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
		int[] value = { 1, 5, 10, 50, 100, 500, 1000 };
		int result = 0;
		int prevalue = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			int idx = getIndex(s.charAt(i), key);
			if (idx>=0&&value[idx] < prevalue)
				result -= value[idx];
			else
				result += value[idx];
			prevalue = value[idx];
		}
		return result;
	}

	private static int getIndex(char ch, char[] key) {
		for (int i = 0; i < key.length; i++) {
			if (ch == key[i])
				return i;
		}
		return -1;
	}

}
