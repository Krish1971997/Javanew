package zProgrammingRound;

public class Program4 {
	
	public static void main(String[] args) {
		// DBAABDAB
		// ABDAADBDAABB
		String str = "abbaca";
		System.out.println(removeAdjacentDuplicates(str));
	}

	private static String removeAdjacentDuplicates(String str) {

		StringBuilder result = new StringBuilder();
        
        for (char c : str.toCharArray()) {
            int length = result.length();
            // If the last character is same as current, remove it
            if (length > 0 && result.charAt(length - 1) == c) {
                result.deleteCharAt(length - 1);
            } else {
                result.append(c);
            }
        }
        
        return result.toString();
	}
	
	
//	public static void main(String[] args) {
//		// DBAABDAB
//		// ABDAADBDAABB
//		StringBuilder str = new StringBuilder("ABDAADBDAABB");
//		removeAdjacentDuplicates(str);
//	}
//
//	private static void removeAdjacentDuplicates(StringBuilder str) {
//
//		int i = 1;
//		while (i < str.length()) {
//			if (str.charAt(i - 1) == str.charAt(i)) {
//				str.delete(i - 1, i + 1);
//				// Step back to check for new adjacent duplicates created
//				if (i > 1)
//					i--;
//			} else {
//				i++;
//			}
//		}
//		System.out.println(str.toString());
//	}
}
