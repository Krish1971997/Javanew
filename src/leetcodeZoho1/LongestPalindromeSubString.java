package leetcodeZoho1;

public class LongestPalindromeSubString {
	static int count = 0;
	//static String str = "";

	public static void main(String[] args) {
		String s = "forgeeksskeegfor";
		System.out.println(find(s, 0, 1,""));
	}

	static String find(String s, int index, int ccount,String str) {
		if (index == s.length()) 
			return str;

		for (int i = index; i < s.length(); i++) {
			String sub = s.substring(index, i + 1);
			ccount = sub.length();
			if (check(sub) && ccount > count) {
				count = ccount;
				str = sub;
				//System.out.println(sub);
			}
		}
		return find(s, index + 1, count,str);
	}

	static boolean check(String sub) {
		int start = 0;
		int end = sub.length() - 1;
		while (start < end) {
			if (sub.charAt(start) != sub.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}

}
