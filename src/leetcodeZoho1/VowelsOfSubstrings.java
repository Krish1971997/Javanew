package leetcodeZoho1;

public class VowelsOfSubstrings {
	static int maxcount=0;
	public static void main(String[] args) {
		String s="abc";
		find(s,0,"",0);
	}
	static void find(String s, int index, String res,int count) {
		if(s.length()==index) {
			maxcount=maxcount+vowels(res);
			System.out.println(res+"-> "+maxcount);
			return;
		}
		
		find(s,index+1,res+s.charAt(index),count);
		find(s,index+1,res,count);
	}
	
	static int vowels(String str) {
		int count=0;
		for (int i = 0; i < str.length(); i++) {
			char c=str.charAt(i);
			if(c=='a'||c=='A'||c=='e'||c=='E'||c=='i'||c=='I'||c=='o'
					||c=='O'||c=='U'||c=='u') {
				count++;
			}
		}
		return count;
	}
}
