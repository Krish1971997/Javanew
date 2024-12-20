package codeiozoho;

public class CaesarAndCipher {
	public static void main(String[] args) {
		String s = "AYZayz";
		int num = 3;
		StringBuilder sb = new StringBuilder();

	/*	for (int i = 0; i < s.length(); i++) {
			int temp = (int) s.charAt(i);
			if (Character.isLowerCase(s.charAt(i))) {
				temp = temp + num - 97;
				temp = temp % 26;
				temp = temp + 97;
			} else 
				if (Character.isUpperCase(s.charAt(i))) {
				temp = temp + num - 65;
				temp = temp % 26;
				temp = temp + 65;
			}// else if(temp >4)
			sb.append((char) temp);
		} */
		
		for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) ((c - base + num) % 26 + base);
            }
            sb.append(c);
        }
		
		System.out.println(sb.toString());
	}
}
