package geeksforgeeksZoho;

public class PrintPermutation {
	public static void main(String[] args) {
		String str="abc";
		permutationstring(str,"");
	}

	private static void permutationstring(String str, String ans) {
		if(str.length()==0) {
			System.out.println(ans);
			return;
		}
				
		for (int i = 0; i < str.length(); i++) {
			char ch=str.charAt(i);
			
			String first=str.substring(0, i);
			String second=str.substring(i+1);
			String result=first+second;
			permutationstring(result, ans+ch);
		}
	}
}
