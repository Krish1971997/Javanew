package leetcodeZoho6;

//Working
public class LeadersInArray {

    public static void printLeaders(int[] arr) {
        int n = arr.length;
        int maxFromRight = arr[n - 1];

        System.out.print("Leaders: " + maxFromRight + " "); // Last element is always a leader

        // Traverse from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > maxFromRight) {
                maxFromRight = arr[i];
                System.out.print(maxFromRight + " ");
            }
        }
        System.out.println(); // New line after output
    }

    public static void main(String[] args) {
        int[] arr1 = {16, 17, 4, 3, 5, 2};
        int[] arr2 = {1, 2, 3, 4, 0};

        printLeaders(arr1); // Output: 2 5 17
        printLeaders(arr2); // Output: 0 4
    }
}
