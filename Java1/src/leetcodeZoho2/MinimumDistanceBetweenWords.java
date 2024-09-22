package leetcodeZoho2;


public class MinimumDistanceBetweenWords {

	public static void main(String[] args) {
		String s1="geeks for geeks contribute practice";
		String w1="geeks",w2="practice";
		System.out.println(find(s1, w1, w2));
		
		String s2="the quick the brown quick brown the frog";
		String w3="quick",w4="frog";
		System.out.println(find(s2, w3, w4));
		
		
	}
	
	static int find(String s,String w1, String w2) {
		String words[]=s.split("\\s+");
		int distance =Integer.MAX_VALUE;
		int index1=-1;
		int index2=-1;
		
		for(int i=0;i<words.length;i++) {
			if(words[i].equals(w1))
				index1=i;
			else if(words[i].equals(w2))
				index2=i;
		}
		
		if(index1!=-1 && index2!=-1) {
			distance=index2-index1;
		}
		
		return distance==Integer.MAX_VALUE?-1:distance-1;
	}
	
}
/**

Input : s = “geeks for geeks contribute practice”, w1 = “geeks”, w2 = “practice” 
Output : 1 
There is only one word between the closest occurrences of w1 and w2.

Input : s = “the quick the brown quick brown the frog”, w1 = “quick”, w2 = “frog”
Output : 2
*/
