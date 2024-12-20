package statickeyword;

public class Program4 {
	public static void main(String[] args) {
		String str = "abcac";
		int n = 10;
		System.out.println(find(str, n));
	}

	private static int find(String str, int n) {
		char ch = 'a';
		int count = 0;
		int i=0,j=0;
		
		while(i<n) {
			if (ch == str.charAt(j++))
				count++;
			if (str.length() == j)
				j = 0;
			i++;
		}
		
		return count;
	}
}
