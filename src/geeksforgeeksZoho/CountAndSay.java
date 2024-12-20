package geeksforgeeksZoho;

public class CountAndSay {
	public static void main(String[] args) {
		int n = 5;
		countandsay(n);
	}

	private static void countandsay(int n) {
		String str = "1";

		for (int i = 0; i < n; i++) {
			if (i == 0)
				System.out.println(str);
			else {
				String s = "";
				int j = 0;
				while (j < str.length()) {
					int count = 1;
					while ((j < str.length() - 1) && str.charAt(j) == str.charAt(j + 1)) {
						count = count + 1;
						j = j + 1;
					}
					s += Integer.toString(count) + str.charAt(j);
					j = j + 1;
				}
				str = s;
				System.out.println(str);
			}
		}
	}
}
