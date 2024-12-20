package zohofirstRound_31aug;

public class VowelsReverse {

	public static void main(String[] args) {
		String s="Krishnakumar";
		System.out.println(reverseVowelse(s));;
	}

	private static String reverseVowelse(String s) {
		int start =0;
		int end=s.length()-1;
		char[] chArr=s.toCharArray();
		while(start<end) {
			if(!isVowels(chArr[start])) {
				start++;
				continue;
			}
			else if(!isVowels(chArr[end])){
				end--;
				continue;
			}
			char ch=chArr[start];
			chArr[start]=chArr[end];
			chArr[end]=ch;
			start++;
			end--;
		}
		return new String(chArr);
	}
	
	public static boolean isVowels(char ch) {
		return "aeiouAEIOU".indexOf(ch)!=-1;
	}
}
