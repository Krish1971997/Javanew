package zohofirstRound_31aug;

public class Program1 {
	public static void main(String[] args) {
		String input = "mmkdewtr";
		String word = vowelsCheck(input);
		if (word.length()>0&&isPalindrome(word))
			System.out.println("True");
		else
			System.out.println("False");
	}

	private static String vowelsCheck(String input) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			if ("aeiouAEIOU".indexOf(input.charAt(i))!=-1)
				sb.append(input.charAt(i));
		}
		return sb.toString();
	}
	
	public static boolean isPalindrome(String word) {
		int start = 0;
		int end = word.length() - 1;
		while (start < end) {
			if (word.charAt(start) != word.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}

}
