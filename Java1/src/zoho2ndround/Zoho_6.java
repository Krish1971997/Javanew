package zoho2ndround;

import java.util.ArrayList;
import java.util.List;

public class Zoho_6 {
	public static void main(String[] args) {
		int n = 2;
		List<String> result = new ArrayList<>();
		generateParenthesisHelper(result, "", 0, 0, n);

		System.out.println("Output: " + result);
	}

	private static void generateParenthesisHelper(List<String> result, String current, int open, int close, int n) {
		if (current.length() == 2 * n) {
			result.add(current);
			return;
		}
		System.out.println("Result :"+result+" Current :"+current +
				" Open : "+open+" Close :"+close);
		if (open < n)
			generateParenthesisHelper(result, current + "(", open + 1, close, n);
		if (close < open)
			generateParenthesisHelper(result, current + ")", open, close + 1, n);
	}
}