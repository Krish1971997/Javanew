package leetcodeZoho3;

public class MinMaxGame {

	public static void main(String[] args) {
		int[] nums= {1,3,5,2,4,8,2,2};		
		System.out.println(findSolution(nums));
	}

	private static int findSolution(int[] nums) {
		while(nums.length>1) {
			int newNums[]=new int[nums.length/2];
			for (int i = 0; i < newNums.length; i++) {
				if(i%2==0)
					newNums[i]=Math.min(nums[2 * i], nums[2 * i + 1]);
				else
					newNums[i]=Math.max(nums[2 * i], nums[2 * i + 1]);
			}
			nums=newNums;
		}
		
		return nums[0];
	}
}
