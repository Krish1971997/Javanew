package geeksforgeeksZoho;

public class RemoveCharactersFromFirstString {
	public static void main(String[] args) {
		String s1 = "occurence", s2 = "rec";

		StringBuilder sb = new StringBuilder();
		boolean toremove[] = new boolean[26];
		for (char b : s2.toCharArray()) {
			toremove[b - 'a'] = true;
		}

		for (char b : s1.toCharArray()) {
			if (!toremove[b - 'a'])
				sb.append(b);
		}
		System.out.println(sb.toString());
	}
}
