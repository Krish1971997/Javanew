package leetcodeZoho4;

public class AddWithoutArithmetic {
    // Function to add two numbers without using arithmetic operators
    public static int add(int a, int b) {
        while (b != 0) {
            // Carry contains common set bits of a and b
            int carry = a & b;

            // Sum of bits where at least one is not set
            a = a ^ b;

            // Carry is shifted by one so that adding it to a gives the sum
            b = carry << 1;
        }
        return a;
    }

    public static void main(String[] args) {
        int num1 = 15;
        int num2 = 25;

        int sum = add(num1, num2);

        System.out.println("Sum of " + num1 + " and " + num2 + " is: " + sum);
    }
}

