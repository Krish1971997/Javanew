package geeksforgeeksZoho_1;

public class SlidingWindowMaximum {
	public static void main(String[] args) {
		int arr[] = { 8, 2, 5, 4, 7, 5, 9, 3, 10 }, K = 3;
		for (int i = 0; i <= arr.length - K; i++) {
			int max=0;
			for (int j = i; j < i+K; j++) {
				max=maxMethod(max,arr[j]);
			}
			System.out.print(max+" ");
		}
	}
	public static int maxMethod(int start,int end) {
		return start>end?start:end;
	}

}
