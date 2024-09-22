package prepinsta;

import java.util.Arrays;

public class Einvonations {
	public static void main(String[] args) {
		String s="eGinnovations";
		char []ch=s.toCharArray();
		int count=1;
		for (int i = 0; i < ch.length; i++) {
			count=1;
			for (int j = i+1; j < ch.length; j++) {
				if(ch[i]==ch[j]&&ch[i]!=1)
				{
					count++;
					ch[j]=1;
				}
					
				}
			if(count>1&&ch[i]!=1)
				System.out.println(ch[i]+" - "+count);
			}
		}
		
		
	}


