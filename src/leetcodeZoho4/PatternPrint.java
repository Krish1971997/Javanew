package leetcodeZoho4;

public class PatternPrint {

    public static void printPattern(int n) {
        int[][] pattern = new int[n][n];
        int layers = n / 2;

        for (int row = 0; row < layers; row++) {
            int value = n - row;
            for (int i = row; i < n - row; i++) {
                pattern[row][i] = value;          //top
                pattern[n - row - 1][i] = value;  //down
                pattern[i][row] = value; 		    //left
                pattern[i][n - row - 1] = value;  //right
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(pattern[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n1 = 4;
        System.out.println("Pattern for n = " + n1 + ":");
        printPattern(n1);

        int n2 = 8;
        System.out.println("\nPattern for n = " + n2 + ":");
        printPattern(n2);
    }
}
