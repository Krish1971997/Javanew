package leetcodeZoho;

public class Z_MajorityElement {

	public static void main(String[] args) {
		int nums[]= {2,2,1,1,1,2,2};
		System.out.println(majorityElement(nums));
		
	}
	public static int majorityElement(int[] nums) {
		int majority=nums[0];
		int count=1;
		for (int i = 1; i < nums.length; i++) {
			if(majority==nums[i]) {
				count++;
			}else if(count==0) {
				majority=nums[i];
				count++;
			}else
				count--;
		}
		return majority;
	}
}
