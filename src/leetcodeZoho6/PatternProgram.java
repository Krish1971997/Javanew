package leetcodeZoho6;

public class PatternProgram {
	    public static void main(String[] args) {
	        printPattern(5); // Test with size 5
	        System.out.println();
	        printPattern(10); // Test with size 10
	    }

	    public static void printPattern(int size) {
	        int totalRows = 2 * size - 1;
	        // Highest letter (e.g., 'e' for size 5, 'j' for size 10)
	        char highestLetter = (char) ('a' + size - 1);

	        for (int row = 1; row <= totalRows; row++) {
	            // Determine effective row for symmetry
	            int effectiveRow = row <= size ? row : 2 * size - row;
	            // Number of letters in this row
	            int numLetters = 2 * effectiveRow - 1;
	            // Starting letter for this row
	            char startLetter = (char) (highestLetter - effectiveRow + 1);

	            // Build the letter sequence (descending then ascending)
	            StringBuilder letters = new StringBuilder();
	            // Descending part
	            for (char c = highestLetter; c >= startLetter; c--) {
	                letters.append(c);
	            }
	            // Ascending part (skip the middle letter to avoid duplication)
	            for (char c = (char) (startLetter + 1); c <= highestLetter; c++) {
	                letters.append(c);
	            }

	            // Calculate dashes on each side
	            int totalWidth = 2 * size; // Total width including letters and dashes
	            int dashesOnEachSide = (totalWidth - numLetters) / 2;

	            // Build the row
	            StringBuilder line = new StringBuilder();
	            // Add leading dashes
	            for (int i = 0; i < dashesOnEachSide; i++) {
	                line.append('-');
	            }
	            // Add letters
	            line.append(letters);
	            // Add trailing dashes
	            for (int i = 0; i < dashesOnEachSide; i++) {
	                line.append('-');
	            }

	            // Print the row
	            System.out.println(line.toString());
	        }
	    }
	}