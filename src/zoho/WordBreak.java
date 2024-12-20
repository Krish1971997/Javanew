package zoho;

import java.util.ArrayList;

public class WordBreak {

	public static void main(String[] args) {

		String A = "ilike";
		ArrayList<String> B = new ArrayList<String>();
		String arr[] = { "i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "icecream", "man", "go",
				"mango" };
		for (int i = 0; i < arr.length; i++) {
			B.add(arr[i]);
		}

		int res = wordBreak(A, B);
		System.out.println("Output is " + res);
	}

	private static int wordBreak(String a, ArrayList<String> b) {
		int start = 0;
		int end = 1;
		boolean present = true;

		for (int i = 0; i < b.size(); i++) {
			String substring = a.substring(start, end);
			if (substring.equals(b.get(i))) {
				System.out.println("Substring " + substring);
				System.out.println("ArrayList " + b.get(i));
				present = false;
				start++;
				continue;
			}
			System.out.println("Substring " + substring);
			System.out.println("ArrayList " + b.get(i));
			end++;
		}

		if (present)
			return 0;

		return 1;

	}
}
