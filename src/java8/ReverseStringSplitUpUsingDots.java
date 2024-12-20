package java8;

import java.util.Arrays;

public class ReverseStringSplitUpUsingDots {
	static String stringReverse="i.like.this.program.very.much";
public static void main(String[] args) {
	//String s="i.like.this.program.very.much";
	System.out.println(reverseWords(stringReverse));
	//reverseWords(s);
	
	
}

private static String reverseWords(String s) {
	String []str=s.split("\\.");
	
	String [] temp=new String [str.length];
	for (int i = str.length-1,j=0; i >= 0; i--) {
		temp[j++]=str[i];
	}
	
	String []str2=new String[temp.length*2-1];
	for (int i = 0,j=0; i < str2.length; i++) {
		if(i%2==0)
			str2[i]=temp[j++];
		else if(i%2==1)
			str2[i]=".";
	}
	
	StringBuilder temp2=new StringBuilder();
	//System.out.println(Arrays.toString(str2));;
	for (int i = 0; i < str2.length; i++) {
		temp2.append(str2[i]);
	}
	//System.out.println(temp2);
	String str1=temp2.toString();
	
return str1;
}	

}
