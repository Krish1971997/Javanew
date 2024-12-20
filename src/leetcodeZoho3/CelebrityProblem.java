package leetcodeZoho3;

import java.util.Stack;

public class CelebrityProblem {

    public static int findCelebrity(int[][] matrix, int n) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();

            if (matrix[a][b] == 1) {
                // a knows b, so a can't be a celebrity
                stack.push(b);
            } else {
                // a doesn't know b, so b can't be a celebrity
                stack.push(a);
            }
        }

        int candidate = stack.pop();

        // Verify if the candidate is a celebrity
        for (int i = 0; i < n; i++) {
            // Candidate should not know anyone and everyone should know the candidate
            if (i != candidate && (matrix[candidate][i] == 1 || matrix[i][candidate] == 0)) {
                return -1;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
            {0, 0, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0},
            {0, 0, 1, 0}
        };

        int[][] matrix2 = {
            {0, 0, 1, 0},
            {0, 0, 1, 0},
            {0, 1, 0, 0},
            {0, 0, 1, 0}
        };

        int n1 = matrix1.length;
        int n2 = matrix2.length;

        int celebrity1 = findCelebrity(matrix1, n1);
        if (celebrity1 == -1) {
            System.out.println("No celebrity");
        } else {
            System.out.println("Celebrity ID: " + celebrity1);
        }

        int celebrity2 = findCelebrity(matrix2, n2);
        if (celebrity2 == -1) {
            System.out.println("No celebrity");
        } else {
            System.out.println("Celebrity ID: " + celebrity2);
        }
    }
}
