package leetcodeZoho8;

public class MinNumberOfFrogs {
	
	public static void main(String[] args) {
		String croakOfFrogs = "crcoakroak";
		System.out.println(minNumberOfFrogs(croakOfFrogs));
	}
	
	public static int minNumberOfFrogs(String croakOfFrogs) {
		int c = 0, r = 0, o = 0, a = 0, k = 0;
		int maxFrogs = 0;

		for (char ch : croakOfFrogs.toCharArray()) {
			if (ch == 'c') {
				c++;
			} else if (ch == 'r') {
				if (c == 0)
					return -1; // 'r' கு முன்னாடி 'c' இல்லன்னா invalid
				c--;
				r++;
			} else if (ch == 'o') {
				if (r == 0)
					return -1;
				r--;
				o++;
			} else if (ch == 'a') {
				if (o == 0)
					return -1;
				o--;
				a++;
			} else if (ch == 'k') {
				if (a == 0)
					return -1;
				a--;
				k++;
			}

			// இப்போ எத்தனை தவளைகள் active-ஆ இருக்கா?
			int activeFrogs = c + r + o + a;
			maxFrogs = Math.max(maxFrogs, activeFrogs);
		}

		// கடைசியில எல்லாரும் 'k' முடிச்சிருக்கணும்
		if (c != 0 || r != 0 || o != 0 || a != 0)
			return -1;

		return maxFrogs;
	}
}