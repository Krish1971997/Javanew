package zoho1;

public class MoveAllZerostoFront {
	    public static void main(String[] args) {
	        int[] arr = {0, 1, 0, 3, 12, 0, 0, 7};
	        
	        moveZerosToFront(arr);
	 
	        for (int num : arr) {
	            System.out.print(num + " ");
	        }
	    }
	    
	    public static void moveZerosToFront(int[] arr) {
	        int n = arr.length;
	        int nonZeroIndex = n - 1;
	        
	        for (int i = n - 1; i >= 0; i--) {
	            if (arr[i] != 0) {
	                int temp = arr[i];
	                arr[i] = arr[nonZeroIndex];
	                arr[nonZeroIndex] = temp;
	                nonZeroIndex--;
	            }
	        }
	    }
	}