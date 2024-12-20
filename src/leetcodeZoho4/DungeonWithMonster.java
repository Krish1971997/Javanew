package leetcodeZoho4;

import java.util.LinkedList;
import java.util.Queue;

class DungeonWithMonster {

	// Helper class to store the position in the grid
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

	// BFS method to find the shortest path for the adventurer and monster
	static String findPath(int[][] dungeon, Position adventurer, Position monster, Position gold) {
		int rows = dungeon.length;
		int cols = dungeon[0].length;

		// Directions array for moving up, down, left, and right
		int[] rowDir = { -1, 1, 0, 0 };
		int[] colDir = { 0, 0, -1, 1 };

		// Queue for BFS for adventurer and monster
		Queue<Position> adventurerQueue = new LinkedList<>();
		Queue<Position> monsterQueue = new LinkedList<>();

		// Visited arrays for adventurer and monster
		boolean[][] adventurerVisited = new boolean[rows][cols];
		boolean[][] monsterVisited = new boolean[rows][cols];

		// Add adventurer's starting position
		adventurerQueue.add(adventurer);
		adventurerVisited[adventurer.row][adventurer.col] = true;

		// Add monster's starting position
		monsterQueue.add(monster);
		monsterVisited[monster.row][monster.col] = true;

		// Perform BFS for both adventurer and monster
		while (!adventurerQueue.isEmpty()) {
			// Monster moves first in this turn
			int monsterSize = monsterQueue.size();
			for (int i = 0; i < monsterSize; i++) {
				Position currentMonster = monsterQueue.poll();
				for (int j = 0; j < 4; j++) {
					int newRow = currentMonster.row + rowDir[j];
					int newCol = currentMonster.col + colDir[j];
					if (isValid(newRow, newCol, rows, cols, monsterVisited)) {
						monsterQueue.add(new Position(newRow, newCol, currentMonster.steps + 1));
						monsterVisited[newRow][newCol] = true;
					}
				}
			}

			// Adventurer moves next
			int adventurerSize = adventurerQueue.size();
			for (int i = 0; i < adventurerSize; i++) {
				Position currentAdventurer = adventurerQueue.poll();

				// If adventurer reaches the gold
				if (currentAdventurer.row == gold.row && currentAdventurer.col == gold.col) {
					return "Minimum number of steps: " + currentAdventurer.steps;
				}

				for (int j = 0; j < 4; j++) {
					int newRow = currentAdventurer.row + rowDir[j];
					int newCol = currentAdventurer.col + colDir[j];
					if (isValid(newRow, newCol, rows, cols, adventurerVisited) && !monsterVisited[newRow][newCol]) {
						adventurerQueue.add(new Position(newRow, newCol, currentAdventurer.steps + 1));
						adventurerVisited[newRow][newCol] = true;
					}
				}
			}
		}

		// If no solution found
		return "No possible solution";
	}

	public static void main(String[] args) {
		// Dimensions of the dungeon
		int rows = 5;
		int cols = 4;

		// Adventurer's position (1-based index)
		Position adventurer = new Position(5 - 1, 1 - 1, 0);

		// Monster's position (1-based index)
		Position monster = new Position(3 - 1, 1 - 1, 0);

		// Gold's position (1-based index)
		Position gold = new Position(4 - 1, 3 - 1, 0);

		// Initialize dungeon grid
		int[][] dungeon = new int[rows][cols];

		// Find the minimum number of steps or declare no possible solution
		String result = findPath(dungeon, adventurer, monster, gold);
		System.out.println(result);
	}
}
