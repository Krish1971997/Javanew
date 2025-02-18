package leetcodeZoho6;

public class CrayonPartitioning {
    
    public static int maxCrayons(int[] crayons, int k) {
        int maxCrayonsCount = 0;

        for (int crayon : crayons) {
            // Only cut crayons larger than k
            if (crayon > k) {
                maxCrayonsCount += crayon / k; // Full pieces of size k
                if (crayon % k != 0) {
                    // If there is any remainder, add an additional piece
                    maxCrayonsCount++;
                }
            } else {
                // If the crayon is smaller than or equal to k, don't cut it
                maxCrayonsCount++;
            }
        }
        return maxCrayonsCount;
    }

    public static void main(String[] args) {
        int[] crayons = {10, 7, 15, 6, 3}; // sizes of crayons
        int k = 5; // threshold value for crayon size
        
        int result = maxCrayons(crayons, k);
        
        System.out.println("Maximum number of crayons possible: " + result);
    }
}
