package prepinsta;

public class SumOfNumbersInString {
    public static int sumOfNumbers(String str) {
        int sum = 0, num = 0;
        
        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0'); // Forming a number
            } else {
                sum += num; // Add formed number to sum
                num = 0;    // Reset num
            }
        }
        
        sum += num; // Add last formed number (if any)
        return sum;
    }

    public static void main(String[] args) {
        String str = "1abc23";
        System.out.println("Sum of numbers: " + sumOfNumbers(str)); // Output: 24
    }
}
