package leetcodeZoho3;

//https://www.youtube.com/watch?v=9kyHYVxL4fw
public class JumpGameII {
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int totalJumps = 0;      
        int lastJumpIndex = 0; 
        int coverage = 0;   
 
        for (int i = 0; i < nums.length ; i++) {
        	coverage = Math.max(coverage, i + nums[i]); // Update furthest point reachable

            if (i == lastJumpIndex) { // If we've reached the end of the current jump range
                totalJumps++;           // Increment jump count
                lastJumpIndex = coverage; // Update the current range to the furthest point

                if (lastJumpIndex >= nums.length - 1) { // If we can reach the last index
                    break;
                }
            }
        }

        return totalJumps;
    }

    public static void main(String[] args) {
    	JumpGameII solution = new JumpGameII();
        
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Minimum jumps for nums1: " + solution.jump(nums1)); // Output: 2
        
        int[] nums2 = {2, 1, 2, 3, 1, 1, 1, 4};
        System.out.println("Minimum jumps for nums2: " + solution.jump(nums2)); // Output: 3
    }
}
