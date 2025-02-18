package leetcodeZoho6;

class MinCostToMoveChips {
	public static int minCostToMoveChips(int[] position) {
		int evenCount = 0, oddCount = 0;

		// Count chips at even and odd positions
		for (int pos : position) {
			if (pos % 2 == 0)
				evenCount++;
			else
				oddCount++;
		}

		// Move smaller group to the other type
		return Math.min(evenCount, oddCount);
	}

	public static void main(String[] args) {
		int[] position = { 1, 2, 3 };
		System.out.println("Minimum cost: " + minCostToMoveChips(position));
	}
}
