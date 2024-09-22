package leetcodeZoho1;

import java.util.ArrayList;

public class SubSetIntProblem {

	public static void main(String[] args) {
		int[] nums= {1,2};
		find(nums,new ArrayList<Integer>(), 0);
	}
	static void find(int[] nums, ArrayList<Integer> list, int idx) {
		if(nums.length==idx){
			System.out.println(list);
			return;
		}
		
		list.add(nums[idx]);
		find(nums, list, idx+1);
		
		list.remove(list.size()-1);
		find(nums, list, idx+1);
	}

}
