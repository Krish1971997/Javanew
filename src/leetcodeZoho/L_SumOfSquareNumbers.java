package leetcodeZoho;

//https://leetcode.com/problems/sum-of-square-numbers/description/
//c = 5
public class L_SumOfSquareNumbers {
/**
	public static void main(String[] args) {
		int num=2147483600;
		System.out.println(sumOfSquare(num));
	}
	private static boolean sumOfSquare(int num) {
		int start=0;
		int end=(int) Math.sqrt(num);
		while(start<=end) {
			int mid=start*start+end*end;
			if(mid==num) {
				return true;
			}else if(num<mid) {
				end--;
			}else {
				start++;
			}
		}
		return false;
	} */

	    public boolean judgeSquareSum(int c) {
	        int left = 0, right = (int) Math.sqrt(c);
	        while (left <= right) {
	            int sum = left * left + right * right;
	            if (sum == c) {
	                return true;
	            } else if (sum < c) {
	                left++;
	            } else {
	                right--;
	            }
	        }
	        return false;
	    }

	    public static void main(String[] args) {
	    	L_SumOfSquareNumbers solution = new L_SumOfSquareNumbers();
	        int num1 = 16;
	        int num2 = 3;
	        int num3 = 4;

	        System.out.println("Is " + num1 + " the sum of two square numbers? " + solution.judgeSquareSum(num1));
	        System.out.println("Is " + num2 + " the sum of two square numbers? " + solution.judgeSquareSum(num2));
	        System.out.println("Is " + num3 + " the sum of two square numbers? " + solution.judgeSquareSum(num3));
	    }
}
