package leetcodeZoho2;

import java.util.ArrayList;
import java.util.List;

public class Z_PseudoBinary {
    public static void main(String[] args) {
        int number = 41;
        List<Integer> result = findPseudoBinarySum(number);
        System.out.println("The pseudo-binary numbers are: " + result);
    }

    public static List<Integer> findPseudoBinarySum(int number) {
        List<Integer> pseudoBinaryNumbers = new ArrayList<>();
        
        while (number > 0) {
            int temp = number;
            int pseudoBinary = 0;
            int place = 1;
            
            while (temp > 0) {
                if (temp % 10 > 0) {
                    pseudoBinary += place;
                }
                temp /= 10;
                place *= 10;
            }
            
            pseudoBinaryNumbers.add(pseudoBinary);
            number -= pseudoBinary;
        }
        
        return pseudoBinaryNumbers;
    }
}
