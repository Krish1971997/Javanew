package geeksforgeeksZoho;

public class FindExcelColumnNameFromGivenNumber {

	public static void main(String[] args) {
		int n=28;
		StringBuilder sb=new StringBuilder();
		while(n>0) {
			n--;
			int rem=(n%26);
			char ch=(char) (rem+'A');
			sb.insert(0, ch);
			n=n/26;
		}
		System.out.println(sb.toString());
	}
}
