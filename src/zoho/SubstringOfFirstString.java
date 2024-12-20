package zoho;

/**https://www.geeksforgeeks.org/zoho-interview-experience-set-27-off-campus-software-developer/
 * 4. Print true if second string is a substring of first string, else print false.

Note : * symbol can replace n number of characters
Input : Spoon  Sp*n  Output : TRUE
    Zoho     *o*o  Output : TRUE
    Man       n*     Output : FALSE
    Subline  line   Output : TRUE */

public class SubstringOfFirstString {
	public static void main(String[] args) {
		String s1="subline";
		String s2="line";
		
		int m=s1.length();
		int n=s2.length();
		boolean res=findSolution(s1,s2,m,n);
		//System.out.println(res?"true":"false");
		if(res)
			System.out.println("True");
		else
			System.out.println("False");
	}

	private static boolean findSolution(String s1, String s2, int m, int n) {
		
		if(m==0)
			return false;
		if(n==0)
			return true;
		
		if(s1.charAt(m-1)==s2.charAt(n-1))
			return findSolution(s1, s2, m-1, n);
		return findSolution(s1, s2, m, n-1);
	}
}
