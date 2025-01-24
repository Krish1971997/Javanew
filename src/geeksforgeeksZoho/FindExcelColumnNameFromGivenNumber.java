package geeksforgeeksZoho;

public class FindExcelColumnNameFromGivenNumber {

	public static void main(String[] args) {
		int n=28;
		StringBuilder sb=new StringBuilder();
		while(n>0) {
			n--;
			char ch=(char) (n%26+'A');
			sb.insert(0, ch);
			n=n/26;
		}
		System.out.println(sb.toString());
	}
}
