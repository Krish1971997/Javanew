package leetcodeZoho2;

public class Z_DecimalToBaseConverter {
    public static void main(String[] args) {
        int number = 27;
        int base = 17;
        
        String result = convertToBase(number, base);
        System.out.println("Output: " + result); // Output should be 1A
    }

    public static String convertToBase(int number, int base) {
        if (base < 2 || base > 36) {
            throw new IllegalArgumentException("Base must be between 2 and 36");
        }
        
        if (number == 0) {
            return "0";
        }
        
        StringBuilder result = new StringBuilder();
        while (number > 0) {
            int remainder = number % base;
            result.append(mapToChar(remainder));
            number /= base;
        }
        
        return result.reverse().toString();
    }

    private static char mapToChar(int remainder) {
        if (remainder >= 0 && remainder <= 9) {
            return (char) (remainder + '0');
        } else {
            return (char) (remainder - 10 + 'A');
        }
    }
}
