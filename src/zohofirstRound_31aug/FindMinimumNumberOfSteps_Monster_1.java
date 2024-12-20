package zohofirstRound_31aug;

public class FindMinimumNumberOfSteps_Monster_1 {

	static int stepsCount = Integer.MAX_VALUE;

	public static void main(String[] args) {
		System.out.println("Dimensions of Dungeon");
		char arr[][] = new char[5][4];

		int arow = 2;
		int acol = 3;
		arr[arow][acol] = 'A';

		int mrow = 1;
		int mcol = 0;
		arr[mrow][mcol] = 'M';

		int grow = 0;
		int gcol = 3;
		arr[grow][gcol] = 'G';
		
//		case 2
//		int arow = 4;
//		int acol = 0;
//		arr[arow][acol] = 'A';
//
//		int mrow = 2;
//		int mcol = 0;
//		arr[mrow][mcol] = 'M';
//
//		int grow = 3;
//		int gcol = 2;
//		arr[grow][gcol] = 'G';

		
		// row
//		0 1 2 3 	0
//		0 1 2 3 	1
//		0 1 2 3 	2
//		0 1 2 3 	3
//		0 1 2 3 	4
//col	0 1 2 3 

		findMinimumStep(arr, arow, acol, grow, gcol, mrow, mcol, 0, false);
		if(stepsCount!=Integer.MAX_VALUE)
			System.out.println(stepsCount);
		else
			System.out.println("Not possible");
	}

	private static void findMinimumStep(char[][] arr, int arow, int acol, int grow, int gcol, int mrow, int mcol,
			int steps, boolean b) {

		if (grow == arow && acol == gcol) {
			if (stepsCount > steps)
				stepsCount = steps;
			return;
		}

		if (arow-1 == mrow && acol == mcol) {
			//System.out.println("Not possible");
			return;
		}

		if (mrow > arr.length || mrow < 0 || mcol > arr[0].length || mcol < 0)
			return;

		if ((!b && gcol == acol) || (grow == arow))
			return;
		if (acol > gcol) {
			findMinimumStep(arr, arow, --acol, grow, gcol, mrow, --mcol, ++steps, false);
		} else if (acol < gcol)
			findMinimumStep(arr, arow, ++acol, grow, gcol, mrow, ++mcol, ++steps, false);

		if (arow > grow) {
			findMinimumStep(arr, --arow, acol, grow, gcol, --mrow, mcol, ++steps, true);
		} else if (arow < grow)
			findMinimumStep(arr, ++arow, acol, grow, gcol, ++mrow, mcol, ++steps, true);

		return;
	}
}
