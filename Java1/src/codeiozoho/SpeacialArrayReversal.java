package codeiozoho;

public class SpeacialArrayReversal {
	public static void main(String[] args) {
		String s="A&x# sB@12ki 54#$";
		//char[] ch1=s.toCharArray();
		char ch[]=new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			ch[i]=s.charAt(i);
		}
		int start=0,end=s.length()-1;
		
		while(start<=end) {
			if(!Character.isLetterOrDigit(start)) {
				start++;
				continue;
			} else if(!Character.isLetterOrDigit(end)) {
				end--;
				continue;
			}else {
				char temp=ch[start];
				ch[start]=ch[end];
				ch[end]=temp;
				start++;
				end--;
			}
		}
		StringBuilder sb=new StringBuilder();
		for (char c : ch) {
			sb.append(c);
		}
		System.out.println(sb.toString());
	}
}
