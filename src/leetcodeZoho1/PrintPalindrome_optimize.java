package leetcodeZoho1;

public class PrintPalindrome_optimize {

	public static void main(String[] args) {
		String s="abadsgdgsdwebZxnamajwjewjadsnmnmads";
		int[][] mem=new int[s.length()][s.length()]; 
		System.out.println(find(s,0,s.length()-1,mem));
	}
	static int find(String s, int start, int end, int[][] mem) {

		if(start==end)
			return 1;
		if(start+1==end &&(s.charAt(start)==s.charAt(end)) )
			return 2;
		
		if(mem[start][end]!=0) {
			return mem[start][end];
		}
		
		if(s.charAt(start)==s.charAt(end)) {
			return 2+find(s, start+1, end-1, mem);
		}
		
		int left=find(s, start+1, end, mem);
		int right=find(s, start, end-1, mem);
		
		return mem[start][end]=Math.max(left, right);
	}
}
