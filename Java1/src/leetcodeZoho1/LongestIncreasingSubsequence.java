package leetcodeZoho1;

import java.util.ArrayList;

public class LongestIncreasingSubsequence {

	static int maxsum;

	public static void main(String[] args) {
		//int[] nums = {0,1,0,3,2,3};
		int[] nums = { 1,5,3,7};
		find(nums, 0, new ArrayList<>(),0);
		System.out.println(maxsum);
	}

	static void find(int[] nums, int index, ArrayList<Integer> list,int currmax) {
		
		if(maxsum<currmax) {
			maxsum=currmax;
		}
		
		if (index == nums.length) {
			System.out.println(list);
			return;
		}
		
		if (list.size() == 0 || list.get(list.size() - 1) < nums[index]) {
			list.add(nums[index]);
			find(nums, index + 1, list,list.size()); 
			list.remove(list.size() - 1);
		}
		find(nums, index + 1, list,list.size());
	}
}
