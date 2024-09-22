package leetcodeZoho1;

public class PrintPalindrome {

	public static void main(String[] args) {
		String s="abadsgdgsdwebZxnamajwjewjadsnmnmads"
				+ "abadsgdgsdwebZxnamajwjewjadsnmnmads"
				+ "adqwjhkdjkawnremdsnfansoioiwqjejanmdmbcnsbanfwirei"
				+ "weiuwaeurqiisooqhjweqhwwjkhdjkkqjwkdjjajkkdjkasjjqjwen"
				+ "qweiuoqdkkjajkdsjkdbncnmamndamnkjqjkekjjkabadsgdgsdwebZxnamajwjewjadsnmnmadsjqwe"
				+ "uqwueiqwoiadsjkahdjahdjkajhsdjjkqnwenmqnmbakjjkjqweouqiweiqieqhjahsd"
				+ "qhwehqjahsuoqieouqnnmzcmxcnkjajjkqjke"
				+ "qweoqieuoqiqiewiqioeiuquiieio";
		find(s,0);
	}
	static void find(String s, int index) {
		if(index==s.length()) {
			return;
		}
		
		for (int i = index; i < s.length(); i++) {
			String sub=s.substring(index, i+1);
			System.out.println(sub);
		}	
		find(s, index+1);
	}
	
	static boolean check(String sub) {
		int start=0;
		int end=sub.length();
		while(start<end) {
			if(sub.charAt(start)!=sub.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}
}
