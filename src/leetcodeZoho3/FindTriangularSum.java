package leetcodeZoho3;

public class FindTriangularSum {
	public static void main(String[] args) {
		int[] nums= {1,2,3,4,5};
		System.out.println(findSolution(nums));
	}

	private static int findSolution(int[] nums) {
		while(nums.length>1) {
			int[] newNums=new int[nums.length-1];
			for(int i=0;i<newNums.length;i++)
				newNums[i]=(nums[i] + nums[i+1]) % 10;
			nums=newNums;
		}
		return nums[0];
	}

}
