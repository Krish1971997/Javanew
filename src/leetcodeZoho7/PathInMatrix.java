package leetcodeZoho7;

import java.util.*;

public class PathInMatrix {

	// 2️⃣ Directions (up, down, left, right)
	public static final int[][] DIRECTIONS = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static class Cell {
		int row, col;

		Cell(int r, int c) {
			this.row = r;
			this.col = c;
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 0, 3, 2 }, { 3, 0, 0 }, { 1, 3, 3 } };

		if (isPath(matrix)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

	public static boolean isPath(int[][] matrix) {
		int n = matrix.length;
		int startRow = -1, startCol = -1;

		// 1️⃣ Find the source (1)
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 1) {
					startRow = i;
					startCol = j;
				}
			}
		}

		// 3️⃣ BFS Queue
		Queue<Cell> queue = new LinkedList<>();
		boolean[][] visited = new boolean[n][n];

		queue.add(new Cell(startRow, startCol));
		visited[startRow][startCol] = true;

		while (!queue.isEmpty()) {
			Cell cur = queue.poll();

			// 4️⃣ Check if destination reached
			if (matrix[cur.row][cur.col] == 2) {
				return true;
			}

			// 5️⃣ Explore neighbours
			for (int[] directions : DIRECTIONS) {
				int newRow = cur.row + directions[0];
				int newCol = cur.col + directions[1];

				if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && !visited[newRow][newCol]
						&& matrix[newRow][newCol] != 0) {
					visited[newRow][newCol] = true;
					queue.add(new Cell(newRow, newCol));
				}
			}
		}

		return false;
	}
}
