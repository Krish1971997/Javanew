package leetcodeZoho2;

public class SingleNumber {
	
	public static void main(String[] args) {
		int arr[]= {1,1,2,2,3,3,4,5,6,6,7};
		System.out.println(find(arr));
	}
	static int find(int arr[]) {
		int l=0;
		int h=arr.length-1;
		while(l<h) {
			int mid=(l+h)/2;
			if(mid%2==1)
				mid--;
			
			if(arr[mid]==arr[mid+1]) {
				l=mid+2;
			}else
				h=mid;
		}
		
		return arr[l];
	}

}
