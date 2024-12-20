package leetcodeZoho;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArrayConstantSpace {

	public static void main(String[] args) {
		int nums[] = { 1, 1, 2,4,6,8,4,5,6 };
		List<Integer> list = findDuplicatesConstantSpace(nums);
		System.out.println(list);
	}

	public static List<Integer> findDuplicatesConstantSpace(int[] nums) {

		List<Integer> resultSet = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;

			if (nums[index] < 0)
				resultSet.add(index + 1);
			nums[index] = nums[index] * -1;
		}

		return resultSet;
	}
}
