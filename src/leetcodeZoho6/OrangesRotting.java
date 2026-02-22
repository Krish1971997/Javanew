package leetcodeZoho6;

import java.util.LinkedList;
import java.util.Queue;

public class OrangesRotting {
	public static void main(String[] args) {
		int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		System.out.println(findMinNoOfMinutes(grid));
	}

	private static int findMinNoOfMinutes(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;

		int freshOranges = 0;
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 2) {
					queue.offer(new int[] { i, j });
				} else if (grid[i][j] == 1)
					freshOranges++;
			}
		}

		if (freshOranges == 0) {
			return 0;
		}

		int[] rowDir = { -1, 1, 0, 0 };
		int[] colDir = { 0, 0, -1, 1 };
		int minutes = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			minutes++;

			for (int j = 0; j < size; j++) {

				int[] current = queue.poll();
				int currRow = current[0];
				int currCol = current[1];

				for (int i = 0; i < 4; i++) {
					int newRow = currRow + rowDir[i];
					int newCol = currCol + colDir[i];

					if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col && grid[newRow][newCol] == 1) {
						grid[newRow][newCol] = 2;
						queue.offer(new int[] { newRow, newCol });
						freshOranges--;
					}
				}
			}

			if (freshOranges == 0) {
				break;
			}

		}

		return freshOranges == 0 ? minutes : -1;
	}
}
