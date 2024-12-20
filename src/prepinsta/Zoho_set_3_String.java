package prepinsta;

import java.util.Arrays;

public class Zoho_set_3_String {
	public static void main(String[] args) {
		String str="one two three";
		int j=0;
		String[] s=reverse(str.split(" "));
		System.out.println(Arrays.toString(s));
//		reverse(str,j++);
	}
	
	public static String[] reverse(String s[])
	{
		String reverse[]=new String[s.length];
		for (int i = s.length-1,j=0; i >=0; i--,j++) {
			reverse[j]=s[i];
		}
		return reverse;
	}
//	public static void reverse(String str,int j)
//	{
//		String[] s=str.split(" ");
//		//j++;
//		int i=s.length-j;
//		
//		while(i>=0) {
//			if(i==0) {
//				System.out.print(s[i]);
//				j++;
//				reverse(str,j++);
//			}
//			else {
//				System.out.print(s[i]+" ");
//				j++;
//				reverse(str,j++);
//			}
//			
//		}
//		for (int i =s.length-1 ; i >= 0; i--) {
//			if(i==0)
//				System.out.print(s[i]);
//			else
//				System.out.print(s[i]+" ");		
//		}
	}
