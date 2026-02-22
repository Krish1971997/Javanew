package leetcodeZoho8;

public class UniqueDigitsSorted {

    public static void main(String[] args) {
        int[] arr = {121, 48};

        boolean[] seen = new boolean[10];

        for (int num : arr) {
            num = Math.abs(num);
            while (num > 0) {
                seen[num % 10] = true;
                num /= 10;
            }
        }

        for (int i = 0; i < 10; i++) {
            if (seen[i]) {
                System.out.print(i + " ");
            }
        }
    }
}