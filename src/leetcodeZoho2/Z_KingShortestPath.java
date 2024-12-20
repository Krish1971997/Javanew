package leetcodeZoho2;

import java.util.LinkedList;
import java.util.Queue;

public class Z_KingShortestPath {
	    // Define the 8 possible moves for the king
	    private static final int[] ROW_MOVES = {-1, -1, -1, 0, 0, 1, 1, 1};
	    private static final int[] COL_MOVES = {-1, 0, 1, -1, 1, -1, 0, 1};

	    public static void main(String[] args) {
	        int startX = 0, startY = 0; // Starting position (0, 0)
	        int endX = 7, endY = 7;     // Destination position (7, 7)

	        int shortestPathLength = findShortestPath(startX, startY, endX, endY);
	        System.out.println("The shortest path length is: " + shortestPathLength);
	    }

	    private static int findShortestPath(int startX, int startY, int endX, int endY) {
	        boolean[][] visited = new boolean[8][8];
	        Queue<Cell> queue = new LinkedList<>();

	        // Start from the source cell
	        queue.add(new Cell(startX, startY, 0));
	        visited[startX][startY] = true;

	        while (!queue.isEmpty()) {
	            Cell current = queue.poll();

	            // If we reach the destination
	            if (current.x == endX && current.y == endY) {
	                return current.distance;
	            }

	            // Explore all possible moves for the king
	            for (int i = 0; i < 8; i++) {
	                int newX = current.x + ROW_MOVES[i];
	                int newY = current.y + COL_MOVES[i];

	                if (isWithinBounds(newX, newY) && !visited[newX][newY]) {
	                    queue.add(new Cell(newX, newY, current.distance + 1));
	                    visited[newX][newY] = true;
	                }
	            }
	        }

	        // If destination is not reachable
	        return -1;
	    }

	    private static boolean isWithinBounds(int x, int y) {
	        return x >= 0 && x < 8 && y >= 0 && y < 8;
	    }

	    // Helper class to represent a cell on the chessboard
	    private static class Cell {
	        int x, y, distance;

	        Cell(int x, int y, int distance) {
	            this.x = x;
	            this.y = y;
	            this.distance = distance;
	        }
	    }
	}
