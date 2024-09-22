package leetcodeZoho2;

public class Z13_ClimbingStairs {
	    public static int climbStairs(int n) {
	        if (n <= 0) {
	            return 0;
	        }
	        
	        if (n == 1) {
	            return 1;
	        }
	        
	        // dp[i] will store the number of ways to reach step i
	        int[] dp = new int[n + 1];
	        dp[0] = 1; // There is 1 way to stay at step 0 (doing nothing)
	        dp[1] = 1; // There is 1 way to reach step 1
	        
	        for (int i = 2; i <= n; i++) {
	            // Number of ways to reach step i is the sum of ways to reach step i-1 and i-2
	            dp[i] = dp[i - 1] + dp[i - 2];
	        }
	        
	        return dp[n];
	    }

	    public static void main(String[] args) {
	        int n1 = 2;
	        int n2 = 3;
	        
	        System.out.println("Number of distinct ways to reach the top: " + climbStairs(n1)); // Output: 2
	        System.out.println("Number of distinct ways to reach the top: " + climbStairs(n2)); // Output: 3
	    }
	}
