package geeksforgeeksZoho;

public class LongestSubArrayWithMaximumBitwiseAnd {

	public static void main(String[] args) {
		int arr[]= {1,2,3,3,3,3,2};
		int m=-1;
		for (int i : arr) {
			m= i>=m?i:m;
		}
		
		int maxlength=1;
		int currlength=0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==m) {
				currlength+=1;
				maxlength=Math.max(maxlength, currlength);
			}else {
				currlength=0;
			}
		}
		System.out.println(maxlength);
	}
}
