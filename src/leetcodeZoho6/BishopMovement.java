package leetcodeZoho6;

public class BishopMovement {
    public static int minBishopMoves(int startX, int startY, int endX, int endY) {
        // If starting and ending positions have different colors, bishop cannot reach
        if ((startX + startY) % 2 != (endX + endY) % 2) {
            return -1; // Not possible
        }
        if (startX == endX && startY == endY) {
            return 0;
        }
        // If the move is directly diagonal (same slope)
        if (Math.abs(startX - endX) == Math.abs(startY - endY)) {
            return 1;
        }
        // Otherwise, it will take exactly two moves
        return 2;
    }

    public static void main(String[] args) {
    	
    	int startX = 0;  //0,0  -> 0,2 o/p 2
    	int startY = 0;
    	
    	int endX = 7;
        int endY = 7;
        
        int moves = minBishopMoves(startX, startY, endX, endY);
        
        if (moves == -1) {
            System.out.println("Not possible.");
        } else {
            System.out.println("Minimum number of moves: " + moves);
        }
        
        
//        Scanner scanner = new Scanner(System.in);
//        
//        System.out.print("Enter starting position (x y): ");
//        int startX = scanner.nextInt();
//        int startY = scanner.nextInt();
//        System.out.print("Enter ending position (x y): ");
//        int endX = scanner.nextInt();
//        int endY = scanner.nextInt();
        
    }
}
