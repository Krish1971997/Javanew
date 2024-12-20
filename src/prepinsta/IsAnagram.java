package prepinsta;

import java.util.Arrays;

public class IsAnagram {
		public static void main(String[] args) {
			String s1="Mary";
			String s2="ARmy";
			
			s1=s1.toLowerCase();
			s2=s2.toLowerCase();
			
			if(isAnagram(s1, s2))
				System.out.println("Anagram");
			else
				System.out.println("Non Anagram");
		}
		public static boolean isAnagram(String s1, String s2)
		{
			char[]ch1=s1.toCharArray();
			char[]ch2=s2.toCharArray();
			
			Arrays.sort(ch1);
			Arrays.sort(ch2);
			
			if(ch1.length!=ch2.length)
				return false;
			
			for (int i = 0; i < ch1.length; i++) {
				if(ch1[i]!=ch2[i])
					return false;
			}	
			return true;
		}
	}