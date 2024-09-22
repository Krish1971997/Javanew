package leetcodeZoho;

import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] arr1 = { 1, 4, 2, 5, 4 };
        System.out.println("Output for arr1:");
        printNextGreaterElements(arr1);

        int[] arr2 = { 13, 7, 6, 12 };
        System.out.println("\nOutput for arr2:");
        printNextGreaterElements(arr2);
    }

    public static void printNextGreaterElements(int[] arr) {
        int[] newArray = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            newArray[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }

        for (int element : newArray) {
            System.out.print(element + " ");
        }
        System.out.println(); // For better formatting in output
    }
}
