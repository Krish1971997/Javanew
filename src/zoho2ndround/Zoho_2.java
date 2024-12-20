package zoho2ndround;

public class Zoho_2 {

	public static void main(String[] args) {
		System.out.println(reverseVowels("hello"));
		System.out.println(reverseVowels("Zoho Corporation"));
	}

	private static String reverseVowels(String s) {
		char[] strArray = s.toCharArray();

		int start = 0;
		int end = strArray.length - 1;

		while (start <= end) {
			if (!isVowels(strArray[start])) {
				start++;
			} else if (!isVowels(strArray[end])) {
				end--;
			} else {
				char temp=strArray[start];
				strArray[start]=strArray[end];
				strArray[end]=temp;
				start++;
				end--;
			}
		}
		return String.valueOf(strArray);
	}

	public static boolean isVowels(char c) {
		return "aeiouAEIOU".indexOf(c) != -1;
	}
}
