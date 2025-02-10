package leetcodeZoho5_dp;

public class PatternZoho {

	public static void main(String[] args) {
		String str = "1234567";
		printPattern(str);
	}

	private static void printPattern(String str) {
        int length = str.length();
        
        if (length % 2 == 0) {
            length = length + 1;
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
            	
                if (i == j || i + j == length - 1) {
                    System.out.print(str.charAt(i % str.length()) + "  ");
                }
                else if (i == length / 2) {
                    System.out.print(str.charAt(j % str.length()) + "  ");
                }
                else if (j == length / 2) {
                    System.out.print(str.charAt(i % str.length()) + "  ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

    }


}
