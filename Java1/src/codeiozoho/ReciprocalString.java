package codeiozoho;

public class ReciprocalString {
	public static void main(String[] args) {
		String s = "AbxhM89";
		StringBuilder sb = new StringBuilder();
	/*	for (int i = 0; i < s.length(); i++) {
			int ans = 0;
			if (Character.isUpperCase(s.charAt(i))) {
				int value = 90 - (int) s.charAt(i);
				ans = value + 65;
			} else if (Character.isLowerCase(s.charAt(i))) {
				int value = 122 - (int) s.charAt(i);
				ans = value + 97;
			} else if(Character.isDigit(s.charAt(i))) {
				int value=57-(int) s.charAt(i);
				ans =value+48;
			}
			char ch = (char) ans;
			sb.append(ch);
		} */	
		
//	ZycsN10
		for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append((char) ('Z' - (c - 'A')));
            } else if (Character.isLowerCase(c)) {
                sb.append((char) ('z' - (c - 'a')));
            } else if (Character.isDigit(c)) {
                sb.append((char) ('9' - (c - '0')));
            } else {
                sb.append(c); // For non-alphabetic and non-numeric characters
            }
        }

		
		
		System.out.println(sb.toString());
	}
}