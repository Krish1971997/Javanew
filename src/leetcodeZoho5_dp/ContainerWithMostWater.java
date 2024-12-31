package leetcodeZoho5_dp;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ContainerWithMostWater {
	
	private static final Logger LOGGER = Logger.getLogger(ContainerWithMostWater.class.getName());
	
	public static void main(String[] args) {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 6, 3 };
		LOGGER.log(Level.INFO, "Program Started");
		System.out.println(maxArea(height));
		LOGGER.log(Level.INFO, "Program Finished");
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
		
		LOGGER.log(Level.INFO, "Return statement");
		
		return maxArea;
	}
}
