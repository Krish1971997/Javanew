package leetcodeZoho5_dp;

public class PathBy4Directions {
	public static void main(String[] args) {
		int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
		boolean[][] visited=new boolean[arr.length][arr[0].length];
		System.out.println(find(arr,0,0,visited));
	}

	private static int find(int[][] arr, int i, int j, boolean[][] visited) {
		
		if(i==arr.length-1 && j==arr[0].length-1)
			return 1;
		
		if( i<0 ||i>=arr.length || j>=arr[0].length ||j<0||visited[i][j])
			return 0;
		
		visited[i][j]=true;
		
		int left=find(arr,i,j-1,visited);
		int right=find(arr,i,j+1,visited);
		int top=find(arr,i-1,j,visited);
		int down=find(arr,i+1,j,visited);
		
		visited[i][j]=false;
		
		return left+right+top+down;
	}
}
