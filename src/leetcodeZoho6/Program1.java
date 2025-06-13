package leetcodeZoho6;

public class Program1 {
    public static void main(String[] args) {
        int n = 5;

        for (int i = 1; i <= n; i++) {
            int current = i;
            for (int j = 0; j < i; j++) {
                System.out.print(current + " ");
                current = current + (n - j - 1);
            }
            System.out.println();
        }
    }
}
