package leetcodeZoho2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileMathOperations {

    public static void main(String[] args) {
        // File paths
        String inputFilePath = "C://Users//Admin//Pictures//input.txt";
        String outputFilePath = "C://Users//Admin//Pictures//output.txt";

        try {
            // Read numbers from the input file
            List<Integer> numbers = readNumbersFromFile(inputFilePath);

            // Perform mathematical calculations (e.g., sum of numbers)
            int sum = calculateSum(numbers);
            int product = calculateProduct(numbers);

            // Write results to the output file
            writeResultsToFile(outputFilePath, sum, product);

            System.out.println("Calculations completed successfully. Check the output file for results.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Method to read numbers from a file
    private static List<Integer> readNumbersFromFile(String filePath) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                numbers.add(Integer.parseInt(line.trim()));
            }
        }
        return numbers;
    }

    // Method to calculate the sum of numbers
    private static int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    // Method to calculate the product of numbers
    static int product = 1;
    private static int calculateProduct(List<Integer> numbers) {
        for (int num : numbers) {
            product *= num;
        }
        return product;
    }

    // Method to write results to a file
    private static void writeResultsToFile(String filePath, int sum, int product) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Sum: " + sum);
            writer.newLine();
            writer.write("Product: " + product);
            writer.newLine();
        }
    }
}