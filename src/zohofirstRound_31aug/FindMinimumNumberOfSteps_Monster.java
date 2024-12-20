package zohofirstRound_31aug;

public class FindMinimumNumberOfSteps_Monster {

	static int stepsCount=Integer.MAX_VALUE;
	public static void main(String[] args) {
		System.out.println("Dimensions of Dungeon");
		char arr[][]=new char[5][4];
		
		int arow=2;
		int acol=0;
		arr[arow][acol]='A';
		
		int grow=3;
		int gcol=3;
		arr[grow][gcol]='G';
		
		int mrow=3;
		int mcol=3;
		arr[mrow][mcol]='M';
		          //row
//		0 1 2 3 	0
//		0 1 2 3 	1
//		0 1 2 3 	2
//		0 1 2 3 	3
//		0 1 2 3 	4
//col	0 1 2 3 
		
		findMinimumStep(arr,arow,acol,grow,gcol,mrow,mcol,0,false);
		System.out.println(stepsCount);
	}

	private static void findMinimumStep(char[][] arr, int arow, int acol, int grow, int gcol,int mrow,int mcol,int steps, boolean b) {
		
		
		if(grow==arow&&acol==gcol) {
			if(stepsCount>steps)
				stepsCount=steps;
			return;
		}
		
		if((!b&&grow==arow)||(gcol==acol)|| (mrow==grow)||(gcol==mcol) )
			return;
		if(arow>grow) {
			findMinimumStep(arr, --arow,acol,grow,gcol,mrow,mcol,++steps,false);
		}else if(arow<grow)
		    findMinimumStep(arr, ++arow,acol,grow,gcol,mrow,mcol,++steps,false);
		
		if(acol>gcol) {
			findMinimumStep(arr, arow,--acol,grow,gcol,mrow,mcol,++steps,true);
		}else if(acol<gcol)
				findMinimumStep(arr, arow,++acol,grow,gcol,mrow,mcol,++steps,true);
		
		if(mrow>grow) {
			findMinimumStep(arr, arow,--acol,grow,gcol,++mrow,mcol,++steps,true);
		}else if(mrow<grow)
				findMinimumStep(arr, arow,++acol,grow,gcol,++mrow,mcol,++steps,true);
		
		if(mcol>gcol) {
			findMinimumStep(arr, arow,--acol,grow,gcol,mrow,--mcol,++steps,true);
		}else if(mcol<gcol)
				findMinimumStep(arr, arow,acol,grow,gcol,mrow,++mcol,++steps,true);
		
		return;
	}
}

