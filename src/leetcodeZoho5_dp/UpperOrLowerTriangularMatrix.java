package leetcodeZoho5_dp;

public class UpperOrLowerTriangularMatrix {

	public static void main(String[] args) {
		int[][] arr = { { 4, 6, 1, 4 }, 
				{ 0, 3, 5, 9 }, 
				{ 0, 0, 6, 2 }, 
				{ 0, 0, 0, 8 } };
	//	int[][] arr= {{1,0},{1,1}};
		
		
		System.out.println(findTriangle(arr));
	}

	private static String findTriangle(int[][] arr) {
		boolean lower = true;
		boolean upper = true;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] != 0 && j > i)
					lower = false;
				else if (arr[i][j] != 0 && j < i)
					upper = false;
			}
		}
		
		if(lower)
			return "Lower Triangular Matrix";
		else 
			return "Upper Triangular Matrix";
	}

}
