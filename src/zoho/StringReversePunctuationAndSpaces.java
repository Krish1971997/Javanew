package zoho;

/**
 * You’re given a string as an input. You have to reverse the string by keeping
 * the punctuation and spaces. You have to modify the source string itself with
 * creating an another string. 
 * Input : A man, in the boat says : I see 1-2-3 in the sky
 * 
 * Output : y kse, ht ni3 21ee slsy : a sta o-b-e ht nin amA
 */

public class StringReversePunctuationAndSpaces {
	public static void main(String[] args) {
		String s = "A man, in the boat says : I see 1-2-3 in the sky";
		System.out.println(s);
		reverseString(s);
	}

	private static void reverseString(String s) {
		char[] ch = s.toCharArray();
		int n = ch.length;
		int start = 0;
		int end = n - 1;

		while (start < end) {
			if ((!Character.isDigit(ch[start])) && (!Character.isLetter(ch[start]))) {
				start++;
				continue;
			} else if ((!Character.isDigit(ch[end])) && (!Character.isLetter(ch[end]))) {
				end--;
				continue;
			} else {
				char temp = ch[start];
				ch[start] = ch[end];
				ch[end] = temp;
				start++;
				end--;
			}
		}
		System.out.println(String.valueOf(ch));
	}
}
