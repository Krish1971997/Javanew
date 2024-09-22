package leetcodeZoho2;

public class Z13_RemoveFragment {
	public static void main(String[] args) {
		String s1 = "Every morning I want to do exercise regularly";
		String s2 = "Every morning I want to do meditation without fail";
		String s3 = "It is important that I want to be happy always";

		String fragment = checkFragment(s1, s2, s3);
		if (fragment != null) {
			System.out.println(removeFragment(s1, fragment));
			System.out.println(removeFragment(s2, fragment));
			System.out.println(removeFragment(s3, fragment));
		} else
			System.out.println("There is no consecutive words");
	}

	private static String checkFragment(String s1, String s2, String s3) {
		String[] str1 = splitWords(s1);
		String[] str2 = splitWords(s2);
		String[] str3 = splitWords(s3);

		for (int i = 0; i < str1.length - 2; i++) {
			String fragment = (str1[i] + " " + str1[i + 1] + " " + str1[i + 2]);
			if (findFragment(str2, fragment) && (findFragment(str3, fragment)))
				return fragment;
		}
		return null;
	}

	private static boolean findFragment(String[] str, String fragment) {
		for (int i = 0; i < str.length - 2; i++) {
			if ((str[i] + " " + str[i + 1] + " " + str[i + 2]).equals(fragment))
				return true;
		}
		return false;
	}

	private static String removeFragment(String s1, String fragment) {
		String[] str = splitWords(s1);
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < str.length) {
			if (i <= str.length - 3 && (str[i] + " " + str[i + 1] + " " + str[i + 2]).equals(fragment)) {
				i = i + 2;
			} else {
				if (sb.length() > 0)
					sb.append(" ");
				sb.append(str[i]);
			}
			i++;
		}
		return sb.toString();
	}

	private static String[] splitWords(String s) {
		int wordcount = wordsCount(s);
		String[] word = new String[wordcount];
		StringBuilder sb = new StringBuilder();
		int wordidx = 0;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == ' ' && sb.length() > 0) {
				word[wordidx++] = sb.toString();
				sb = new StringBuilder();
			} else
				sb.append(ch);
		}

		if (sb.length() > 0)
			word[wordidx] = sb.toString();
		return word;
	}

	private static int wordsCount(String s) {
		int count = 1;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == ' ')
				count++;
		}
		return count;
	}
}
