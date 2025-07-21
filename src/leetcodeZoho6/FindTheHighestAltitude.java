package leetcodeZoho6;

public class FindTheHighestAltitude {
	public static void main(String[] args) {
		int[] arr= {-4,-3,-2,-1,4,3,2};
		System.out.println(findnumber(arr));
	}

	private static int findnumber(int[] arr) {
		
		int num=0;
		int max=0;
		for (int i = 0; i < arr.length; i++) {
			num+=arr[i];
			max=Math.max(max, num);
		}
		
		return max;
	}

}
