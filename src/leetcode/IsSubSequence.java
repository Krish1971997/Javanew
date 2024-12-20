package leetcode;

//https://leetcode.com/problems/is-subsequence/
public class IsSubSequence {

	public static void main(String[] args) {
		String s1 = "abd", s2 = "ahbgdc";
		System.out.println(isSubsequence(s1, s2) ? true : false);
	}

	/*private static boolean isSubSequence(String s1, String s2) {
		String s = "";
		for (int i = 0,l=1; i < s1.length(); i++) {
			for (int j = 0,k=1; j < s2.length(); j++) {
				if (s1.substring(i,l).equalsIgnoreCase(s2.substring(j, k))) {
					s += s2.substring(j, k);
					break;
					}
				k++;
			}
			l++;
		}
		return s1.equalsIgnoreCase(s);
	}*/
	
	public static boolean isSubsequence(String s, String t) {
		String str=t;
		boolean subsequenceFound=true;
		int i=0,j=0;
		while(i<s.length()) {
			char letter=s.charAt(i);
			int index=str.indexOf(letter);
			if(index>-1) {
				j=index;
				i++;
				str=str.substring(j+1, str.length());
			}else
				return subsequenceFound=false;
		}
		return subsequenceFound;
    }
}
