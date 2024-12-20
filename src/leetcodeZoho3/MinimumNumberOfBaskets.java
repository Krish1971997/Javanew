
package leetcodeZoho3;

public class MinimumNumberOfBaskets {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 2};
        int threshold = 3;
        int result = 0;
        int i = 0;

        while (i < arr.length) {
            int current = arr[i];
            if (threshold < current) {
                result = -1;
                break;
            } else if (threshold == current) {
                result++;
                i++;
            } else {
                int basketWeight = current;
                i++;
                while (i < arr.length && basketWeight + arr[i] <= threshold) {
                    basketWeight += arr[i];
                    i++;
                }
                result++;
            }
        }

        if (result == -1) {
            System.out.println("Error");
        } else {
            System.out.println(result);
        }
    }
}
