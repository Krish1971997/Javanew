package leetcodeZoho5_dp;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 6, 3 };
		System.out.println(maxArea(height));
	}

	public static int maxArea(int[] height) {
		int left = 0, right = height.length - 1;
		int maxArea = 0; // Initialize max area
		
		while (left < right) {
			int currentArea = (right - left) * Math.min(height[left], height[right]);
			maxArea = Math.max(maxArea, currentArea); // Update max area

			// Move the pointer with the smaller height
			if (height[left] < height[right]) {
				left++;
			} else
				right--;
		}

		return maxArea;
	}
}
