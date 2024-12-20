package leetcodeZoho;

//https://leetcode.com/problems/jump-game/description/
public class Z_JumeGame {

	public static void main(String[] args) {
		int[] arr = { 2, 1, 1, 1, 4 };
		//int[] arr = { 3,2,1,0,4};
		System.out.println(isJumeGame(arr));
	}


	private static boolean isJumeGame(int[] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i > max)
				return false;
			max = Math.max(max, i + arr[i]);
		}
		return true;
	}
}
