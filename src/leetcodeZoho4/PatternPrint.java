package leetcodeZoho4;

public class PatternPrint {

    public static void printPattern(int n) {
        int[][] pattern = new int[n][n];
        int layers = n / 2;

        for (int layer = 0; layer < layers; layer++) {
            int value = n - layer;
            for (int i = layer; i < n - layer; i++) {
                pattern[layer][i] = value;          //top
                pattern[n - layer - 1][i] = value;  //down
                pattern[i][layer] = value; 		    //left
                pattern[i][n - layer - 1] = value;  //right
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
