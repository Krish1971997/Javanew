package zoho2ndround;

public class Program3 {

	public static void main(String[] args) {
		// String string = "aaczabc";
		// String pattern = "2113";

		String string = "aocabc";
		String pattern = "1oc3";

		boolean isMatch = IsMatchString(string, pattern);
		System.out.println(isMatch);
	}

	private static boolean IsMatchString(String string, String pattern) {
		int slen = string.length();
		int plen = pattern.length();

		if (slen < plen) {
			return false;
		}

		int skipCount = 0;
		int remainingCount = 0;
		char ch = '\0';
		int j = 0;
		for (int i = 0; i < slen; i++) {
			if (string.charAt(i) != pattern.charAt(j)) {
				if (isDigit(pattern.charAt(j))) {
					if (skipCount == 0) {
						skipCount = getNumericValue(pattern.charAt(j));
						ch = string.charAt(i);
						remainingCount = skipCount;
					}
					if (skipCount > 1 && !(ch == string.charAt(i) || ++ch == string.charAt(i)))
						return false;
					remainingCount--;
				} else
					return false;
			}
			if (remainingCount == 0 && j < plen)
				skipCount = 0;
			if (j < plen - 1)
				j++;
		}

		return true;
	}

	public static boolean isDigit(char ch) {
		int num = ch - '0';
		if (num >= 0 && num <= 9)
			return true;
		return false;
	}

	public static int getNumericValue(char ch) {
		int num = ch - '0';
		if (num >= 0 && num <= 9)
			return num;
		return 0;
	}
}
