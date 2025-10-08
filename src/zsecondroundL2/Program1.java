package zsecondroundL2;

public class Program1 {
	public static void main(String[] args) {
		String str = "a1b2c34c3b2cb3a1d";
		System.out.println(removeDuplicateCharacters(str));
	}

	private static String removeDuplicateCharacters(String str) {

		char[] string = str.toCharArray();
		int n = str.length();
		boolean[] Alphabetic = new boolean[26];
		int[] numbers = new int[10];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = -1;
		}

		for (int i = 0; i < n; i++) {
			if (isAlphabetic(str.charAt(i))) {
				int ch = str.charAt(i) - 'a';
				if (!Alphabetic[ch]) {
					Alphabetic[ch] = true;
				} else
					string[i] = '#';
			}
		}

		for (int i = 0; i < n; i++) {
			if (isDigit(str.charAt(i))) {
				int num = str.charAt(i) - '0';
				if (numbers[num] != -1) {
					string[numbers[num]] = '#';
				}
				numbers[num] = i;
			}
		}

		char[] ch = new char[str.length()];
		int index = 0;
		for (int i = 0; i < string.length; i++) {
			if (string[i] != '#') {
				ch[index++] = string[i];
			}
		}

		return new String(ch);
	}
	
	public static boolean isAlphabetic(char ch) {
		return ch>='a' && ch<='z';
	} 
	
	public static boolean isDigit(char ch) {
		return ch>='0' && ch<='9';
	} 


}
