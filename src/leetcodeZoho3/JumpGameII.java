package leetcodeZoho3;

public class JumpGameII {
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int jumps = 0;      
        int currentEnd = 0; 
        int furthest = 0;   

        for (int i = 0; i < nums.length - 1; i++) {
            furthest = Math.max(furthest, i + nums[i]); // Update furthest point reachable

            if (i == currentEnd) { // If we've reached the end of the current jump range
                jumps++;           // Increment jump count
                currentEnd = furthest; // Update the current range to the furthest point

                if (currentEnd >= nums.length - 1) { // If we can reach the last index
                    break;
                }
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
    	JumpGameII solution = new JumpGameII();
        
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Minimum jumps for nums1: " + solution.jump(nums1)); // Output: 2
        
        int[] nums2 = {2, 1, 2, 3, 1, 1, 1, 4};
        System.out.println("Minimum jumps for nums2: " + solution.jump(nums2)); // Output: 3
    }
}
