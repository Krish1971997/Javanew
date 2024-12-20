//package qspiders;
//
//import java.util.Scanner;
//
//public class SoftSuvue_L3_singal_1 {
//
//	static Scanner s = new Scanner(System.in);
//
//	public static void main(String[] args) { System.out.println("Enter the number of signals: "); int noofsignals = s.nextInt(); int arroftime[] = new int[noofsignals + 1]; System.out.println("Does the signals have same time difference (y or n)");
//
//	char timeDiff = s.next().charAt(0); 
//	switch (timeDiff) {
//
//	case 'y': {
//
//	System.out.println("Enter time difference between each signals including last signal to destination: ");
//
//	int eachsignal = s.nextInt();
//
//	for (int i=0; i < arroftime.length; i++) {
//
//	arroftime[i] = eachSignal;
//
//	}
//
//	}
//
//	break;
//
//	case 'n': {
//
//	if (j <= noofsignals) {
//
//	for (int i = 0, j = 1; i < arroftime.length; i++)
//	{
//		System.out.println("Enter the time to signal #"+j++); 
//		arroftime[i]= s.nextInt();
//	}
//
//	} else {
//
//	System.out.println("Enter time to reach destination from last signal");
//	arroftime[1] =s.nextInt();
//
//	break;
//
//	System.out.println("Does all the signals are two ways (y or n)"); 
//	char road=s.next().charAt(0);
//
//	int[] numOfWays = new int[noofsignals];
//	
//	switch (road) {
//	case 'y': {
//	}
//
//	int[] numofways new int[noofsignals]; for (int i=0, j= 1; i < noofsignals; i++) {
//
//	numOfWays[1] = 2;
//
//	}
//
//	break; case 'n': (
//
//	for (int i, j = 1; i < noofsignals; i++) {
//
//	System.out.println("Enter the number of paths (2-4) at signal #"+j++);
//
//	numofways[i]s.nextInt();
//
//	System.out.println("Enter the signal time: ");
//
//	int signalTimes.nextInt();
//
//	int totallime calculate TotalTime (pool signals, arroftime, numofways, signalTime); System.out.println("it takes" totallime+" seconds to reach destination");
//
//	public static int calculateTotalTime (int noofsignals, int[] arroftime, int[] numofways, int signalTime) ( numofways[1] numofways[i] signalTime;
//
//	for (int i=0; i<numofways.length; i++) {
//
//	int totalTime 0;
//
//	int timeTosignal totalTime arroftime[i];
//
//	for (int i=0; i<noofsignals; i++) ( int wait time = 0; if(timelosignal< numOfWays[1]) { wait time Math.abs (numofways[i]- timeTosignal);
//
//	totalline Math.abs (timeTosignal + waitfime);
//
//	totalTime totalTime arroftime [arroftime.length-1]; return totalTime;
//	
//	System.out.println("Enter the signal time : "); int signalTimes.nextInt();
//
//	int totalTime calculate total time (noofsignals, arroftime, nunofways, signaltime); System.out.println("it takes" + totalTime seconds to reach destination");
//
//	public static int calculateTotalTime(int noofsignals, int[] arroftime, int[] numOfways, int signaltime) ( for (int i = 0; i < numofways.length; i++) { numOfWays[i]= numofways[i] signalTime;
//
//	int totalTime = 0;
//
//	for (int i=0; i < noofsignals; i++) {
//
//	int timeToSignal totaltime arroftime[i];
//
//	int wait time = 0;
//
//	if(timeToSignal< numOfWays[1]) {
//
//	waitTime Math.abs (numofways[i]- timeTosignal);
//
//	totalTime = Math.abs(timeToSignal waitlime);
//
//	totalTime = totalTime + arroftime(arroftime.length 1]; return totalTime;
//
//	static int totalTimecalc(int num, int totaltime, int[] arroftime, int signaltime) [
//
//	for (int i=0; i<arroftime.length; i++) ( int resnum signalTime(1);
//
//	int res1 res totalTime;
//
//	if (rest > res) { res1 = 0;
//
//	totalTime res1; totallime+arroftime[i];
//
//	return total Time;
//}
