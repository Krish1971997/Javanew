package leetcodeZoho6;

import java.util.*;

class KnightMoves {
    static final int N = 8;

    // Possible moves of a knight
    static int[][] directions = {
        {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
        {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
    };

    // BFS to find the shortest path
    public static int minKnightMoves(int startX, int startY, int endX, int endY) {
        if (startX == endX && startY == endY) {
            return 0;
        }

        // Queue for BFS: {x, y, steps}
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});

        // Visited set to avoid cycles
        boolean[][] visited = new boolean[N][N];
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], steps = current[2];
            
            if (x == endX && y == endY) {
                return steps;
            }

            // Explore all 8 possible knight moves
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // If within board and not visited
                if (isValid(newX, newY) && !visited[newX][newY]) {
                    // If destination reached

                    queue.add(new int[]{newX, newY, steps + 1});
                    visited[newX][newY] = true;
                }
            }
        }

        return -1; // Should never reach here for a valid board
    }

    // Check if the position is within board limits
    private static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    public static void main(String[] args) {
        
    	int startX = 0;  //0,0  -> 6,3 o/p 3
    	int startY = 0;
    	
    	int endX = 6;
        int endY = 3;
        

        int moves = minKnightMoves(startX, startY, endX, endY);
        System.out.println("Minimum number of moves: " + moves);

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter starting position (x y): ");
//        int startX = scanner.nextInt();
//        int startY = scanner.nextInt();
//        System.out.print("Enter ending position (x y): ");
//        int endX = scanner.nextInt();
//        int endY = scanner.nextInt();
    }
}
