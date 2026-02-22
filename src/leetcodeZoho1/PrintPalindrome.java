package leetcodeZoho1;

public class PrintPalindrome {

	public static void main(String[] args) {
		String s="abadsgdgsdwebZxnamajwjewjadsnmnmads"
				+ "abadsgdgsdwebZxnamajwjewjadsnmnmads"
				+ "adqwjhkdjkawrnremdsnfansoioiwqjejanmdmbcnsbanfwirei"
				+ "weiuwaeurqifisooqhjweqhwwjkhdjkkqjwkdjjajkkdjkasjjqjwen"
				+ "qweiuoqdkkgjajkdsjkdbncnmamndamnkjqjkekjjkabadsgdgsdwebZxnamajwjewjadsnmnmadsjqwe"
				+ "uqwueiqwoiadsjkahdjahdjkajhsdjjkqnwenmqnmbakjjkjqweouqiweiqieqhjahsd"
				+ "qhwehqjahsuoqieouqnnmzcmxcnkjajjkqjke"
				+ "qweoqieuggoqiqiewiqioeiuquiieio"
				+ "abadsgdgsdwebZxnamajwjewjadsnmnmads"
				+ "abadsgdgsdwebZxrnamajwjewjadsnmnmads"
				+ "adqwjhkdjkawnremdsnfansoioiwqjejanmdmbcnsbanfwirei"
				+ "weiuwaeurqiissooqhjweqhwwjkhdjkkqjwkdjjajkkdjkasjjqjwen"
				+ "qweiuoqdkkjajkdsjkdbncnmamndamnkjqjkekjjkabadsgdgsdwebZxnamajwjewjadsnmnmadsjqwe"
				+ "uqwueiqwoiadsjrkahdjahdjkajhsdjjkqnwenmqnmbakjjkjqweouqiweiqieqhjahsd"
				+ "qhwehqjahsuoqieouqnnmzcmxcnkjajjkqjke"
				+ "qweoqieuoqiqiewiqioeiuquiieio"
				+ "abhadsgdgsdwebZxnamajwjewjadsnmnmads"
				+ "abadhsgdgsdwebZxnamajwjewjadsnmnmads"
				+ "adqgwjhkdjkawrnremdsnfansoioiwqjejanmdmbcnsbanfwirei"
				+ "weiuwhdaeurqifisooqhjweqhwwsjkhdjkkqjwkdjjajkkdjkasjjqjwen"
				+ "qweiuoqdkkgjajkdsjkdbncnmamndsamnkjqjkekjjkabadsgdgsdwebZxnamajwjewjadsnmnmadsjqwe"
				+ "uqwueiqwoiadsjkahdjahdjkajhsgdjjkqnwenmqnmbakjjkjqweouqiweiqieqhjahsd"
				+ "qhwehqjahsuoqieouqnnmzcmxcnkjajjkqjke"
				+ "qweoqieuggoqiqiewiqioeiuquiieiaaso"
				+ "abadsgdgsdwebZxnamajwjewjadsnmnmaasdds"
				+ "abadsgdgsdwebZxrnamajwjewjadsnmnmsdfsadgs"
				+ "adqwjhkdjkawnremdsnfansoioiwqjejanmdmbcngdfsbanfwirei"
				+ "weiuwaeurqiissooqhjweqhwwjkhdjkkqjwkgfddjjajkkdjkasjjqjwen"
				+ "qweiuoqdkkjajkdsjkdbncnmamndamnkjqjkekjjkabgdfadsgdgsdwebZxnamajwjewjadsnmnmadsjqwe"
				+ "uqwueiqwoiadsjrkahdjahdjkajhsdjjkqnwenmqnmbakjdgfdjkjqweouqiweiqieqhjahsd"
				+ "qhwehqjahsuoqieouqnnmzcmxcnkjajjkqjkedgf"
				+ "qweoqieuoqiqiewiqioesadiuquiieio";
		find(s,0);
	}
	static void find(String s, int index) {
		if(index==s.length()) {
			return;
		}
		
		for (int i = index; i < s.length(); i++) {
			String sub=s.substring(index, i+1);
			if(check(sub))
				System.out.println(sub);
		}	
		find(s, index+1);
	}
	
	static boolean check(String sub) {
		int start=0;
		int end=sub.length()-1;
		while(start<end) {
			if(sub.charAt(start)!=sub.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}
}
