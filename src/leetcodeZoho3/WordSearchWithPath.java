package leetcodeZoho3;

import java.util.ArrayList;
import java.util.List;

public class WordSearchWithPath {

	public List<int[]> findWordPath(char[][] board, String word) {
		List<int[]> path = new ArrayList<>();
		if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
			return path;
		}

		int rows = board.length;
		int cols = board[0].length;

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (dfs(board, word, row, col, 0, path)) {
					return path;
				}
			}
		}

		return new ArrayList<>(); // Return empty path if not found
	}

	private boolean dfs(char[][] board, String word, int row, int col, int index, List<int[]> path) {
		if (index == word.length()) {
			return true;
		}

		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
				|| board[row][col] != word.charAt(index)) {
			return false;
		}

		// Mark the cell as visited
		char temp = board[row][col];
		board[row][col] = '#';
		path.add(new int[] { row, col });

		// Explore all four directions
		boolean found =dfs(board, word, row, col - 1, index + 1, path) 
				|| dfs(board, word, row - 1, col, index + 1, path)
				|| dfs(board, word, row, col + 1, index + 1, path)
				||dfs(board, word, row + 1, col, index + 1, path);

		if (!found) {
			// If not found, backtrack
			path.remove(path.size() - 1);
		}

		// Unmark the cell
		board[row][col] = temp;

		return found;
	}

	public static void main(String[] args) {
		WordSearchWithPath ws = new WordSearchWithPath();
		//char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		char[][] board = { { 'A', 'Z', 'T', 'E','C' }, { 'O', 'Z', 'O', 'N','E' }, 
				{ 'H', 'O', 'M', 'E', 'S' },{ 'S', 'O', 'L', 'I', 'D' } };
		String word1 = "ZOHO";
		String word2 = "SEE";
		String word3 = "ABCB";

		List<int[]> path1 = ws.findWordPath(board, word1);
		List<int[]> path2 = ws.findWordPath(board, word2);
		List<int[]> path3 = ws.findWordPath(board, word3);

		System.out.println("Path for word "+word1+": " + (path1.size()>0?formatPath(path1):"No Match found"));
		System.out.println("Path for word "+word2+": " + (path2.size()>0?formatPath(path2):"No Match found"));
		System.out.println("Path for word "+word3+": " + (path3.size()>0?formatPath(path3):"No Match found"));
	}

	private static String formatPath(List<int[]> path) {
		StringBuilder sb = new StringBuilder();
		for (int[] cell : path) {
			sb.append("(").append(cell[0]+1).append(",").append(cell[1]+1).append(")");
			if (path.indexOf(cell) != path.size() - 1) {
				sb.append(",");
			}
		}
		return sb.toString();
	}
}
