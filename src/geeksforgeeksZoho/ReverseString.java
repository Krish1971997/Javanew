package geeksforgeeksZoho;

public class ReverseString {
	public static void main(String[] args) {
		String input1 = "one two three";
		String arr[]=input1.split(" ");
		String ans="";
		for (int i = arr.length-1;i>=0; i--) {
			ans+=arr[i]+" ";
		}
		ans=ans.substring(0,ans.length()-1);
		System.out.println(ans);
	}
}
