package leetcodeZoho1;

public class PrintAllSubsequences {

	public static void main(String[] args) {
		String s="aba";
		find(s, 0, "");
	}
	
	static void find(String s, int index, String res) {
		if(s.length()==index) {
			System.out.println(res);
			return;
		}
		
		find(s,index+1,res+s.charAt(index));
		find(s,index+1,res);
	}
}
