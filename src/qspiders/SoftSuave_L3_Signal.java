package qspiders;

import java.util.Scanner;

public class SoftSuave_L3_Signal {

	static Scanner s=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Enter the number of signals: ");
		int noOfSignals=s.nextInt();
		int arrOftime[]=new int[noOfSignals + 1];
		System.out.print("Does the signals have same time differencee (y or n): ");
		char timeDiff=s.next().charAt(0);
		
		switch(timeDiff) {
		case 'y': {
					System.out.print("Enter time difference between each signals including last signal to destination: ");
					int eachSignal=s.nextInt();
					for (int i = 0; i < arrOftime.length; i++) {
						arrOftime[i]=eachSignal;
					}
				} 
				break;
		
		case 'n': {
					for (int i = 0, j=1; i < arrOftime.length; i++) {
						if(j<=noOfSignals) {
							System.out.print("Enter time to signal #"+j++ +":");
							arrOftime[i]=s.nextInt();
						}
						else
						{
							System.out.print("Enter time to reach destination from signal #"+--j+":");
							arrOftime[i]=s.nextInt();
						}  
					}
				} break;
		}
		
		System.out.print("Does all signals are two ways (y or n): ");
		char road=s.next().charAt(0);
		int[]numOfways=new int[noOfSignals];
		
		switch(road){
		
		case 'y':{
					for (int i = 0; i < noOfSignals; i++) {
						numOfways[i]=2;
					} } 
		break;
					
		case 'n':{
					for (int i = 0, j=1; i < noOfSignals; i++) {
						System.out.print("Enter number of paths at signal #"+j++ +"(2-4): ");
						numOfways[i]=s.nextInt();
					 }
					} 
		//break;
		}
		
		System.out.print("Enter the signal time: ");
		int signalTime=s.nextInt();
		
		switch(road) {
		
		case 'y': {
					int totalTime=calculateTotalTime1(noOfSignals, arrOftime, numOfways, signalTime);
					System.out.println("It takes "+totalTime+"seconds to reach destination");
					} break;
		case 'n': {
					int totalTime=calculateTotalTime2(noOfSignals, arrOftime, numOfways, signalTime);
					System.out.println("It takes "+totalTime+"seconds to reach destination");
					} break;
			}
		
	}
	
//	public static int calculateTotalTime(int noOfsignals, int arrOftime[], int []numOfways, int signalTime)
//	{
//		for (int i = 0; i < numOfways.length; i++) {
//			numOfways[i]=numOfways[i]*signalTime;
//		}
//		int totalTime=0;
//		for (int i = 0; i < noOfsignals; i++) {
//			int timeTosignal=totalTime + arrOftime[i];//7 17
//			int waitTime=0;
//			if(timeTosignal < numOfways[i]) {
//				waitTime=Math.abs(numOfways[i]-timeTosignal);
//			}
//			totalTime=Math.abs(timeTosignal+waitTime);
//		}
//		totalTime=totalTime+arrOftime[arrOftime.length-1];
//		return totalTime;
//	}
	
	public static int calculateTotalTime1(int noOfsignals, int arrOftime[], int []numOfways, int signalTime)
	{
		for (int i = 0; i < numOfways.length; i++) {
			numOfways[i]=numOfways[i]*signalTime;
		}
		int totalTime=0;
		for (int i = 0; i <= noOfsignals; i++) {
			if(i<noOfsignals) {
				int timeTosignal=totalTime + arrOftime[i];//7 17
				int waitTime=numOfways[i]-arrOftime[i];//10-7 =3
				totalTime=waitTime+timeTosignal;//3+7
				System.out.println("Total Time "+totalTime);
				//System.out.println(i);
			}
			else if(i<=noOfsignals){
				totalTime +=arrOftime[i];
				System.out.println("Total Time "+totalTime);
			}
		}
		//totalTime=totalTime;
		return totalTime;
	}
		
	public static int calculateTotalTime2(int noOfsignals, int arrOftime[], int []numOfways, int signalTime)
	{  
		for (int i = 0; i < numOfways.length; i++) {
			numOfways[i]=numOfways[i]*signalTime;
		}
		int totalTime=0;
		for (int i = 0; i <= noOfsignals; i++) {
			int timeTosignal=totalTime + arrOftime[i];//7 17
			int waitTime=numOfways[i]-arrOftime[i];//10-7 =3
			totalTime=waitTime+timeTosignal;//3+7
			System.out.println("Total Time "+totalTime);
			
		}
		return totalTime;
	}
	
//	static int totalTimecalc(int num,int totalTime, int []arrOftime,int signalTime)
//	{
//		for (int i = 0; i < arrOftime.length; i++) {
//			int res=num*signalTime *(i);
//			int res1=res-totalTime;
//			if(res1 > res)
//			{
//				res1=0;
//			}
//			totalTime +=res1;
//			totalTime +=arrOftime[i];
//			
//		}
//		return totalTime;
//	}
	
}
