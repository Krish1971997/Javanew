package geeksforgeeksZoho;

public class OccurenceProgram {

	public static void main(String[] args) {
		String s="Occurence";
		
		int count[]=new int[57];
		for (int i = 0; i < s.length(); i++) { 
			count[s.charAt(i)-'A']++;
		}
		
		for (int i = 0; i < s.length(); i++) {
			if(count[s.charAt(i)-'A']>0) {
				System.out.print(s.charAt(i)+""+count[s.charAt(i)-'A']);
				count[s.charAt(i)-'A']=0;
			}
			
		}
	}
}
