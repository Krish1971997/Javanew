package geeksforgeeksZoho;

public class CharactersBetweenAnyTwoSameCharacter {

	public static void main(String[] args) {
		String s = "sockabdsddaq";
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i+1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					max = Math.max(max, Math.abs(j-i-1));
				}
			}
		}

		System.out.println(max);
	}
}
