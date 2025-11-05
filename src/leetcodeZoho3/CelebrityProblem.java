package leetcodeZoho3;

public class CelebrityProblem {

	public static int findCelebrity(int[][] matrix, int n) {
		int candidate = 0;

		// Step 1: Find the potential celebrity
		for (int i = 1; i < n; i++) {
			if (matrix[candidate][i] == 1) {
				candidate = i; // Candidate cannot be previous person
			}
		}

		// Step 2: Verify if candidate is an actual celebrity
		for (int i = 0; i < n; i++) {
			if (i != candidate) {
				// Celebrity should be known by everyone and should know no one
				if (matrix[candidate][i] == 1 || matrix[i][candidate] == 0) {
					return -1; // No valid celebrity found
				}
			}
		}

		return candidate; // Return the celebrity index
	}

	public static void main(String[] args) {
		int[][] matrix1 = { { 0, 1, 1, 1 }, 
							{ 0, 0, 1, 1 }, 
							{ 0, 0, 0, 0 }, 
							{ 0, 0, 1, 0 } };

		int[][] matrix2 = { { 0, 0, 1, 0 }, 
							{ 0, 0, 1, 0 }, 
							{ 0, 1, 0, 0 }, 
							{ 0, 0, 1, 0 } };

		int n1 = matrix1.length;
		int n2 = matrix2.length;

		int celebrity1 = findCelebrity(matrix1, n1);
		if (celebrity1 == -1) {
			System.out.println("No celebrity");
		} else {
			System.out.println("Celebrity ID: " + celebrity1);
		}

		int celebrity2 = findCelebrity(matrix2, n2);
		if (celebrity2 == -1) {
			System.out.println("No celebrity");
		} else {
			System.out.println("Celebrity ID: " + celebrity2);
		}
	}
}
