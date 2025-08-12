package leetcodeZoho6;

import java.util.*;
/**
i have one java problem matrix related. command[1,1,2]
1st first command (1) the given array which layer should rotate, like 1st layer, 2nd layer,etc
2nd second command (1) positive means right roate or -1 means left roate
3rd thid command (2) means how many times will rotate.


given example [1,1,2]

array:
1,2,3,4
5,6,7,8
9,10,11,12
13,14,15,16

output all comands to be passed.

9,5,1,2
13,6,7,3
14,10,11,4
15,16,12,8
 */

public class MatrixLayerRotation {
    public static void main(String[] args) {
        int[][] matrix = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };

        int[] command = {1,1,2}; // layer 1, right rotate, 2 times
        rotateMatrix(matrix, command);

        printMatrix(matrix);
    }

    public static void rotateMatrix(int[][] matrix, int[] command) {
        int layer = command[0] - 1; // zero indexed
        int direction = command[1];
        int times = command[2];

        List<Integer> elements = extractLayer(matrix, layer);
        
        // normalize rotations
        int len = elements.size();
        times = times % len;
        if (direction == -1) times = len - times; // convert left rotation to right

        // perform rotation
        Collections.rotate(elements, times);

        // put back
        fillLayer(matrix, layer, elements);
    }

    public static List<Integer> extractLayer(int[][] matrix, int layer) {
        List<Integer> list = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;

        // top row
        for (int j = layer; j < m - layer; j++) 
            list.add(matrix[layer][j]);
        // right column
        for (int i = layer+1; i < n - layer; i++) 
            list.add(matrix[i][m - layer - 1]);
        // bottom row
        for (int j = m - layer - 2; j >= layer; j--) 
            list.add(matrix[n - layer - 1][j]);
        // left column
        for (int i = n - layer - 2; i > layer; i--) 
            list.add(matrix[i][layer]);

        return list;
    }

    public static void fillLayer(int[][] matrix, int layer, List<Integer> list) {
        int index = 0;
        int n = matrix.length;
        int m = matrix[0].length;

        // top row
        for (int j = layer; j < m - layer; j++) 
            matrix[layer][j] = list.get(index++);
        // right column
        for (int i = layer+1; i < n - layer; i++) 
            matrix[i][m - layer - 1] = list.get(index++);
        // bottom row
        for (int j = m - layer - 2; j >= layer; j--) 
            matrix[n - layer - 1][j] = list.get(index++);
        // left column
        for (int i = n - layer - 2; i > layer; i--) 
            matrix[i][layer] = list.get(index++);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
