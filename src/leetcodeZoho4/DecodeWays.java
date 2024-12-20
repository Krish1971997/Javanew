package leetcodeZoho4;

import java.util.Arrays;

public class DecodeWays {
	public static void main(String[] args) {
		String str="123";
		int[] mem= new int[str.length()];
		Arrays.fill(mem, -1);
		System.out.println(find(str,0,mem));
	}

	private static int find(String str, int index,int[] mem) {
		
		if(index==str.length())
			return 1;
		
		if(index>str.length())
			return 0;
		
		if(str.charAt(index)=='0')
			return 0;
		
		if(mem[index]!=-1)
			return mem[index];
		
		int left=find(str,index+1,mem);
		int right=0;
		if(str.length()-1>index && Integer.parseInt(str.substring(index, index+2))<27)
			right=find(str,index+2,mem);
		
		return mem[index]=left+right;
	}

}