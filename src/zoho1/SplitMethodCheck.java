package zoho1;

import java.util.Arrays;

public class SplitMethodCheck {
	public static void main(String[] args) {
		String s="aAsdab1jjkj4kjBkj3nnn5";
		String[] str=s.split("[A-Z]");
		System.out.println(Arrays.toString(str));

	}
}
