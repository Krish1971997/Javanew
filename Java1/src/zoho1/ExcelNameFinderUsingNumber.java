package zoho1;

public class ExcelNameFinderUsingNumber {

	public static void main(String[] args) {
		int n=28;
		StringBuilder sb=new StringBuilder();
		int temp=n;
		
		while(temp>0) {
			temp--;
			char character=(char)('A'+(temp %26));
			sb.insert(0,character);
			temp=temp/26;
			System.out.println("temp -->"+temp);
		}
		System.out.println("Result --> "+sb.toString());	
	}
}
