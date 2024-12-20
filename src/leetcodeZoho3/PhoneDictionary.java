package leetcodeZoho3;

public class PhoneDictionary {
	public static void main(String[] args) {
		String[] dict = { "", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		String input = "44335550555666196667775553";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			int digit = input.charAt(i) - '0';
			int index = 0;
			String value = dict[digit];
			i++;
			while (i < input.length() - 1 && digit == input.charAt(i) - '0') {
				i++;
				index++;
			}
			i--;
			if (value != "")
				sb.append(value.charAt(index));
		}
		System.out.println(sb.toString());
	}
}
