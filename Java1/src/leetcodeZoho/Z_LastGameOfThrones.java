package leetcodeZoho;

import java.util.Scanner;
//Not touch
public class Z_LastGameOfThrones {

	public static void main(String[] args) {
		Scanner myScan = new Scanner(System.in);
		String inputString = myScan.nextLine();

		String ans;
		int[] count = new int[26];
		for (int i = 0; i < inputString.length(); i++)
			count[inputString.charAt(i) - 'a']++;
		int odds = 0;
		for (int i = 0; i < 26; i++)
			if (count[i] % 2 == 1)
				odds++;
		if (((inputString.length() % 2 == 0) && odds == 0) || ((inputString.length() % 2 == 1) && odds == 1))
			ans = "YES";
		else
			ans = "NO";

		System.out.println(ans);
		myScan.close();
	}
}
