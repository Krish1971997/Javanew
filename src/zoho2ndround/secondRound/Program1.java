package zoho2ndround.secondRound;

public class Program1 {

	public static void main(String[] args) {
		int[] arr= {7,1,3,4,1,7};
		findMinimumDistance(arr);
	}

	private static void findMinimumDistance(int[] arr) {
		int min=Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i]==arr[j]) {
					min=Math.abs(j-i);
				}
			}
		}
		System.out.println(min);
	}
}
