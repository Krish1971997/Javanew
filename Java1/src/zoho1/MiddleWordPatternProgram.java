package zoho1;

import java.util.Scanner;

public class MiddleWordPatternProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.next();
        scanner.close();

        int length = input.length();

        if (length % 2 == 0) {
            System.out.println("Please enter an odd length word.");
            return;
        }

        int middle = length / 2;
        int spaces = middle;

        for (int i = 0; i < middle; i++) {
            for (int j = 0; j < spaces; j++) {
                System.out.print("  ");
            }

            for (int j = 0; j <= i; j++) {
                System.out.print(input.charAt(middle + j));
            }

            System.out.println();
            spaces--;
        }

        for (int i = middle; i >= 0; i--) {
            for (int j = 0; j < spaces; j++) {
                System.out.print("  ");
            }

            for (int j = 0; j <= i; j++) {
                System.out.print(input.charAt(middle + j));
            }

            System.out.println();
            spaces++;
        }
    }
}

