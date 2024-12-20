package geeksforgeeksZoho_1;

import java.util.Arrays;

public class MaxTripletProduct {
    public static void main(String[] args) {
        extracted();
    }

	private static void extracted() {
		int[] arr1 = {10, 3, 5, 6, 20};
        int[] arr2 = {-10, -3, -5, -6, -20};
        int[] arr3 = {1, -4, 3, -6, 7, 0};

        System.out.println("Maximum Product (arr1): " + maxTripletProduct(arr1));
        System.out.println("Maximum Product (arr2): " + maxTripletProduct(arr2));
        System.out.println("Maximum Product (arr3): " + maxTripletProduct(arr3));
	}

    private static int maxTripletProduct(int[] arr) {
        int n = arr.length;

        if (n < 3) {
            System.out.println("Array should have at least three elements.");
            return -1;
        }

        Arrays.sort(arr);

        int maxProduct = Math.max(arr[0] * arr[1] * arr[n - 1], 
        		arr[n - 1] * arr[n - 2] * arr[n - 3]);

        return maxProduct;
    }
}
