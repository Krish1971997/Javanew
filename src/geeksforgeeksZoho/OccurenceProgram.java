package geeksforgeeksZoho;

public class OccurenceProgram {

	public static void main(String[] args) {
		String s="Occurence";
		
		int count[]=new int[57];
		for (int i = 0; i < s.length(); i++) {
			int ch=s.charAt(i)-'A';
			count[ch]++;
		}
		
		for (int i = 0; i < s.length(); i++) {
			int ch=s.charAt(i)-'A';
			if(count[ch]>0) {
				System.out.print(s.charAt(i)+""+count[ch]);
				count[ch]=0;
			}
			
		}
	}
}
