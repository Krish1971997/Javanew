package leetcodeZoho2;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
	static List<String> list=Arrays.asList("i", "like", "sam", "sung", "samsung","mango");
	public static void main(String[] args) {
		String s="isam";
		System.out.println(find(s));
	}
	private static boolean find(String s) {
		boolean mem[]=new boolean[s.length()+1];
		mem[0]=true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j <i; j++) {
				String sub=s.substring(j,i);
				if(mem[j]&&list.contains(sub)) {
					mem[i]=true;
				}
			}
		}
		return mem[s.length()];
	}
}
