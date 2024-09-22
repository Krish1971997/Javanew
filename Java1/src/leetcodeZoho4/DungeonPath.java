package leetcodeZoho4;

import java.util.LinkedList;
import java.util.Queue;

class DungeonPath {

	static class Position {
		int row, col, steps;

		public Position(int row, int col, int steps) {
			this.row = row;
			this.col = col;
			this.steps = steps;
		}
	}

	// Method to check if a position is valid in the grid
	static boolean isValid(int row, int col, int maxRow, int maxCol, boolean[][] visited) {
		return (row >= 0 && row < maxRow && col >= 0 && col < maxCol && !visited[row][col]);
	}

	// BFS method to find the shortest path
	static int findShortestPath(int[][] dungeon, int startRow, int startCol, int goalRow, int goalCol) {
		int rows = dungeon.length;
		int cols = dungeon[0].length;

		// Directions array for moving up, down, left, and right
		int[] rowDir = { -1, 1, 0, 0 };
		int[] colDir = { 0, 0, -1, 1 };

		// Queue for BFS, starting from the adventurer's position
		Queue<Position> queue = new LinkedList<>();
		boolean[][] visited = new boolean[rows][cols];

		// Add the starting position to the queue
		queue.add(new Position(startRow, startCol, 0));
		visited[startRow][startCol] = true;

		// Perform BFS
		while (!queue.isEmpty()) {
			Position current = queue.poll();

			// If we reach the gold, return the number of steps
			if (current.row == goalRow && current.col == goalCol) {
				return current.steps;
			}

			// Explore all 4 possible directions (up, down, left, right)
			for (int i = 0; i < 4; i++) {
				int newRow = current.row + rowDir[i];
				int newCol = current.col + colDir[i];

				// Check if the new position is valid
				if (isValid(newRow, newCol, rows, cols, visited)) {
					visited[newRow][newCol] = true;
					queue.add(new Position(newRow, newCol, current.steps + 1));
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int rows = 5;
		int cols = 4;

		int adventurerRow = 4;
		int adventurerCol = 1;
		int goldRow = 1;
		int goldCol = 2;

		int[][] dungeon = new int[rows][cols];

		int minSteps = findShortestPath(dungeon, adventurerRow, adventurerCol, goldRow, goldCol);

		if (minSteps != -1) {
			System.out.println("Minimum number of steps: " + minSteps);
		} else {
			System.out.println("No path to the gold!");
		}
	}
}
