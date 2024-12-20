package zoho;

public class Solution1 {

	public static void main(String[] args) {
		String s="41032";
		//String s="5032";
		int sumLeft=0, sumRight=0;
		int length=s.length()%2;
		int divide=s.length()/2;
		int subStringleft=0;
		int subStringRight=0;
		if(length==0) {
			subStringleft=divide;
			subStringRight=divide;
		}
		else  if(length==1) {
			subStringleft=divide+1;
			subStringRight=divide+1;
		}
		
		String left=s.substring(0, subStringleft);
		String right=s.substring(subStringRight, s.length());
		
		int leftIndex=Integer.parseInt(left);
		int rightIndex=Integer.parseInt(right);
		
		while(leftIndex!=0) {
			sumLeft+=leftIndex%10; 
			leftIndex=leftIndex/10; 
		}
		
		while(rightIndex!=0) {
			sumRight+=rightIndex%10;
			rightIndex=rightIndex/10;
		}
		
		if(sumLeft==sumRight)
			System.out.println("True");
		else
			System.out.println("False");
	}
}
