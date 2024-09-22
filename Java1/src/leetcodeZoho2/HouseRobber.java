package leetcodeZoho2;
//https://leetcode.com/problems/house-robber/description/

//This program more complex
public class HouseRobber {
	public static void main(String[] args) {
		int[] arr = {2,7,9,3,1};
		System.out.println(find(arr));
	}
	
	public static int find(int[] arr) {
		
		if(arr.length==0)
			return 0;
		
		int prev1=0,prev2=0;
		for(int i=0;i<arr.length;i++) {
			int temp=prev1;
			prev1=Math.max(prev1, prev2+arr[i]);
			prev2=temp;
			
		}
		return prev1;
	}
	
}