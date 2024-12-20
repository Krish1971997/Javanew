package leetcodeZoho;

public class Z_LastBeautifulPoles {
	public static void main(String[] args) {
		int arr[] = { 1, 1, 3, 1 };
		int ans[] = new int[arr.length];
		int max = 0,total = 0;
		
		for (int i = ans.length - 1; i >= 0; i--) {
			max = Math.max(max, arr[i]);
			ans[i] = max;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < ans[i])
				total += (arr.length - i - 1);
		}
		System.out.print(total);
	}
}
