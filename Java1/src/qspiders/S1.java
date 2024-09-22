package qspiders;
/**/
import java.util.Arrays;

public class S1 {
	public static void main(String[] args) {
		String s1="aesBAUKLqmk";
		char []ch=s1.toCharArray();
		
		Arrays.sort(ch);
		
		String lower_case="";//
		String upper_case="";//
		String res=" ";
		
		for (int i = 0; i < ch.length; i++) {
			if(ch[i]>='A'&&ch[i]<='Z')
			{
				upper_case+=ch[i];
			}
			else
				lower_case+=ch[i];
		}
		
		System.out.println(lower_case);
		System.out.println(upper_case);
		
		
		
		for (int i = 0,m=0,n=0; i < s1.length(); i++) {
			if(s1.charAt(i)>='a'&&s1.charAt(i)<='z')
			{
				res+=lower_case.charAt(m++);
			}
			else if(s1.charAt(i)>='A'&&s1.charAt(i)<='z')
				res+=upper_case.charAt(n++);
		}
		
		System.out.println("S1 :" + s1);
		System.out.println("Result : "+res);
	}

}
