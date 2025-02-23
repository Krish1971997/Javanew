package qspiders;

public class ExtractAndConvert {
    public static void main(String[] args) {
        String str = "abc123xyz"; // Example string with numbers
        int num = extractAndConvert(str);
        System.out.println("Extracted number: " + num);
    }

    public static int extractAndConvert(String str) {
        // Remove all non-numeric characters
        String numericStr = str.replaceAll("\\D", ""); 
        
        // Handle case where no digits are found
        if (numericStr.isEmpty()) {
            return 0; // Default value if no numbers are found
        }

        // Convert to integer
        return Integer.parseInt(numericStr);
    }
}
