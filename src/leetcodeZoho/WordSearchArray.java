
package leetcodeZoho;

public class WordSearchArray {
    public static void main(String[] args) {
        char board[][] = {
            {'A', 'B', 'C', 'E'}, 
            {'S', 'F', 'C', 'S'}, 
            {'A', 'D', 'E', 'E'}
        };
        String word = "DECF";
        WordSearchArray w = new WordSearchArray();
        System.out.println(w.exist(board, word) ? "True" : "False");
    }

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        
        // Early termination
        if (word.length() > rows * cols) {
            return false;
        }

        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, visited, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int i, int j, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length 
                || board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;

        boolean found = dfs(board, visited, i + 1, j, word, index + 1) 
                || dfs(board, visited, i - 1, j, word, index + 1)
                || dfs(board, visited, i, j + 1, word, index + 1)
                || dfs(board, visited, i, j - 1, word, index + 1);
        
        visited[i][j] = false; // Backtrack
        return found;
    }
}
