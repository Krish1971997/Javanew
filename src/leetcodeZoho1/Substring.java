package leetcodeZoho1;

public class Substring {

	public static void main(String[] args) {
		String s="aba";
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
}
