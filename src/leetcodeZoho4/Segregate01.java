package leetcodeZoho4;

public class Segregate01 {
    public static void segregate0and1(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            // Move left pointer to the right until we find 1
            while (arr[left] == 0 && left < right) {
                left++;
            }

            // Move right pointer to the left until we find 0
            while (arr[right] == 1 && left < right) {
                right--;
            }

            // Swap 0 at left with 1 at right
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        segregate0and1(arr);
        System.out.println("Output: " + java.util.Arrays.toString(arr));
    }
}
