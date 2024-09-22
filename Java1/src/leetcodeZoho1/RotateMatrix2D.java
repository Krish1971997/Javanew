package leetcodeZoho1;

//Not working
public class RotateMatrix2D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 1, 2, 3, 10 }, 
						{ 4, 5, 6 ,11}, 
						{ 7, 8, 9 ,12} };
		int count = 0;
		// Tranpose
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				System.out.println(" Count : " + count);
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
		// revrese the row
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length / 2; j++) {
				int temp = arr[i][arr.length - 1 - j];
				arr[i][arr.length - 1 - j] = arr[i][j];
				arr[i][j] = temp;
			}
		}
		// print
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
