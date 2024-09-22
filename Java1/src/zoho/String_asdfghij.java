package zoho;

/*3. Two strings of equal length will be given. Print all the adjacent pairs which are not equal.

Input: asdfghij and adsfgijh

Output: sd-ds, hij-ijh
 */
public class String_asdfghij {

	public static void main(String[] args) {
		StringBuilder sb=new StringBuilder();
		String[] s={"asdfghij"};
		String[] str= {"adsfgijh"};
		int j=0;
		for(int i=0;i<s.length;i++) {
			if(s[i]!=str[j]) {
				sb.append(s[i]+s[j++]);
			}
		}
		System.out.println(sb);
		
		
	}
}
