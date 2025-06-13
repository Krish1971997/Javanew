package leetcodeZoho6;

public class FindMinimumInRotatedSortedArray {

    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = (left +right) / 2;

            // If mid element is greater than rightmost, min must be in right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Else, the min is in left half (could be mid too)
                right = mid;
            }
        }

        // At the end, left == right and points to the minimum
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 4, 5, 1, 2};
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums3 = {11, 13, 15, 17};

        System.out.println("Min in nums1: " + findMin(nums1)); // 1
        System.out.println("Min in nums2: " + findMin(nums2)); // 0
        System.out.println("Min in nums3: " + findMin(nums3)); // 11
    }
}
