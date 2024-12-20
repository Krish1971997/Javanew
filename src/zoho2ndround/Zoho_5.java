package zoho2ndround;

import java.util.Arrays;

public class Zoho_5 {
	
	public static void main(String[] args) {
		int[][] matrix= {{1,2,3},{4,5,6},{7,8,9}};
		rotateMatrix(matrix);
	}

	private static void rotateMatrix(int[][] mat){
        int n = mat.length;

        for (int i = 0; i < n; i ++){
            for (int j = i+1; j < n; j ++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i ++){
            for (int j = 0; j < n/2; j ++){
                int temp = mat[i][j];
                mat[i][j] = mat[i][n-j-1];
                mat[i][n-j-1] = temp;
            }
        }

        for (int i = 0; i < mat.length;i++){
            System.out.println(Arrays.toString(mat[i]));
        }
    }
}
